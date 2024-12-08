// Власне виключення для некоректних вхідних даних
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class Calculator {
    // Додавання
    public double add(double a, double b) {
        return a + b;
    }

    // Віднімання
    public double subtract(double a, double b) {
        return a - b;
    }

    // Множення
    public double multiply(double a, double b) {
        return a * b;
    }

    // Ділення з обробкою виключення при діленні на нуль
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Ділення на нуль неможливе.");
        }
        return a / b;
    }

    // Метод для перевірки вхідних даних
    public double sqrt(double a) throws InvalidInputException {
        if (a < 0) {
            throw new InvalidInputException("Неможливо взяти квадратний корінь з від'ємного числа.");
        }
        return Math.sqrt(a);
    }
}
