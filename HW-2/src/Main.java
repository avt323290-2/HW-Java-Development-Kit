/**
 * Главный класс с методом main для примера использования Pair и GenericMethods.
 */
public class Main {
    /**
     * Точка входа в программу.
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        // Пример использования
        Pair<Integer> intPair = new Pair<>(2, 3);
        System.out.println("Sum: " + GenericMethods.sum(intPair));

        Pair<String> stringPair = new Pair<>("Hello, ", "world!");
        System.out.println("Concatenation: " + GenericMethods.concatenate(stringPair));
    }
}