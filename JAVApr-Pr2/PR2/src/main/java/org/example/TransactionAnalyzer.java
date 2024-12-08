package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public abstract class TransactionAnalyzer {

    // Метод для розрахунку загального балансу
    public static double calculateTotalBalance(List<Transaction> transactions) {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    // Тут будуть інші методи для аналізу транзакцій


    // Ця функція рахує кількість транзакцій, що сталися у зазначений місяць та рік.

    public static int countTransactionsByMonth(String monthYear, List<Transaction> transactions) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    // Ця функція знаходить і повертає 10 найбільших витрат (найменших за значенням, оскільки суми витрат є від'ємними).

    public static List<Transaction> findTopExpenses(List<Transaction> transactions) {
        List<Transaction> expenses = new ArrayList<>();

        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                expenses.add(t);
            }
        }

        expenses.sort(Comparator.comparing(Transaction::getAmount));

        if (expenses.size() > 10) {
            return expenses.subList(0, 10);
        } else {
            return expenses;
        }
    }

    public static Transaction findMaxExpense(List<Transaction> transactions) {
        Transaction maxExpense = null;

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                if (maxExpense == null || transaction.getAmount() > maxExpense.getAmount()) {
                    maxExpense = transaction;
                }
            }
        }

        return maxExpense;
    }

    public static Transaction findMinExpense(List<Transaction> transactions) {
        Transaction minExpense = null;

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                if (minExpense == null || transaction.getAmount() < minExpense.getAmount()) {
                    minExpense = transaction;
                }
            }
        }
        return minExpense;
    }
}