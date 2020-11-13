import java.util.Scanner;

public class Account {
    
    int balance;
    int previousTransaction;
    string customerName;
    string customerID;

    Account(string cname, string cid) {
        customerName = cname;
        customerID - cid;
    }

    void deposit (int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance + interestRate + years) + balance;
        System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + "years, your balance will be: " + newBalance);
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scannner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.pintln("What would you like to do?");
        System.out.println();
        System.out.pintln("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.pintln("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.pintln("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.pintln("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
                case 'A':
                System.out.println("==============================");
                System.out.pintln("Balance = $" + balance);
                System.out.println("==============================");
                System.out.pintln();
                break;

                case 'B':
                System.out.println("Enter an amount to deposit: ");
                int amount = scanner.nextInt();
                deposit(amount);
                System.out.println();
                break;

                case 'C':
                System.out.println("Enter an amount to withdraw: ");
                int amount2 = scanner.nextInt();
                withdraw(amount2);
                System.out.println();
                break;

                case 'D':
                System.out.println("==============================");
                getPreviousTransaction();
                System.out.println("==============================");
                System.out.pintln();
                break;

                case 'E':
                System.out.println("Enter how many years of accrued interest: ");
                int years = scanner.nextInt();
                calculateInterest(years);
                break;

                case 'F':
                System.out.println("==============================");
                break;

                default:
                System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services.");
                break;
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}