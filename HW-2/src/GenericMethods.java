/**
 * Класс, содержащий обобщенные методы для работы с Pair.
 */
public class GenericMethods {
    /**
     * Метод для сложения двух чисел.
     * @param pair Пара чисел, которую нужно сложить.
     * @param <T> Тип чисел (должен быть подтипом Number).
     * @return Сумма двух чисел.
     */
    public static <T extends Number> T sum(Pair<T> pair) {
        return (T) (Double) (pair.getFirst().doubleValue() + pair.getSecond().doubleValue());
    }

    /**
     * Метод для конкатенации двух строк.
     * @param pair Пара строк, которую нужно конкатенировать.
     * @return Результат конкатенации строк.
     */
    public static String concatenate(Pair<String> pair) {
        return pair.getFirst() + pair.getSecond();
    }
}