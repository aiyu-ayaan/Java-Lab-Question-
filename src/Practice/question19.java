package Practice;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Account { // creating account class having detail of the the customer
    public int intialamount;
    public String name;
    public long accountnumber;
    public int age;
    public String sex;
    public int pin;

    // creating constructor class for assigning values to it
    Account(int intialamount, String name, long accountnumber, int pin) {
        this.intialamount = intialamount;
        this.name = name;
        this.accountnumber = accountnumber;
        this.pin = pin;
    }

    void withdrawalmoney(int x) {
        if (intialamount < 0) {
            System.out.println("Can't withdrawal because there is zero balance in your account.");
        } else {

            if (x > intialamount) {
                System.out.println("Not sufficient ammount in your account.");
            } else {
                intialamount = intialamount - x;
                System.out.println("Money has been debited from your bank.");
                System.out.println("\tRs " + x);
                System.out.println("Please Collect your money.");
            }
        }

    }

    void accountdisplay() {

        System.out.println("User : " + name);
        System.out.println("Account number : " + accountnumber);
        System.out.println("Ammount : " + intialamount);
    }

    void depositemoney(int x) {
        intialamount = intialamount + x;

    }
}

class question19 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int randomaccnumber = ThreadLocalRandom.current().nextInt(500000, 600000);
        Account user1 = new Account(20000, "SUSHANT RAJ", randomaccnumber, 4545);
        System.out.println("\t\t---------------FALANA DHIMKANA BANK---------------");
        System.out.println("\n\tWELCOME TO FALANA DHIMKANA BANK\n");
        int option;
        // withdrawalmoney,depositemoney
        do {
            System.out.println("1.Withdrawal Money.");
            System.out.println("2.Deposite Money");
            System.out.println("3.Check Status.");
            System.out.println("4.Exit");
            option = input.nextInt();
            switch (option) {

                case 1:
                    System.out.println("Ammount : " + user1.intialamount);
                    System.out.print("Enter the amount to be withdrawal : ");
                    int withdrawalmoney = input.nextInt();
                    user1.withdrawalmoney(withdrawalmoney);
                    System.out.println("THANK YOU! VISIT AGAIN");
                    break;

                case 2:
                    System.out.print("Ammount to be deposite : ");
                    int depositemoney = input.nextInt();
                    user1.depositemoney(depositemoney);
                    System.out.println("\nMoney has been successfully credited");
                    System.out.println("THANK YOU! VISIT AGAIN");
                    break;

                case 3:
                    user1.accountdisplay();
                    System.out.println("THANK YOU! VISIT AGAIN");
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid Selection !!");
                    System.out.println("Please select a valid option.");
                    break;
            }
        } while (option != 4);

    }
}