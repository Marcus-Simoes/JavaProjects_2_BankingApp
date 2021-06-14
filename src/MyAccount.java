import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MyAccount {

    //Variables of the class
    int balance;
    int pastTransactions;
    String customerName;
    String customerID;

    //Class Constructor
    MyAccount(String c_name, String c_id) {
        customerName = c_name;
        customerID = c_id;
    }

    //Method for money deposits
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            pastTransactions = amount;
        }
    }

    //Method to withdraw an amount of money
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            pastTransactions = -amount;
        }
    }

    //Method that shows your past transactions
    void getPastTransactions() {
        if (pastTransactions > 0) {
            System.out.println("Amount deposited: " + pastTransactions);
        } else if (pastTransactions < 0) {
            /*the method Math.abs returns the absolute(positive) value.
            Example:  System.out.println(Math.abs(-5.5)); OUTPUT: 5.5*/
            System.out.println("Withdrawn amount: " + Math.abs(pastTransactions));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    //Method to calculate interest of current funds after a period of time, in that case years.
    void calculateInterest(int years) {
        double interestRate = 0.0185; //Interest rate at 1.85%
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    //Method for the main menu
    void showMenu() throws IOException {
        char option;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome, " + customerName + ".");
        System.out.println("Your ID is: " + customerID);
        System.out.println("=========================");
        System.out.println("Please " + customerName + " choose what do you want to do? " );
        System.out.println("=========================");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Withdraw cash");
        System.out.println("D. View past transactions");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println("=========================");
            System.out.println("Enter an option: ");
            //charAt(0) Returns the character at the specified index (position). 0 in that case
            char option1 = reader.readLine().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println("=========================");

            switch (option){
                //Case A. Check your balance
                case 'A':
                    System.out.println("=========================");
                    System.out.println("Your Balance is: " + balance + "€");
                    System.out.println("=========================");
                    break;

                //Case B. Make a deposit
                case 'B':
                System.out.println("Enter an amount to deposit: ");
                int amount = Integer.parseInt(reader.readLine());
                deposit(amount);
                System.out.println("=========================");
                break;

                //Case C. Withdraw cash
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = Integer.parseInt(reader.readLine());
                    withdraw(amount2);
                    System.out.println("=========================");
                    break;

                //Case D. View past transactions
                case 'D':
                    System.out.println("=========================");
                    getPastTransactions();
                    System.out.println("=========================");
                    break;

                //Case E. Calculate interest
                case 'E':
                    System.out.println("For how many years? ");
                    int years = Integer.parseInt(reader.readLine());
                    calculateInterest(years);
                    break;

                //Case F. Exit users from the account
                case 'F':
                    System.out.println("=========================");
                    break;

                //Default option. Invalid option
                default:
                    System.out.println("Error: invalid input. Please select the options A, B, C, D, E or F");
                    break;
            }

        }while(option != 'F');
        System.out.println("Thank you for choosing us!");
    }
}











