/**
 * Обобщенный класс, представляющий пару значений одного типа.
 * @param <T> Тип значений пары.
 */
public class Pair<T> {
    private T first;
    private T second;

    /**
     * Конструктор класса Pair.
     * @param first Первое значение пары.
     * @param second Второе значение пары.
     */
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Получить первое значение пары.
     * @return Первое значение пары.
     */
    public T getFirst() {
        return first;
    }

    /**
     * Получить второе значение пары.
     * @return Второе значение пары.
     */
    public T getSecond() {
        return second;
    }
}