import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private static List<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Enter an option:");
            System.out.println("1) Create a new account");
            System.out.println("2) Access an existing account");
            System.out.println("3) Display all accounts");
            System.out.println("4) Delete an account");
            System.out.println("5) Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    accessAccount(scanner);
                    break;
                case 3:
                    displayAccounts();
                    break;
                case 4:
                    deleteAccount(scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for choosing our bank services !");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }

        scanner.close();
    }

    private static void createAccount(Scanner scanner) {
        System.out.println("Enter your name:");
        scanner.nextLine(); // Clear the newline character from the input buffer
        String name = scanner.nextLine();
        System.out.println("Enter your Customer ID (integer):");
        int customerId = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                customerId = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid Customer ID. Please enter a valid integer.");
                scanner.next();
            }
        }
        BankAccount account = new BankAccount(name, customerId);
        accounts.add(account);
        System.out.println("Account created successfully!");
        System.out.println();
    }

    private static void accessAccount(Scanner scanner) {
        System.out.println("Enter your name and Customer ID (integer) to access your bank account:\n");
        scanner.nextLine(); // Clear the newline character from the input buffer
        String name = scanner.nextLine();
        int customerId = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                customerId = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid Customer ID. Please enter a valid integer.");
                scanner.next();
            }
        }

        boolean accountExists = false;
        for (BankAccount account : accounts) {
            if (account.customerName.equalsIgnoreCase(name) && account.customerId == customerId) {
                account.menu();
                accountExists = true;
                break;
            }
        }

        if (!accountExists) {
            System.out.println("Account not found. Please check your name and Customer ID.");
            System.out.println();
        }
    }

    private static void deleteAccount(Scanner scanner) {
        System.out.println("Enter the Customer ID of the account you want to delete:");
        int customerId = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                customerId = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid Customer ID. Please enter a valid integer.");
                scanner.next();
            }
        }

        Iterator<BankAccount> iterator = accounts.iterator();
        boolean accountDeleted = false;
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            if (account.customerId == customerId) {
                iterator.remove();
                System.out.println("Account deleted successfully.");
                accountDeleted = true;
                break;
            }
        }

        if (!accountDeleted) {
            System.out.println("Account not found. Please check the Customer ID.");
        }

        System.out.println();
    }

    private static void displayAccounts() {
        System.out.println("Accounts:");
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (BankAccount account : accounts) {
                System.out.println("Name: " + account.customerName);
                System.out.println("Customer ID: " + account.customerId);
                System.out.println("Balance: " + account.balance);
                System.out.println();
            }
        }
    }

    static class BankAccount {
        private double balance;
        private double previousTransaction;
        private String customerName;
        private int customerId;

        BankAccount(String customerName, int customerId) {
            this.customerName = customerName;
            this.customerId = customerId;
        }

        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                previousTransaction = amount;
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Invalid amount. Deposit amount must be greater than zero.");
            }
        }

        void withdraw(double amount) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                previousTransaction = -amount;
                System.out.println("Withdrawal successful.");
            } else if (amount > balance) {
                System.out.println("Insufficient balance. Withdrawal amount exceeds the available balance.");
            } else {
                System.out.println("Invalid amount. Withdrawal amount must be greater than zero.");
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

        void menu() {
            char option;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome, " + customerName);
            System.out.println("\nYour ID: " + customerId);
            System.out.println();

            do {
                System.out.println("********************************************");
                System.out.println("Choose an option:");
                System.out.println("a) Check Balance");
                System.out.println("b) Deposit Amount");
                System.out.println("c) Withdraw Amount");
                System.out.println("d) Previous Transaction");
                System.out.println("e) Exit");
                System.out.println("f) Display Accounts");
                System.out.println("********************************************");
                option = scanner.next().charAt(0);
                System.out.println();

                switch (option) {
                    case 'a':
                        System.out.println("Balance: " + balance);
                        System.out.println();
                        break;
                    case 'b':
                        System.out.println("Enter an amount to deposit:");
                        double depositAmount = 0;
                        try {
                            depositAmount = scanner.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Invalid amount. Please enter a valid deposit amount.");
                            scanner.nextLine(); // Clear the input buffer
                            break;
                        }
                        deposit(depositAmount);
                        System.out.println();
                        break;
                    case 'c':
                        System.out.println("Enter an amount to withdraw:");
                        double withdrawAmount = 0;
                        try {
                            withdrawAmount = scanner.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Invalid amount. Please enter a valid withdrawal amount.");
                            scanner.nextLine(); // Clear the input buffer
                            break;
                        }
                        withdraw(withdrawAmount);
                        System.out.println();
                        break;
                    case 'd':
                        System.out.println("Previous Transaction:");
                        getPreviousTransaction();
                        System.out.println();
                        break;
                    case 'e':
                        break;
                    case 'f':
                        displayAccounts();
                        System.out.println();
                        break;
                    default:
                        System.out.println("Choose a correct option to proceed");
                        System.out.println();
                        break;
                }
            } while (option != 'e');

            System.out.println("Proceeding to the accounts section !");
        }
    }
}
