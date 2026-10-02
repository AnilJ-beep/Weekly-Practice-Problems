
import java.util.Scanner;

interface PaymentMethod {
    double calculateAmount(double amount);
}

class CardPayment implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount * 1.01;
    }
}

class BankTransfer implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            double amount = Double.parseDouble(input[1]);

            PaymentMethod payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment();
                    break;
                case "WALLET":
                    payment = new WalletPayment();
                    break;
                case "BANKTRANSFER":
                    payment = new BankTransfer();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid type");
            }

            double adjusted = payment.calculateAmount(amount);
            System.out.printf("%s: %.2f%n", type, adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}