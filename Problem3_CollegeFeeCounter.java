import java.util.Scanner;

public class Problem3_CollegeFeeCounter {

    static abstract class Student {

        String name;
        static final double TRANSPORT_FEE = 12000;

        Student(String name) {
            this.name = name;
        }

        abstract double getTuition();

        abstract boolean usesBus();

        double getTotalFee() {
            double total = getTuition();

            if (usesBus()) {
                total += TRANSPORT_FEE;
            }

            return total;
        }
    }

    static class DayScholar extends Student {

        DayScholar(String name) {
            super(name);
        }

        double getTuition() {
            return 40000;
        }

        boolean usesBus() {
            return true;
        }
    }

    static class Hosteller extends Student {

        Hosteller(String name) {
            super(name);
        }

        double getTuition() {
            return 40000 + 60000;
        }

        boolean usesBus() {
            return false;
        }
    }

    static class ScholarshipStudent extends Student {

        ScholarshipStudent(String name) {
            super(name);
        }

        double getTuition() {
            return 20000;
        }

        boolean usesBus() {
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarshipStudent(name);
            }

            double fee = student.getTotalFee();

            System.out.printf(
                "%s: %.2f%n",
                name, fee
            );

            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n",
            totalCollected
        );

        sc.close();
    }
}