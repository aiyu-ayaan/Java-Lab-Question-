package Practice;


import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) {
        StaticClass.printFibonacci(15);
    }

    public static class StaticClass {
        static void printFibonacci(int n) {
            int num1 = 0, num2 = 1;
            int counter = 0;
            while (counter < n) {
                System.out.print(num1 + " ");
                int num3 = num2 + num1;
                num1 = num2;
                num2 = num3;
                counter = counter + 1;
            }
        }
    }
}
//    var pattern = "EMP[MSAC]\\d{4}";
//        var string = "EMPA1524";
//        System.out.println(Pattern.matches(".{3}A.{4}", string));