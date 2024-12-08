package org.example;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TransactionReportGenerator {

    public static void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 найбільших витрат:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }


    //Ця функція printExpenseReportByCategoryAndMonth генерує та виводить звіт про витрати за
    public static void printExpenseReportByCategoryAndMonth(List<Transaction> transactions) {
        Map<String, Map<String, Double>> report = new HashMap<>();

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                String month = transaction.getDate().substring(3);
                String description = transaction.getDescription();

                report.putIfAbsent(description, new HashMap<>());
                report.get(description).putIfAbsent(month, 0.0);

                report.get(description).compute(month, (k, currentAmount) -> currentAmount + Math.abs(transaction.getAmount()));
            }
        }

        System.out.println("Звіт про витрати:");
        for (String category : report.keySet()) {
            System.out.print(category + ": ");
            for (String month : report.get(category).keySet()) {
                double amount = report.get(category).get(month);
                System.out.print(month + " - " + amount + " грн ");
                // Виводимо зірки
                int stars = (int) (amount / 1000);
                System.out.print("(" + "*".repeat(stars) + ") ");
            }
            System.out.println();
        }
    }

}
