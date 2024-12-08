import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        try {
            // Запитуємо два числа у користувача
            System.out.print("Введіть перше число: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Введіть друге число: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            // Запитуємо, яку операцію користувач хоче виконати
            System.out.print("Виберіть операцію (+, -, *, /, sqrt): ");
            String operation = scanner.nextLine();

            double result = 0;

            // Виконуємо операцію на основі вибору користувача
            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    break;
                case "sqrt":
                    // Викликаємо обчислення квадратного кореня, тільки для першого числа
                    result = calculator.sqrt(num1);
                    break;
                default:
                    System.out.println("Невірна операція.");
                    return;
            }

            System.out.println("Результат: " + result);

        } catch (ArithmeticException e) {
            // Обробка ділення на нуль
            System.out.println("Помилка: " + e.getMessage());
        } catch (InvalidInputException e) {
            // Обробка некоректних вхідних даних
            System.out.println("Помилка: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Обробка випадків, коли користувач ввів нечислові значення
            System.out.println("Помилка: Введено некоректне число.");
        } finally {
            // Повідомлення про завершення обробки
            System.out.println("Обробка запиту завершена.");
        }

        // Закриваємо сканер
        scanner.close();
    }
}
