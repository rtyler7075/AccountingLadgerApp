package com.rt;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Create Static Array List for transactions with the following (Date:, String, String, Int)
//Create transaction public class
// Create static variable called Entries. It will be an ArrayList of Transactions
// create static variable for Payments
//


//Create Main menu
// Show prompt for user showing the possible options and asking for an input
// Create do-while loop that runs unless the user enters "E"\
// Create switch statement that handles cases related to each menu item
//Case 1 Add Deposit(D)
//prompt the user for deposit information and save to CSV file
//Case "2" Make Payment (P)
// prompt user for debit information and save to CSV
//Case "3" Ledger (L)
//Display Ledger Submenu
//Case "4" Exit
//Exit the application

//Ledger Menu
//create method for ledger menu
//Case "1" All(A)
//Display all Entries
//Case "2" Deposits (D)
//Display only the entries that are deposits
//Case "3" Payments (P)
//Display only negative entries
//Case "4" Reports (R)
//Display Reports Sub Menu

//Reports Menu
// run predefined reports or run a custom search
//Case "1" Month to Date
//Show all transactions from this month to current date
//Case "2" Previous Month
//Show all transactions form the previous month
// Case "3" Year to Date
// Show all transactions from this year to current date
// Case "4" Previous
// Show all transactions from the prior year
//Case "5" Search by Vendor
//Prompt the User for Vendor name and compare to the CSV file
//print the transactions with matching Strings
public class Ledger {
        private List<Transaction> transactions;

        public Ledger() {
            this.transactions = new ArrayList<>();
        }

        public void addTransaction(Transaction transaction) {
            this.transactions.add(transaction);
        }

        public void displayAllTransactions() {
            List<Transaction> sortedTransactions = new ArrayList<>(this.transactions);
            Collections.sort(sortedTransactions, Collections.reverseOrder());
            for (Transaction transaction : sortedTransactions) {
                System.out.println(transaction);
            }
        }

        public void displayDeposits() {
            for (Transaction transaction : this.transactions) {
                if (transaction.getAmount() >= 0) {
                    System.out.println(transaction);
                }
            }
        }

        public void displayPayments() {
            for (Transaction transaction : this.transactions) {
                if (transaction.getAmount() < 0) {
                    System.out.println(transaction);
                }
            }
        }

        public void searchByVendor(String vendorName) {
            for (Transaction transaction : this.transactions) {
                if (transaction.getVendor().equals(vendorName)) {
                    System.out.println(transaction);
                }
            }
        }

    public void addDeposit() {
    }

    public void makePayment() {
    }

    public void displayTransactions() {
    }
}



//            static class Reports {
//                public static void main(String[] args) {
//                    Scanner scanner = new Scanner(System.in);
//                    int option;
//
//                    do {
//                        System.out.println("Reports ");
//                        System.out.println("1) Month To Date");
//                        System.out.println("2) Previous Month");
//                        System.out.println("3) Year To Date");
//                        System.out.println("4) Previous Year");
//                        System.out.println("5) Search by Vendor");
//                        System.out.println("0) Back");
//                        System.out.print("Enter your choice: ");
//                        option = scanner.nextInt();
//
//                        if (option == 1) {
//                            runReport("Month To Date");
//                        } else if (option == 2) {
//                            runReport("Previous Month");
//                        } else if (option == 3) {
//                            runReport("Year To Date");
//                        } else if (option == 4) {
//                            runReport("Previous Year");
//                        } else if (option == 5) {
//                            runVendorSearch();
//                        } else if (option == 0) {
//                            System.out.println("Going back to the report page.");
//                        } else {
//                            System.out.println("Invalid choice, please try again.");
//                        }
//                    } while (option != 0);
//                }
//
//                private static void runReport(String reportName) {
//                    // Code to run the report
//                    System.out.println("Running report: " + reportName);
//                }
//
//                private static void runVendorSearch() {
//                    Scanner scanner = new Scanner(System.in);
//                    System.out.print("Enter the vendor name: ");
//                    String vendorName = scanner.nextLine();
//
//                    // Code to search for entries by vendor name
//                    System.out.println("Displaying entries for vendor: " + vendorName);
//                }
//            }

