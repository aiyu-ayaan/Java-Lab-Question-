package LabQuestion;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 16. Write a program in Java to explain the role of the following: <br/>
 * a) Non-parameterized constructor<br/>
 * b) Parameterized constructor<br/>
 * c) Copy constructor
 */
class Question16 {
    private String property1 = "Question16";
    private int property2 = 16;
//    "parameter"

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

    @Override
    public String toString() {
        return "Question16{" +
                "property1='" + property1 + '\'' +
                ", property2=" + property2 +
                '}';
    }
}

class Fraction {
    int numerator = 1;
    int denominator = 1;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}

/**
 * 15. WAP to create a class called Room with two data member length and width and then implement
 * constructor overloading in it.
 */
class Room {
    private int length = 2;
    private int width = 2;

    public Room() {
    }

    public Room(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void printData() {
        System.out.println("Length :- " +
                length + "and width :- " + width);
    }
}


/**
 * 6. WAP to create a class and exhibit the role of static functions (other than Kotlin.main) by declaring,
 * defining and calling them.
 */
class Question6 {
    /**
     * Static function of a class
     */
    public static void staticFunction() {
        System.out.println("""
                We are in static block.
                This function can be called without create
                object of this class""");
    }
}

/**
 * <p>Java lab question solution (Sem 3)</p>
 *
 * @author ayaan
 * @version 1.0
 * @since 24 may 2021
 */

public class Questions {
    public static void main(String[] args) {
//        28
        question29();
    }

