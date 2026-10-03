import java.util.Scanner;

public class Problem4_CityCabFareMeter {

    static abstract class Cab {

        static final double MINIMUM_FARE = 100.0;

        abstract double getRate();

        boolean hasNightService() {
            return false;
        }

        double getFare(double km, boolean night) {
            double fare = km * getRate();

            if (fare < MINIMUM_FARE) {
                fare = MINIMUM_FARE;
            }

            if (night) {
                fare = fare * 1.20;
            }

            return fare;
        }
    }

    static class Mini extends Cab {

        double getRate() {
            return 10.0;
        }
    }

    static class Sedan extends Cab {

        double getRate() {
            return 14.0;
        }

        boolean hasNightService() {
            return true;
        }
    }

    static class SUV extends Cab {

        double getRate() {
            return 18.0;
        }

        boolean hasNightService() {
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            boolean night = time.equals("NIGHT");

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini();
            } else if (type.equals("SEDAN")) {
                cab = new Sedan();
            } else {
                cab = new SUV();
            }

            if (night && !cab.hasNightService()) {

                System.out.println(
                    type + ": night service not available"
                );

            } else {

                double fare = cab.getFare(km, night);

                System.out.printf(
                    "%s: %.2f%n",
                    type, fare
                );

                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}