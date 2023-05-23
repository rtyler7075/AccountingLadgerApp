package com.rt;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Reports {

        private Ledger ledger;

        public Reports(Ledger ledger) {
            this.ledger = ledger;
        }

        public void generateMTDReport() {
            LocalDate now = LocalDate.now();
            LocalDate startOfMonth = now.withDayOfMonth(1);
            double total = 0;
            for (Transaction transaction : this.ledger.getTransactions()) {
                if (transaction.getDate().isAfter(startOfMonth.minusDays(1)) && transaction.getDate().isBefore(now.plusDays(1))) {
                    total += transaction.getAmount();
                }
            }
            System.out.printf("Month-to-date report (%s - %s): %.2f%n", startOfMonth.format(DateTimeFormatter.ISO_LOCAL_DATE), now.format(DateTimeFormatter.ISO_LOCAL_DATE), total);
        }

        public void generatePrevMonthReport() {
            LocalDate now = LocalDate.now();
            Month prevMonth = now.minusMonths(1).getMonth();
            Year year = now.minusMonths(1).getYear();
            MonthYear monthYear = new MonthYear(prevMonth, year);
            double total = 0;
            for (Transaction transaction : this.ledger.getTransactions()) {
                if (transaction.getMonthYear().equals(monthYear)) {
                    total += transaction.getAmount();
                }
            }
            System.out.printf("Previous month report (%s): %.2f%n", monthYear, total);
        }

        public void generateYTDReport() {
            LocalDate now = LocalDate.now();
            int year = now.getYear();
            double total = 0;
            for (Transaction transaction : this.ledger.getTransactions()) {
                if (transaction.getYear() == year) {
                    total += transaction.getAmount();
                }
            }
            System.out.printf("Year-to-date report (%d): %.2f%n", year, total);
        }

        public void generatePrevYearReport() {
            LocalDate now = LocalDate.now();
            int prevYear = now.minusYears(1).getYear();
            double total = 0;
            for (Transaction transaction : this.ledger.getTransactions()) {
                if (transaction.getYear() == prevYear) {
                    total += transaction.getAmount();
                }
            }
            System.out.printf("Previous year report (%d): %.2f%n", prevYear, total);
        }

        public void searchByVendor() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter vendor name: ");
            String vendorName = scanner.nextLine();
            for (Transaction transaction : this.ledger.getTransactions()) {
                if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                    System.out.println(transaction);
                }
            }
        }

        public int displayReportMenu() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a report option:");
            System.out.println("1. Month-to-date");
            System.out.println("2. Previous month");
            System.out.println("3. Year-to-date");
            System.out.println("4. Previous year");
            System.out.println("5. Custom search");
            System.out.print("Enter your choice: ");
            return scanner.nextInt();
        }
    }

}
