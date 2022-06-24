package Practice;

import java.util.Scanner;

public class Class {

    public static void main(String[] args) {
        String[] mouths = new String[]{
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December",
        };
        System.out.println("Enter date(DD/MM/YYY): ");
        System.out.print("Date :- ");
        int day = new Scanner(System.in).nextInt();
        System.out.print("Month :- ");
        int month = new Scanner(System.in).nextInt();

        System.out.print("Year :- ");
        int year = new Scanner(System.in).nextInt();

        System.out.print(day);
        switch (day) {
            case 1:
            case 21:
            case 31:
                System.out.print("st ");
                break;
            case 2:
            case 22:
                System.out.print("rd ");
                break;
            default:
                System.out.print("th ");
        }
        System.out.print("/ " + mouths[month - 1] + " /" + year);
    }

}
