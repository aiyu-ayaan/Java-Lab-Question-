package Practice;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AllQuestions {
    public static void main(String[] args) {
                        int num, dem;
                System.out.println("Enter 1 fraction :- ");
                System.out.print("Enter numerator :- ");
                num = new Scanner(System.in).nextInt();
                dem = new Scanner(System.in).nextInt();
                Fraction f1 = new Fraction(num, dem);

                System.out.println("Enter 2 fraction :- ");
                num = new Scanner(System.in).nextInt();
                dem = new Scanner(System.in).nextInt();
                Fraction f2 = new Fraction(num, dem);
                sumFraction(f1, f2);
                subFraction(f1, f2);
                mulFraction(f1, f2);
                divFraction(f1, f2);
    }


    //    LabQuestion.Question 8
    private static void question8() {
        System.out.print("Enter degree (°) :-");
        double degree = new Scanner(System.in).nextDouble();
        double radian = degreeToRadian(degree);
        System.out.println("Given " + degree + " °" + " is equal to " + radian + " Rad");

        double sum = Math.sqrt(Math.abs(Math.sin(radian))) + Math.sqrt(Math.abs(Math.cos(radian)));
        System.out.println("We all know that 'Sin\u00B2(θ) +Cos\u00B2(θ) = 1' where degree <=180" +
                           "\nputting the value in of degree in given equation :-");
        System.out.println("Sin\u00B2(" + degree + ") + " + "Cos\u00B2(" + degree + ")" + " =" + sum);
    }

    private static double degreeToRadian(double degree) {
        return degree * (Math.PI / 180);
    }

    //    LabQuestion.Question 9
    private static void question9() {
        //        Taking size
        System.out.print("Enter the size :- ");
        int size = new Scanner(System.in).nextInt();
        int[] arr = new int[size];

        //        Taking input
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + " :-");
            arr[i] = new Scanner(System.in).nextInt();
        }

        printArr(arr, "Array before sorting");
        //        Sorting array
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr.length; j++)
                if (arr[i] < arr[j])
                    swapNumber(arr, i, j);


        //    Printing sorted array
        printArr(arr, "Array after sorting");

    }

    private static void printArr(int[] arr, String message) {
        System.out.println("\n" + message);
        for (int ar : arr) {
            System.out.print(ar + "\t");
        }
    }

    private static void swapNumber(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //    LabQuestion.Question 10
    private static void question10() {
        System.out.print("Enter number of line to print :- ");
        int n = new Scanner(System.in).nextInt();
        for (int line = 1; line <= n; line++) {
            int C = 1;
            for (int i = 1; i <= line; i++) {
                System.out.print(C + " ");
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }

    //    Question 11
    private static void question11() {
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];
        inputArray(m1, "Enter value of matrix A");
        inputArray(m2, "Enter value of matrix B");
        sumMatrix(m1, m2);
        subMatrix(m1, m2);
        mulMatrix(m1, m2);
    }

    private static void mulMatrix(int[][] mat1, int[][] mat2) {
        int mul[][] = new int[mat1.length][mat2.length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2.length; j++)
                for (int k = 0; k < mat2.length; k++)
                    mul[i][j] += mat1[i][k] * mat2[k][j];
        }
        printArray(mat1, "Matrix A");
        printArray(mat2, "Matrix B");
        printArray(mul, "Their Multiplication :-");
    }

    private static void sumMatrix(int[][] mat1, int[][] mat2) {
        int sum[][] = new int[mat1.length][mat2.length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2.length; j++)
                sum[i][j] = mat1[i][j] + mat2[i][j];
        }
        printArray(mat1, "Matrix A");
        printArray(mat2, "Matrix B");
        printArray(sum, "Their Sum :-");
    }

    private static void subMatrix(int[][] mat1, int[][] mat2) {
        int sub[][] = new int[mat1.length][mat2.length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2.length; j++)
                sub[i][j] = mat1[i][j] - mat2[i][j];
        }
        printArray(mat1, "Matrix A");
        printArray(mat2, "Matrix B");
        printArray(sub, "Their Subtraction :-");
    }

    private static void printArray(int[][] mat, String message) {
        System.out.println(message);
        for (int i = 0; i < mat.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("|");
            System.out.println("");
        }
    }

    private static void inputArray(int[][] mat, String message) {
        System.out.println(message);
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat.length; j++) {
                System.out.print("Enter element " + (i + 1) + " " + (j + 1) + " :- ");
                mat[i][j] = new Scanner(System.in).nextInt();
            }
    }

    //    LabQuestion.Question 12
    private static void question12() {
        //        Input i love programming
        System.out.print("Enter Sentence :- ");
        String name = new Scanner(System.in).nextLine();
        int size = 0;
        int word = name.split("\\s+").length;
        for (char i : name.toCharArray()) {
            size++;
        }
        System.out.println("Input Sentence has " + word + " words and " + size + " characters.");
    }

    //    LabQuestion.Question 13
    private static void question13() {
        System.out.print("Enter Sentence :- ");
        String name = new Scanner(System.in).nextLine();
        int vowel = 0;
        int word = name.split("\\s+").length;

        StringBuilder sb = new StringBuilder();
        name.toUpperCase().chars().distinct().forEach(c -> {
            sb.append((char) c);
        });

        for (char i : sb.toString().toUpperCase().toCharArray()) {
            if (i == 'A' ||
                i == 'E' ||
                i == 'I' ||
                i == 'O' ||
                i == 'U') vowel++;
        }
        System.out.println("Input sentence has " + word + " words and " + vowel + " vowels");
    }

    //    LabQuestion.Question 14
    private static void question14() {
        try {
            System.out.println("Enter choose :- " +
                               "\n1 for NumberFormatException " +
                               "\n2 for ArrayIndexOutOfBoundsException" +
                               "\n3 for ArithmeticException" +
                               "\n :-");
            int exceptionType = new Scanner(System.in).nextInt();
            switch (exceptionType) {
                case 1: {
                    System.out.println("Enter string  :-");
                    String num = new Scanner(System.in).nextLine();
                    int number = Integer.parseInt(num);
                }
                break;
                case 2: {
                    int array[] = {1, 3, 5, 6, 8};
                    for (int i = 0; i <= 6; i++) {
                        System.out.print(array[i] + " ");
                    }
                }
                break;
                case 3: {
                    System.out.println(2 / 0);
                }
                break;
                default:
                    System.out.println("Enter input between 1-3");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println(e);
        }
    }

    //    LabQuestion.Question 17
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

    static void divFraction(Fraction f1, Fraction f2) {
        int dem3 = f1.denominator * f2.numerator;
        int num3 = f1.numerator * f2.denominator;
        lowest(dem3, num3, "Division is :- ");
    }

    static void mulFraction(Fraction f1, Fraction f2) {
        int den3 = f1.denominator * f2.denominator;
        int num3 = f1.numerator * f2.numerator;
        lowest(den3, num3, "Multiplication is :- ");
    }

    static void subFraction(Fraction f1, Fraction f2) {
        int den3 = gcd(f1.denominator, f2.denominator);
        den3 = (f1.denominator * f2.denominator) / den3;

        int num3 = (f1.numerator) * (den3 / f1.denominator) - (f2.numerator) * (den3 / f2.denominator);
        lowest(den3, num3, "Subtraction is :- ");
    }

    static void sumFraction(Fraction f1, Fraction f2) {
        int den3 = gcd(f1.denominator, f2.denominator);
        den3 = (f1.denominator * f2.denominator) / den3;

        int num3 = (f1.numerator) * (den3 / f1.denominator) + (f2.numerator) * (den3 / f2.denominator);
        lowest(den3, num3, "Sum is :- ");
    }

    //    LabQuestion.Question 20
    static void question20() {
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

    //    LabQuestion.Question 21
    static void question21() {
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

    //    Question 23
    private static void question23() {
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

    //    Question 25
    private static void question25() {
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


    //    LabQuestion.Question 15
    private static class Room {
        private int length;
        private int width;

        public Room(int length, int width) {
            this.length = length;
            this.width = width;
        }
    }

    //    Question 16
    private static class Question16 {

        private String property1;
        private int property2;

        public Question16() {
            System.out.println("Empty constructor called");
            //            Empty Constructor
        }

        public Question16(String property1, int property2) {
            System.out.println("parameterize constructor called");
            this.property1 = property1;
            this.property2 = property2;
        }

        Question16(Question16 q) {
            System.out.println("Copy constructor called");
            this.property1 = q.property1;
            this.property2 = q.property2;
        }
    }

    //    LabQuestion.Question 17
    private static class Fraction {
        private int numerator = 1;
        private int denominator = 1;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }
}
