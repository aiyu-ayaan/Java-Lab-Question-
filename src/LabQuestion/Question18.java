package LabQuestion;

/**
 * <h2>18. Write a program in Java to create a class for Employee having 2 data member code and name. Then
 * create 3 classes Officer, AdminStaff and MStaff. The Officer class has data members designation
 * and pay-scale; the AdminStaff has data members grade and pay-band; the MStaff has data member
 * department and two sub-classes Regular and Casual. The Regular staff has data members level and
 * consolidated-pay and Casual has data member daily-wage. Take all inputs through constructors and
 * write appropriate methods for displaying one data for each type of class.<h2/>
 *
 * @see LabQuestion.Questions for all other question
 */
public class Question18 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Person1");
        Officer o1 = new Officer("designation", "bank");
        AdminStaff a1 = new AdminStaff("A+", "pay_band");
        MStaff m1 = new MStaff("Department",
                new MStaff.Casual("3000"),
                new MStaff.Regular("4", "200"));

        e1.printCodeAndName();
        o1.printDestinationAndPayScale();
        a1.printGradeAndPayBand();
        m1.printDepartmentCasualAndRegular();
    }

    private static class Employee {
        private int code;
        private String name;

        public Employee(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public void printCodeAndName() {
            System.out.println("\n\nCode :- " + code + "\nname :- " + name);
        }
    }

    private static class Officer {
        private String designation;
        private String pay_scale;

        public Officer(String designation, String pay_scale) {
            this.designation = designation;
            this.pay_scale = pay_scale;
        }

        public void printDestinationAndPayScale() {
            System.out.println("\n\nDestination :- " + designation + "\nPay Scale :- " + pay_scale);
        }
    }

    private static class AdminStaff {
        private String grade;
        private String pay_band;

        public AdminStaff(String grade, String pay_band) {
            this.grade = grade;
            this.pay_band = pay_band;
        }

        public void printGradeAndPayBand() {
            System.out.println("\n\nGrade :- " + grade + "\nPayBand :- " + pay_band);
        }
    }

    private static class MStaff {
        private String department;
        private Casual casual;
        private Regular regular;

        public MStaff(String department, Casual casual, Regular regular) {
            this.department = department;
            this.casual = casual;
            this.regular = regular;
        }

        public void printDepartmentCasualAndRegular() {
            System.out.println("\n\nDepartment :- " + department);
            System.out.println("Casual Class" +
                    "\n" + casual.printDailyWage() +
                    "\nRegular class \n" +
                    regular.printLevelAndConsolidatePay());
        }

        static class Casual {
            private String daily_wage;

            public Casual(String daily_wage) {
                this.daily_wage = daily_wage;
            }

            public String printDailyWage() {
                return "Daily Wage :- " + daily_wage;
            }
        }

        static class Regular {
            private String level;
            private String consolidated_pay;

            public Regular(String level, String consolidated_pay) {
                this.level = level;
                this.consolidated_pay = consolidated_pay;
            }

            public String printLevelAndConsolidatePay() {
                return "Level :- " + level + "\nConsolidatePay :- " + consolidated_pay;
            }
        }
    }
}
