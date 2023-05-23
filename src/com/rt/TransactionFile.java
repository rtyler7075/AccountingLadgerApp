package com.rt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;

public class TransactionFile {
        private static final String FILENAME = "transactions.csv";

        public static List<Transaction> readTransactions() {
            List<Transaction> transactions = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");

                    String date = parts[0];
                    String time = parts[1];
                    String description = parts[2];
                    String vendor = parts[3];
                    double amount = Double.parseDouble(parts[4]);

                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    transactions.add(transaction);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return transactions;
        }

        public static void appendTransaction(Transaction transaction) {
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME, true)))) {
                pw.println(transaction.getDate() + "|" + transaction.getTime() + "|" +
                        transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
