package com.sliwinski;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("BestBank!");

    public static void main(String[] args) {

        boolean quit = false;
        int choice;
        while (!quit) {
            printListOfInstructions();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= 1 && choice <= 7) {
                switch (choice) {
                    case 1:
                        addNewBranch();
                        break;
                    case 2:
                        addNewCustomerToBranch();
                        break;

                    case 3:
                        addTransactionForExistingCustomer();
                        break;

                    case 4:
                        showBranches();
                        break;

                    case 5:
                        showCustomers();
                        break;

                    case 6:
                        showBankName();
                        break;
                    case 7:
                        System.out.println("Bye bye!");
                        quit = true;
                        break;
                }
            } else {
                System.out.println("Wrong choice of number!\n");
            }

        }

    }

    public static void printListOfInstructions() {
        System.out.println("1 - add new branch.");
        System.out.println("2 - add new customer to branch.");
        System.out.println("3 - add transaction for existing customer.");
        System.out.println("4 - show branches.");
        System.out.println("5 - show customers.");
        System.out.println("6 - show bank name.");
        System.out.println("7 - quit.");
    }

    public static void addNewBranch() {
        System.out.println("Enter name for new branch:");
        String branchName = scanner.nextLine();
        bank.addNewBranch(branchName);
    }

    public static void addNewCustomerToBranch() {
        if (bank.showListOfBranches()) {
            System.out.println("Enter branch name:");
            String branchName = scanner.nextLine();
            System.out.println("Enter customer name:");
            String customerName = scanner.nextLine();
            if (!bank.customerAlreadyExists(branchName, customerName)) {
                System.out.println("Enter initial amount:");
                double amount = scanner.nextDouble();
                bank.addNewCustomerToExistingBranch(customerName, amount, branchName);
            }
        }
    }

    public static void addTransactionForExistingCustomer() {
        if (bank.showListOfBranches()) {
            System.out.println("Enter branch name:");
            String branchName = scanner.nextLine();
            if (bank.showListOfCustomersForBranch(branchName)) {
                System.out.println("Enter customer name:");
                String customerName = scanner.nextLine();
                System.out.println("Enter amount for transaction:");
                double amount = scanner.nextDouble();
                bank.addTransactionForExistingCustomer(customerName, amount, branchName);
            }
        }
    }

    public static void showBranches() {
        bank.showListOfBranches();

    }

    public static void showCustomers() {
        if (bank.showListOfBranches()) {
            System.out.println("Enter branch name:");
            String branchName = scanner.nextLine();
            bank.showListOfCustomersForBranch(branchName);
        }
    }

    public static void showBankName() {
        System.out.println("Bank name is: " + bank.getName());
    }
}
