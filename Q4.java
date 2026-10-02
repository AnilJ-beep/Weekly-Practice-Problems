
import java.util.Scanner;

abstract class Question {
    String correct, answer;
    double points;

    Question(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return answer.equalsIgnoreCase(correct) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return answer.equalsIgnoreCase(correct) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        String[] keywords = correct.split(",");
        int matched = 0;
        String studentAnswer = answer.toLowerCase();

        for (String word : keywords) {
            if (studentAnswer.contains(word.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) return points * 0.75;
        if (matched == 1) return points * 0.50;
        return 0;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String type = line.substring(0, line.indexOf(' '));
            java.util.regex.Matcher m =
                java.util.regex.Pattern.compile("\"([^\"]*)\"")
                .matcher(line);

            String[] fields = new String[3];
            int j = 0;

            while (m.find() && j < 3) {
                fields[j++] = m.group(1);
            }

            double points = Double.parseDouble(
                line.substring(line.lastIndexOf('"') + 1).trim());

            Question q;

            switch (type) {
                case "MCQ":
                    q = new MCQ(fields[1], fields[2], points);
                    break;
                case "TF":
                    q = new TF(fields[1], fields[2], points);
                    break;
                case "ESSAY":
                    q = new Essay(fields[1], fields[2], points);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid type");
            }

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}