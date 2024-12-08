package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        TransactionCSVReader.readTransactions(filePath);
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        TransactionAnalyzer.calculateTotalBalance(transactions);
        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);

        System.out.println("Загальний баланс: " + totalBalance);

        String monthYear = "01-2024";
        int transactionsCount = TransactionAnalyzer.countTransactionsByMonth(monthYear, transactions);
        TransactionReportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);

        Transaction maxExpense = TransactionAnalyzer.findMaxExpense(transactions);
        Transaction minExpense = TransactionAnalyzer.findMinExpense(transactions);
        System.out.println("Найбільша витрата: " + maxExpense);
        System.out.println("Найменша витрата: " + minExpense);

        TransactionReportGenerator.printExpenseReportByCategoryAndMonth(transactions);
    }
}