    /**
     * 29.WAP to create 4 threads and show exhibit their execution after the call of the “start ( )” method
     */
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
            e.printStackTrace();
        }
    }

    /**
     * 22.WAP to take a string count all vowels and then delete the same from the string.
     */
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
        System.out.println("And Removing all vowels from sentence :- \n" + filter);
    }

    /**
     * 24.WAP to take a string as password and check whether it contains at least two numbers, 3 alphabet
     */
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


    /**
     * 20. WAP to design an application Password.java that produces and prints a random password depending
     * upon name of an individual. If the input is Abdul Kalam then the password would be 33421LAM.
     * Note: take the first name A=1, B=2, D=4, U=21 where 2+1=3, and L=12, where 1+2=3; so the number
     * comes to be 12433, so u can find out
     */
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

    /**
     * 17. WAP to create a class called Fraction with data member numerator and denominator
     * take input (through command line argument) of two fractions and then add, subtract,
     * multiply and divide, finally display the result in reduced term.
     */
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

    static void sumFraction(Fraction f1, Fraction f2) {
        int den3 = gcd(f1.denominator, f2.denominator);
        // LCM = a * b/GCD
        den3 = (f1.denominator * f2.denominator) / den3;

        int num3 = (f1.numerator) * (den3 / f1.denominator) + (f2.numerator) * (den3 / f2.denominator);
        lowest(den3, num3, printFinalFraction(f1, f2, " + "));
    }

    static void subFraction(Fraction f1, Fraction f2) {
        int den3 = gcd(f1.denominator, f2.denominator);
        // LCM = a * b/GCD
        den3 = (f1.denominator * f2.denominator) / den3;

        int num3 = (f1.numerator) * (den3 / f1.denominator) - (f2.numerator) * (den3 / f2.denominator);
        lowest(den3, num3, printFinalFraction(f1, f2, " - "));
    }

    static void mulFraction(Fraction f1, Fraction f2) {
        int den3 = f1.denominator * f2.denominator;
        int num3 = f1.numerator * f2.numerator;
        lowest(den3, num3, printFinalFraction(f1, f2, " * "));
    }

    static void divFraction(Fraction f1, Fraction f2) {
        int dem3 = f1.denominator * f2.numerator;
        int num3 = f1.numerator * f2.denominator;
        lowest(dem3, num3, printFinalFraction(f1, f2, " ÷ "));
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


    /**
     * 21. WAP to draw a format like
     */
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


    /**
     * 26. Write a program in Java to print a format like,
     */
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

    /**
     * 1. WAP to show the characteristic of a number. {E.g. 24 it has two coefficients 2 in tens position and 4 in units
     * position. It is composed of 2 and 3. It is a positive number. Also show whether it is odd or even.
     */
    private static void question1() {
        int ones, tens;
        System.out.print("Enter number :- ");
        int number = new Scanner(System.in).nextInt();
        String coEfficient = String.valueOf(number);
        ones = number % 10;
        tens = number / 10;
        int finalCoefficient = (coEfficient.contains("-"))
                ? new StringBuilder(coEfficient).deleteCharAt(0).toString().length()
                : coEfficient.length();

        System.out.println(number + " it has " + finalCoefficient + " coefficient");
        if (coEfficient.length() != 1) System.out.println("At tens place " + tens);
        System.out.println("At Ones Place " + ones);

//        Is Positive or not

        String isPositive = (number > 0) ? "Is positive Number" : "Is negetive number";
        System.out.println(isPositive);

//        Is event or not
        String isEvent = (number % 2 == 0) ? "Is even number" : "Is not event number ";
        System.out.println(isEvent);
    }

    /**
     * 2. WAP to take input through command line argument and do the following:
     * a) Check whether the number is prime.
     * b) Generate the reverse a number.
     */
    private static void question2() {
        System.out.print("Enter the number :- ");
        int num = new Scanner(System.in).nextInt();
//        Check For prime
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        String isPrime = (!flag) ? num + " is Prime Number" : num + " is not Prime Number";
        System.out.println(isPrime);
//        Reverse
        String reverse = new StringBuilder((String.valueOf(num))).reverse().toString();
        System.out.println("Reverse of Number is " + reverse);
    }

    /**
     * 3. Write a menu driven program using switch in Java to perform following:
     * a) For input of 1, check whether the number is prime
     * b) For input of 3, find the factors of the number
     * c) For input of 5, check the number is odd or even.
     */
    private static void question3() {
        while (true) {
            System.out.println("\n\n1 for check weather the number is prime. \n" +
                    "3 for find the factor of the number. \n" +
                    "5 for check the number is odd or even.\n" +
                    "0 for exit !!");
            System.out.println("");
            System.out.print("Enter condition :- ");
            int condition = new Scanner(System.in).nextInt();
            switch (condition) {
//                Prime Check
                case 1:
                    System.out.println("Check number is prime or not !!");
                    System.out.print("Enter the number :- ");
                    int prime = new Scanner(System.in).nextInt();
                    // Check For prime
                    boolean flag = false;
                    for (int i = 2; i <= prime / 2; ++i) {
                        if (prime % i == 0) {
                            flag = true;
                            break;
                        }
                    }
                    String isPrime = (!flag) ? prime + " is Prime Number" : prime + " is not Prime Number";
                    System.out.println(isPrime);
                    break;
//                    Factor
                case 3:
                    System.out.println("List all the factor of given number !!");
                    System.out.print("Enter the number :- ");
                    int factor = new Scanner(System.in).nextInt();
                    for (int i = 1; i <= factor; i++) {
                        if (factor % i == 0)
                            System.out.print(i + "\t");
                    }
                    break;
//                    even or odd
                case 5:
                    System.out.println("Check for odd or even !!");
                    System.out.println("Enter the number");
                    int number = new Scanner(System.in).nextInt();
                    String isEven = (number % 2 == 0) ? number + " is even Number" : number + " is odd number";
                    System.out.println(isEven);
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("Enter valid Input");
            }
        }
    }

    /**
     * 4. Write a program in Java to generate hexadecimal equivalent of a number without using array.
     */
    private static void question4() {
        System.out.print("Enter a decimal number : ");
//        Input from user
        int num = new Scanner(System.in).nextInt();
        int rem;
        String toHex = "";
        while (num > 0) {
            rem = num % 16;
            toHex = returnHex(rem) + toHex;
            num = num / 16;
        }
        System.out.println("Method 2: Decimal to hexadecimal: " + toHex);
    }

    private static char returnHex(int rem) {
        switch (rem) {
            case 1:
                return '1';
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
            default:
                return '0';
        }
    }

    /**
     * 5. WAP to take two number inputs through command line argument and do the following:
     * a) Check whether two numbers are prime to each other or not.
     * b) Find LCM of two numbers.
     */
    private static void question5() {
        System.out.print("Enter num1 :- ");
        int num1 = new Scanner(System.in).nextInt();
        System.out.print("Enter num2 :- ");
        int num2 = new Scanner(System.in).nextInt();
//        Hcf
        int hcf = hcf(num1, num2);
//        lcm
        int lcm = lcm(num1, num2);
//        Printing lcm of the number
        System.out.println("Lcf of " + num1 + " and " + num2 + " is " + lcm);
//        Is prime or not
        String isPrimeToEachOther = (hcf == 1)
                ? num1 + " and " + num2 + " is Prime to each Other"
                : num1 + " and " + num2 + " is not Prime to each Other";
        System.out.println(isPrimeToEachOther);
    }

    static int hcf(int a, int b) {
        if (b == 0) return a;
        return hcf(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a / hcf(a, b)) * b;
    }

    /**
     * 7. WAP to compute and display the count of occurrence of 4 in a number. E.g. 4564 will compute 2.
     */
    private static void question7() {
        System.out.print("Enter Number :- ");
        int num = new Scanner(System.in).nextInt();
        System.out.print("Enter number to check count :- ");
        int n = new Scanner(System.in).nextInt();
        String number = String.valueOf(num);
        String occ = String.valueOf(n);
        String occurrence = (number.contains(occ))
                ? n + " occurred " + findOccurrence(occ.charAt(0), number) + " times in given number " + num
                : "Enter valid number for check !!";

        System.out.println(occurrence);
    }

    public static String findOccurrence(char n, String number) {
        int occurrence = 0;
        for (int i = 1; i <= number.length(); i++) {
            if (n == number.charAt(i - 1)) {
                occurrence++;
            }
        }
        return String.valueOf(occurrence);
    }


    /**
     * 8 .WAP to take an angle value in degrees and then compute the equivalent radians and then prove.
     */
    private static void question8() {
        System.out.print("Enter degree (°) :-");
        double degree = new Scanner(System.in).nextDouble();
        double radian = degreeToRadian(degree);
        System.out.println("Given " + degree + " °" + " is equal to " + radian + " Rad");

        double sum = Math.sqrt(Math.abs(Math.sin(radian))) + Math.sqrt(Math.abs(Math.cos(radian)));
        System.out.println("We all know that 'Sin\u00B2(θ) +Cos\u00B2(θ) = 1' where degree <=180" +
                "\nputting the value in of degree in given equation :-");
        System.out.println("Sin\u00B2(" + degree + ") + " + "Cos\u00B2(" + degree + ")" + " =" + (int) sum);
    }

    private static double degreeToRadian(double degree) {
        return degree * (Math.PI / 180);
    }

    /**
     * 9. WAP to sort a list of numbers in ascending order.
     */
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
                if (arr[i] > arr[j])
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


    /**
     * 10. WAP to generate Pascal’s Triangle using a square matrix.
     */
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

    /**
     * 11. Write a program in Java to take input of two 3×3 matrices through command line argument and then:
     * a) Add them up and display the result
     * b) Subtract them and display the result
     * c) Multiply them and display product
     */
    private static void question11() {
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];
        inputArray(m1, "Enter value of matrix A");
        inputArray(m2, "Enter value of matrix B");
        while (true) {
            System.out.println("""
                    1. For Add.
                    2. For Subtract.
                    3. For Multiply.
                    4. Exit.
                    Enter Your Operation :-
                    """);
            var operation = new Scanner(System.in).nextInt();
            switch (operation) {
                case 1 -> sumMatrix(m1, m2);
                case 2 -> subMatrix(m1, m2);
                case 3 -> mulMatrix(m1, m2);
                case 4 -> System.exit(0);
                default -> System.out.println("Enter Valid Operation Number :- ");
            }
        }
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

    /**
     * 12.WAP to count the number of words, characters in a sentence.
     */
    private static void question12() {
        System.out.print("Enter your sentence :- ");
        var message = new Scanner(System.in).nextLine();
        System.out.println("Your Sentence contains " +
                countChars(message) + " chars and " +
                countWords(message) + " words");
    }

    private static int countChars(String s1) {
        return s1.toCharArray().length;
    }

    private static int countWords(String s1) {
        var regex = "\s+";
        return s1.split(regex).length;
    }

    /**
     * 13.Write a program in Java to take input of a sentence through command line argument and then count
     * the number of words and vowels.
     */
    private static void question13() {
        System.out.print("Enter your sentence :- ");
        var message = new Scanner(System.in).nextLine();
        System.out.println("Your sentence contain " +
                countVowels(message) + " vowels and " +
                countWords(message) + " words.");
    }

    private static int countVowels(String s1) {
        int[] size = new int[1];
        s1.toUpperCase().chars().forEach(c -> {
            if (c == 'A' ||
                    c == 'E' ||
                    c == 'I' ||
                    c == 'O' ||
                    c == 'U') size[0]++;
        });
        return size[0];
    }

    /**
     * 14. WAP to handle the Exception using try and multiple catch block; the exceptions that you will handle
     * are, number format error, array bound error and divide by zero.
     */
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
                    case 4 -> System.exit(0);
                    default -> System.out.println("Enter input between 1-3");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | ArithmeticException e) {
                e.printStackTrace();
            }
        }
    }
}



