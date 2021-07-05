package LabQuestion;

interface Bank {
    void printDetail();
}

class Account implements Bank {

    private String account_name;
    private int age;
    private long account_number;
    private double withdrawal = 0.0, deposit = 0.0;

    public Account(String account_name, int age) {
        this.account_name = account_name;
        this.age = age;
        this.account_number = (long) (Math.random() * Math.pow(10, 10));
    }

    public String getAccount_name() {
        return account_name;
    }

    public int getAge() {
        return age;
    }

    public long getAccount_number() {
        return account_number;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public void printDetail() {
        System.out.println("XYZ BANK !!!!!!! \n" +
                "LabQuestion.Account Name = " + getAccount_name() + "\n" +
                "LabQuestion.Account Number = " + getAccount_number() + "\n" +
                "Age = " + getAge() + "\n" +
                "Total Deposit = " + getDeposit() + "\n" +
                "Total Withdrawal = " + getWithdrawal());
    }
}

/**
 * 19. WAP to design a class called Account using the inheritance and static that show all function of bank
 * (withdrawal, deposit) and generate account number dynamically.
 */
public class Question19 {
    public static void main(String[] args) {
        Account a1 = new Account("Ayaan", 20);
        a1.setDeposit(2000);
        a1.printDetail();
    }
}
