package brishtiPractice.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        while (true) {
            try {
                int num1, num2, operation;
                Scanner sc = new Scanner(System.in);


                System.out.println("\n");
                System.out.print("Enter number 1 :- ");
                num1 = sc.nextInt();
                System.out.print("Enter number 2 :- ");
                num2 = sc.nextInt();

                System.out.print("""
                        1. Addition
                        2. Subtraction
                        3. Multiplication
                        4. Division
                        5. Exit
                                """);

                System.out.print("Enter your operation :- ");
                operation = sc.nextInt();


                switch (operation) {
                    case 1:
                        Operation.add(num1, num2);
                        break;
                    case 2:
                        Operation.subtract(num1, num2);
                        break;
                    case 3:
                        Operation.multiply(num1, num2);
                        break;
                    case 4:
                        Operation.divide(num1, num2);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid operation");
                }
            } catch (ArithmeticException e) {
                System.out.println("No number can be divided by zero");
            }
            catch (Exception e){
                System.out.println("Exception caught " + e);
            }
        }

    }
}
