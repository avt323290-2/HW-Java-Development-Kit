import java.util.Scanner;

/**
 * Главный класс с методом main для примера использования Pair и GenericMethods.
 */
public class Main {
    /**
     * Точка входа в программу.
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введите два числа
        int firstNumber = readIntegerInput("Введите первое число: ", scanner);
        int secondNumber = readIntegerInput("Введите второе число: ", scanner);

        // Создайте пару чисел
        Pair<Integer> intPair = new Pair<>(firstNumber, secondNumber);
        System.out.println("Сумма чисел: " + GenericMethods.sum(intPair));

        // Введите две строки
        String firstString = readStringInput("Введите первую строку: ", scanner);
        String secondString = readStringInput("Введите вторую строку: ", scanner);

        // Создайте пару строк
        Pair<String> stringPair = new Pair<>(firstString, secondString);
        System.out.println("Конкатенация строк: " + GenericMethods.concatenate(stringPair));

        // Закрыть Scanner
        scanner.close();
    }

    /**
     * Метод для чтения целочисленного ввода с проверкой на корректность.
     * @param prompt Подсказка для пользователя.
     * @param scanner Объект Scanner для ввода данных.
     * @return Введенное целое число.
     */
    private static int readIntegerInput(String prompt, Scanner scanner) {
        int input = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                isValidInput = true;
            } catch (Exception e) {
                System.out.println("Ошибка: Введите корректное целое число.");
                scanner.nextLine(); // Очистить буфер ввода
            }
        }

        return input;
    }

    /**
     * Метод для чтения строкового ввода.
     * @param prompt Подсказка для пользователя.
     * @param scanner Объект Scanner для ввода данных.
     * @return Введенная строка.
     */
    private static String readStringInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.next();
    }
}