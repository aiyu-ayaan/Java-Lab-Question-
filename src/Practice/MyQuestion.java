package Practice;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MyQuestion {

    public static void main(String[] args) {
//        question29();
        question14();
    }

    //    Question 12
    private static void question12() {
        System.out.print("Enter your sentence :- ");
        var message = new Scanner(System.in).nextLine();
        System.out.println("Your Sentence contains " +
                           countChars(message) + " chars and " +
                           countWords(message) + " words");
    }

    private static int countChars(String s1) {
        var s1ToCharArray = s1.toCharArray();
        var count = 0;
        for (var c : s1ToCharArray) {
            count++;
        }
        return count;
    }

    private static int countWords(String s1) {
        var regex = "\s+";
        return s1.split(regex).length;
    }

    //    Question 13
    private static void question13() {
        System.out.print("Enter your sentence :- ");
        var message = new Scanner(System.in).nextLine();
        System.out.println("Your sentence contain " +
                           countVowels(message) + " vowels and " +
                           countWords(message) + " words.");
    }

    private static int countVowels(String s1) {
        int[] size = new int[1];
        s1.toUpperCase().chars().distinct().forEach(c -> {
            if (c == 'A' ||
                c == 'E' ||
                c == 'I' ||
                c == 'O' ||
                c == 'U') size[0]++;
        });
        return size[0];
    }

    //    LabQuestion.Question 14
    private static void question14() {
        while (true) {
            try {
                System.out.println("""
                        Enter choose :-\s
                        1 for NumberFormatException\s
                        2 for ArrayIndexOutOfBoundsException
                        3 for ArithmeticException
                        4 to exit..
                         :-""");
                int exceptionType = new Scanner(System.in).nextInt();
                switch (exceptionType) {
                    case 1 -> {
                        System.out.println("Enter string  :-");
                        String num = new Scanner(System.in).nextLine();
                        int number = Integer.parseInt(num);
                        System.out.println(number);
                    }
                    case 2 -> {
                        int[] array = {1, 3, 5, 6, 8};
                        for (int i = 0; i <= 6; i++) {
                            System.out.print(array[i] + " ");
                        }
                    }
                    case 3 -> System.out.println(2 / 0);
                    case 4 ->System.exit(0);
                    default -> System.out.println("Enter input between 1-3");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | ArithmeticException e) {
                e.printStackTrace();
            }
        }
    }


    //    Question 17
    private static void question17() {
        int num, dem;
        System.out.println("Enter 1 fraction :- ");
        System.out.print("Enter numerator :- ");
        num = new Scanner(System.in).nextInt();
        System.out.print("Enter denominator :- ");
        dem = new Scanner(System.in).nextInt();
        Fraction f1 = new Fraction(num, dem);

        System.out.println("Enter 2 fraction :- ");
        System.out.print("Enter numerator :- ");
        num = new Scanner(System.in).nextInt();
        System.out.print("Enter denominator :- ");
        dem = new Scanner(System.in).nextInt();
        Fraction f2 = new Fraction(num, dem);
        while (true) {
            System.out.print("""
                    \s\s
                    for addition press 1\s
                    for subtraction press 2\s
                    for multiplication press 3\s
                    for division press 4\s
                    for exit press 5.. \s
                    Enter your operation :-
                    """);
            var operation = new Scanner(System.in).nextInt();
            switch (operation) {
                case 1 -> sumFraction(f1, f2);
                case 2 -> subFraction(f1, f2);
                case 3 -> mulFraction(f1, f2);
                case 4 -> divFraction(f1, f2);
                case 5 -> System.exit(0);
                default -> System.out.println("Enter Valid operation number..");
            }
        }
    }

    static void divFraction(Fraction f1, Fraction f2) {
        int dem3 = f1.denominator * f2.numerator;
        int num3 = f1.numerator * f2.denominator;
        lowest(dem3, num3, printFinalFraction(f1, f2, " ÷ "));
    }

    static void mulFraction(Fraction f1, Fraction f2) {
        int den3 = f1.denominator * f2.denominator;
        int num3 = f1.numerator * f2.numerator;
        lowest(den3, num3, printFinalFraction(f1, f2, " * "));
    }

    static void subFraction(Fraction f1, Fraction f2) {
        int den3 = gcd(f1.denominator, f2.denominator);
        // LCM = a * b/GCD
        den3 = (f1.denominator * f2.denominator) / den3;

        int num3 = (f1.numerator) * (den3 / f1.denominator) - (f2.numerator) * (den3 / f2.denominator);
        lowest(den3, num3, printFinalFraction(f1, f2, " - "));
    }

    static void sumFraction(Fraction f1, Fraction f2) {
        int den3 = gcd(f1.denominator, f2.denominator);
        den3 = (f1.denominator * f2.denominator) / den3;

        int num3 = (f1.numerator) * (den3 / f1.denominator) + (f2.numerator) * (den3 / f2.denominator);
        lowest(den3, num3, printFinalFraction(f1, f2, " + "));
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static void lowest(int den3, int num3, String message) {
        int common_factor = gcd(num3, den3);
        den3 = den3 / common_factor;
        num3 = num3 / common_factor;
        System.out.println(message + num3 + "/" + den3);
    }

    static String printFinalFraction(Fraction f1, Fraction f2, String m) {
        return f1.numerator + "/" + f1.denominator + m +
               f2.numerator + "/" + f2.denominator + "= ";
    }


    //    Question 20
    private static void question20() {
        while (true) {
            System.out.print("Enter your full name :- ");
            var name = new Scanner(System.in).nextLine();
            if (name.equals("0")) System.exit(0);
            var password = new StringBuilder();
            var splitName = returnSplitName(name.toUpperCase());


            var nameToNumber = returnNumber(splitName[0]);
            var nameToLast3Digits = returnLast3DigitOfSurname(splitName);

//        Merging Password
            password.append(nameToNumber).append(nameToLast3Digits);
            System.out.println("Your password to given name is :-\n" + password);
            System.out.println("Press 0 to exit !!!");
        }
    }

    private static String returnLast3DigitOfSurname(String[] name) {
        StringBuilder password = new StringBuilder();
        var pos = 0;
        for (var n : name) {
            if (pos != 0) {
                var revName = new StringBuilder();
                for (int i = 1; i <= 3; i++) {
                    revName.append(n.charAt(n.length() - i));
                }
                password.append(revName.reverse());
            }
            pos++;
        }
        return password.toString();
    }

    private static String returnNumber(String name) {
        var password = new StringBuilder();
        for (var i : name.toCharArray()) {
            var op = ((int) i - 64);
            if (op >= 10) {
                var sum = 0;
                var digits = String.valueOf(op);
                for (var d : digits.toCharArray()) {
                    sum += Integer.parseInt(String.valueOf(d));
                }
                password.append(sum);
            } else {
                password.append(op);
            }
        }
        return password.reverse().toString();
    }

    private static String[] returnSplitName(String name) {
        return name.split("\\s+");
    }

    //    Question 21
    static void question21() {
        //        Upper Loop
        for (int i = 0; i < 5; i++) {
            for (int space = 1; space <= (4 - i); space++)
                System.out.print(" ");

            for (int j = 1; j <= i; j++)
                System.out.print("*");

            for (int j = 2; j <= i; j++)
                System.out.print("*");

            System.out.println("");
        }
        //            lower loop
        for (int i = 3; i >= 1; i--) {
            for (int space = 1; space <= (4 - i); space++)
                System.out.print(" ");

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    //    Question 22
    static void question22() {
        System.out.print("Enter a sentence :- ");
        String input = new Scanner(System.in).nextLine();
        final int[] count = {0};
        input.toUpperCase().chars().distinct().forEach(c -> {
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count[0] += 1;
            }
        });
        String filter = input.replaceAll("[aeiouAEIOU]", "");
        System.out.println("Total number of vowels in sentence :- " + count[0]);
        System.out.println("And Removing all vowels from sentance :- \n" + filter);
    }


    //    Question 24
    private static void question24() {
        System.out.print("Enter User Name :- ");
        var userName = new Scanner(System.in).nextLine();
        System.out.print("""
                Enter Password
                (Password must contains at least two numbers, 3 alphabets)
                 :-""");
        var userPassword = new Scanner(System.in).nextLine().trim();
        var isValid = (validatePassword(userPassword)) ?
                "Enter password passes all given condition \n" +
                "Welcome " + userName :
                "Enter password not passes all given condition";
        System.out.println(isValid);
    }

    private static boolean validatePassword(String password) {
        var VALIDATE_EXPRESSION_NUMBER_START = "[0-9]{2,}[a-zA-Z]{3,}";
        var VALIDATE_EXPRESSION_WORD_START = "[a-zA-Z]{3,}[0-9]{2,}";

        return Pattern.matches(VALIDATE_EXPRESSION_NUMBER_START, password)
               || Pattern.matches(VALIDATE_EXPRESSION_WORD_START, password);
    }


    //    Question 26
    private static void question26() {
        for (int i = 4; i >= 1; i--) {
            for (int space = 1; space <= (4 - i); space++)
                System.out.print(" ");

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    //    Question 29
    private static void question29() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 10; i++) System.out.println("In t1");
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i <= 10; i++) System.out.println("In t2");
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i <= 10; i++) System.out.println("In t3");
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i <= 10; i++) System.out.println("In t3");
        });
        try {
            t1.run();
            Thread.sleep(100);
            t2.run();
            Thread.sleep(100);
            t3.run();
            Thread.sleep(100);
            t4.run();
        } catch (Exception e) {
        }
    }

    //    Question 15
    private static class Room {
        private int length;
        private int width;

        public Room(int length, int width) {
            this.length = length;
            this.width = width;
        }
    }

    //    Question 16


    //   Question 17
    private static class Fraction {
        private int numerator = 1;
        private int denominator = 1;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }
}
