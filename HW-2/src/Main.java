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
        System.out.print("Введите первое число: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int secondNumber = scanner.nextInt();

        // Создайте пару чисел
        Pair<Integer> intPair = new Pair<>(firstNumber, secondNumber);
        System.out.println("Сумма чисел: " + GenericMethods.sum(intPair));

        // Введите две строки
        System.out.print("Введите первую строку: ");
        String firstString = scanner.next();

        System.out.print("Введите вторую строку: ");
        String secondString = scanner.next();

        // Создайте пару строк
        Pair<String> stringPair = new Pair<>(firstString, secondString);
        System.out.println("Конкатенация строк: " + GenericMethods.concatenate(stringPair));

        // Закрыть Scanner
        scanner.close();
    }
}