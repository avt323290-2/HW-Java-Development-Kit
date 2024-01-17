import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс для демонстрации работы калькулятора.
 */
public class CalculatorDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Сложение
        int intNum1 = getIntInput("Введите первое целое число для сложения: ", scanner);
        int intNum2 = getIntInput("Введите второе целое число для сложения: ", scanner);
        int intSumResult = Calculator.sum(intNum1, intNum2);
        System.out.println("Сумма целых чисел: " + intSumResult);

        double doubleNum1 = getDoubleInput("Введите первое вещественное число для сложения: ", scanner);
        double doubleNum2 = getDoubleInput("Введите второе вещественное число для сложения: ", scanner);
        double doubleSumResult = Calculator.sum(doubleNum1, doubleNum2);
        System.out.println("Сумма вещественных чисел: " + doubleSumResult);

        // Умножение
        int intMultiplyNum1 = getIntInput("Введите первое целое число для умножения: ", scanner);
        int intMultiplyNum2 = getIntInput("Введите второе целое число для умножения: ", scanner);
        int intMultiplyResult = Calculator.multiply(intMultiplyNum1, intMultiplyNum2);
        System.out.println("Произведение целых чисел: " + intMultiplyResult);

        double doubleMultiplyNum1 = getDoubleInput("Введите первое вещественное число для умножения: ", scanner);
        double doubleMultiplyNum2 = getDoubleInput("Введите второе вещественное число для умножения: ", scanner);
        double doubleMultiplyResult = Calculator.multiply(doubleMultiplyNum1, doubleMultiplyNum2);
        System.out.println("Произведение вещественных чисел: " + doubleMultiplyResult);

        // Деление
        int intDivideNum1 = getIntInput("Введите первое целое число для деления: ", scanner);
        int intDivideNum2 = getIntInput("Введите второе целое число для деления: ", scanner);
        try {
            int intDivideResult = Calculator.divide(intDivideNum1, intDivideNum2);
            System.out.println("Результат деления целых чисел: " + intDivideResult);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        double doubleDivideNum1 = getDoubleInput("Введите первое вещественное число для деления: ", scanner);
        double doubleDivideNum2 = getDoubleInput("Введите второе вещественное число для деления: ", scanner);
        try {
            double doubleDivideResult = Calculator.divide(doubleDivideNum1, doubleDivideNum2);
            System.out.println("Результат деления вещественных чисел: " + doubleDivideResult);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Вычитание
        int intSubtractNum1 = getIntInput("Введите первое целое число для вычитания: ", scanner);
        int intSubtractNum2 = getIntInput("Введите второе целое число для вычитания: ", scanner);
        int intSubtractResult = Calculator.subtract(intSubtractNum1, intSubtractNum2);
        System.out.println("Разность целых чисел: " + intSubtractResult);

        double doubleSubtractNum1 = getDoubleInput("Введите первое вещественное число для вычитания: ", scanner);
        double doubleSubtractNum2 = getDoubleInput("Введите второе вещественное число для вычитания: ", scanner);
        double doubleSubtractResult = Calculator.subtract(doubleSubtractNum1, doubleSubtractNum2);
        System.out.println("Разность вещественных чисел: " + doubleSubtractResult);

        // Пример использования compareArrays
        Integer[] array1 = getIntegerArrayInput("Введите элементы первого массива (целые числа через пробел): ", scanner, 3);
        Integer[] array2 = getIntegerArrayInput("Введите элементы второго массива (целые числа через пробел): ", scanner, 3);
        boolean arraysEqual = ArrayComparator.compareArrays(array1, array2);
        System.out.println("Массивы одинаковы: " + arraysEqual);

        // Пример использования Pair
        String firstElement = getStringInput("Введите строку для первого элемента пары: ", scanner);
        int secondElement = getIntInput("Введите целое число для второго элемента пары: ", scanner);
        Pair<String, Integer> pair = new Pair<>(firstElement, secondElement);
        System.out.println("Пара: " + pair.toString());
        System.out.println("Первый элемент: " + pair.getFirst());
        System.out.println("Второй элемент: " + pair.getSecond());

        // Закрытие Scanner
        scanner.close();
    }

    private static int getIntInput(String prompt, Scanner scanner) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите целое число.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        return input;
    }

    private static double getDoubleInput(String prompt, Scanner scanner) {
        double input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите вещественное число.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        return input;
    }

    private static Integer[] getIntegerArrayInput(String prompt, Scanner scanner, int length) {
        Integer[] inputArray = new Integer[length];
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                for (int i = 0; i < length; i++) {
                    inputArray[i] = scanner.nextInt();
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите целые числа через пробел.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        return inputArray;
    }

    private static String getStringInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.next();
    }
}