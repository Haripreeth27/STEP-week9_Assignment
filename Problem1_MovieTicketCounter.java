import java.util.Scanner;

public class Problem1_MovieTicketCounter {

    static abstract class Ticket {

        static final double CONVENIENCE_FEE = 20.0;

        abstract double getPrice();

        double getAmount(int count) {
            return (getPrice() + CONVENIENCE_FEE) * count;
        }
    }

    static class RegularTicket extends Ticket {
        double getPrice() {
            return 150.0;
        }
    }

    static class PremiumTicket extends Ticket {
        double getPrice() {
            return 250.0;
        }
    }

    static class ReclinerTicket extends Ticket {
        double getPrice() {
            return 400.0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            if (seat.equals("REGULAR")) {
                ticket = new RegularTicket();
            } else if (seat.equals("PREMIUM")) {
                ticket = new PremiumTicket();
            } else {
                ticket = new ReclinerTicket();
            }

            double amount = ticket.getAmount(count);

            System.out.printf("%s: %.2f%n", seat, amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}