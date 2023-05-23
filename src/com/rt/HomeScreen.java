package com.rt;

import java.util.Scanner;

public class HomeScreen {

            Ledger ledger;
            Reports reports;
            public HomeScreen() {
                this.ledger = new Ledger();
                this.reports = new Reports(this.ledger);
            }

            public void displayOptions() {
                System.out.println("Select an option:");
                System.out.println("D. Add deposit");
                System.out.println("P. Make payment");
                System.out.println("L. Display ledger");
                System.out.println("X. Run reports");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
            }

            public void run() {
                Scanner scanner = new Scanner(System.in);
                int choice;
                do {
                    displayOptions();
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            this.ledger.addDeposit();
                            break;
                        case 2:
                            this.ledger.makePayment();
                            break;
                        case 3:
                            this.ledger.displayTransactions();
                            break;
                        case 4:
                            int reportChoice = this.reports.displayReportMenu();
                            switch (reportChoice) {
                                case 1:
                                    this.reports.generateMTDReport();
                                    break;
                                case 2:
                                    this.reports.generatePrevMonthReport();
                                    break;
                                case 3:
                                    this.reports.generateYTDReport();
                                    break;
                                case 4:
                                    this.reports.generatePrevYearReport();
                                    break;
                                case 5:
                                    this.reports.searchByVendor();
                                    break;
                                default:
                                    System.out.println("Invalid report option");
                                    break;
                            }
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                } while (choice != 5);
            }
        }


//        do {
//            System.out.println("Main Menu ");
//            System.out.println("D) Add Deposit");
//            System.out.println("P) Make Payment");
//            System.out.println("L) Ledger");
//            System.out.println("X) Exit");
//            System.out.print("Enter your choice: ");
//            option = scanner.nextString();
//
//            if (option == "D") {
//                runReport("1) Add Deposit");
//            } else if (option == "P") {
//                runReport("Previous Month");
//            } else if (option == "L") {
//                runReport("Year To Date");
//            } else if (option == "X") {
//                runReport("Previous Year");
//            } else if (option == 0) {
//                System.out.println("Going back to the report page.");
//            } else {
//                System.out.println("Invalid choice, please try again.");
//            }
//        } while (option != 0);
//    }
//
//
//    public void AddDeposit() {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Please enter the deposit amount: ");
//            double deposit = scanner.nextDouble();
//            System.out.println("You have deposited: " + deposit);
//        }
//
//        public void Payment() {
//                Scanner scanner = new Scanner(System.in);
//
//                System.out.print("Please enter your debit card number: ");
//                String cardNumber = scanner.nextLine();
//
//                System.out.print("Please enter the card's expiration date (MM/YY): ");
//                String expirationDate = scanner.nextLine();
//
//                System.out.print("Please enter the card's CVV code: ");
//                int cvvCode = scanner.nextInt();
//
//                System.out.println("Thank you for providing your debit card information.");
//
//                System.exit(0);
//            }

