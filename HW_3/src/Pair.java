/**
 * Обобщенный класс, представляющий пару значений разного типа.
 *
 * @param <T> Тип первого элемента пары.
 * @param <U> Тип второго элемента пары.
 */
public class Pair<T, U> {
    private T first;
    private U second;

    /**
     * Конструктор класса Pair.
     *
     * @param first  Первый элемент пары.
     * @param second Второй элемент пары.
     */
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Получить значение первого элемента пары.
     *
     * @return Первый элемент пары.
     */
    public T getFirst() {
        return first;
    }

    /**
     * Получить значение второго элемента пары.
     *
     * @return Второй элемент пары.
     */
    public U getSecond() {
        return second;
    }

    /**
     * Переопределение метода toString для представления пары в виде строки.
     *
     * @return Строковое представление пары.
     */
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}