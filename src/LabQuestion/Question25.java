package LabQuestion;

import java.util.Scanner;

class Rational {
    int numerator;
    int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
}

/**
 * 24. Write a program in Java to create a class called Rational having two data members for numerator and
 * denominator. Take two inputs of rational numbers and perform multiplication and division. Display
 * the result in reduced form.
 */
public class Question25 {
    public static void main(String[] args) {
        int num, dem;
        System.out.println("Enter 1 fraction :- ");
        System.out.print("Enter numerator :- ");
        num = new Scanner(System.in).nextInt();
        System.out.print("Enter denominator :- ");
        dem = new Scanner(System.in).nextInt();
        Rational r1 = new Rational(num, dem);

        System.out.println("Enter 2 fraction :- ");
        System.out.print("Enter numerator :- ");
        num = new Scanner(System.in).nextInt();
        System.out.print("Enter denominator :- ");
        dem = new Scanner(System.in).nextInt();
        Rational r2 = new Rational(num, dem);

        divFraction(r1, r2);
        mulFraction(r1, r2);
    }

    static void divFraction(Rational r1, Rational r2) {
        int dem3 = r1.denominator * r2.numerator;
        int num3 = r1.numerator * r2.denominator;
        lowest(dem3, num3, printFinalFraction(r1, r2, " ÷ "));
    }

    static void mulFraction(Rational r1, Rational r2) {
        int den3 = r1.denominator * r2.denominator;
        int num3 = r1.numerator * r2.numerator;
        lowest(den3, num3, printFinalFraction(r1, r2, " * "));
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

    static String printFinalFraction(Rational f1, Rational f2, String m) {
        return f1.numerator + "/" + f1.denominator + m +
                f2.numerator + "/" + f2.denominator + "= ";
    }
}
