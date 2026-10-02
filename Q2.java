
import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanDays();

    LocalDate getDueDate(LocalDate date) {
        return date.plusDays(getLoanDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getLoanDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getLoanDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getLoanDays() {
        return 3;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LocalDate today = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1)
                               .replace("\"", "");

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid type");
            }

            System.out.println(item.title + ": "
                    + item.getDueDate(today));
        }

        sc.close();
    }
}