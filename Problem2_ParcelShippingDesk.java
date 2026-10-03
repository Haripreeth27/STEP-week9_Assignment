import java.util.Scanner;

public class Problem2_ParcelShippingDesk {

    static abstract class Parcel {

        double weight;
        double declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        abstract double getCharge();

        double getInsurance() {
            return 0;
        }

        double getTotal() {
            return getCharge() + getInsurance();
        }
    }

    static class StandardParcel extends Parcel {

        StandardParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        double getCharge() {
            return 40 + (10 * weight);
        }
    }

    static class ExpressParcel extends Parcel {

        ExpressParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        double getCharge() {
            return 80 + (15 * weight);
        }

        double getInsurance() {
            return declaredValue * 0.02;
        }
    }

    static class FragileParcel extends Parcel {

        FragileParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        double getCharge() {
            return 40 + (10 * weight) + 50;
        }

        double getInsurance() {
            return declaredValue * 0.02;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            if (type.equals("STANDARD")) {
                parcel = new StandardParcel(weight, declaredValue);
            } else if (type.equals("EXPRESS")) {
                parcel = new ExpressParcel(weight, declaredValue);
            } else {
                parcel = new FragileParcel(weight, declaredValue);
            }

            double charge = parcel.getCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.getTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}