/**
 * Класс, представляющий обобщенный калькулятор.
 */
public class Calculator {

    /**
     * Сложение двух чисел.
     *
     * @param num1 Первое число.
     * @param num2 Второе число.
     * @param <T>  Тип чисел (Integer, Double, Float, Long).
     * @return Результат сложения.
     * @throws IllegalArgumentException Если передан неподдерживаемый тип чисел.
     */
    public static <T extends Number> T sum(T num1, T num2) {
        if (num1 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        } else if (num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        } else if (num1 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() + num2.floatValue());
        } else if (num1 instanceof Long) {
            return (T) Long.valueOf(num1.longValue() + num2.longValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    /**
     * Умножение двух чисел.
     *
     * @param num1 Первое число.
     * @param num2 Второе число.
     * @param <T>  Тип чисел (Integer, Double, Float, Long).
     * @return Результат умножения.
     * @throws IllegalArgumentException Если передан неподдерживаемый тип чисел.
     */
    public static <T extends Number> T multiply(T num1, T num2) {
        if (num1 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() * num2.intValue());
        } else if (num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() * num2.doubleValue());
        } else if (num1 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() * num2.floatValue());
        } else if (num1 instanceof Long) {
            return (T) Long.valueOf(num1.longValue() * num2.longValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    /**
     * Деление двух чисел.
     *
     * @param num1 Первое число (делимое).
     * @param num2 Второе число (делитель).
     * @param <T>  Тип чисел (Integer, Double, Float, Long).
     * @return Результат деления.
     * @throws IllegalArgumentException Если передан неподдерживаемый тип чисел.
     * @throws ArithmeticException      Если попытка деления на ноль.
     */
    public static <T extends Number> T divide(T num1, T num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }

        if (num1 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() / num2.intValue());
        } else if (num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() / num2.doubleValue());
        } else if (num1 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() / num2.floatValue());
        } else if (num1 instanceof Long) {
            return (T) Long.valueOf(num1.longValue() / num2.longValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    /**
     * Вычитание двух чисел.
     *
     * @param num1 Уменьшаемое число.
     * @param num2 Вычитаемое число.
     * @param <T>  Тип чисел (Integer, Double, Float, Long).
     * @return Результат вычитания.
     * @throws IllegalArgumentException Если передан неподдерживаемый тип чисел.
     */
    public static <T extends Number> T subtract(T num1, T num2) {
        if (num1 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() - num2.intValue());
        } else if (num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() - num2.doubleValue());
        } else if (num1 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() - num2.floatValue());
        } else if (num1 instanceof Long) {
            return (T) Long.valueOf(num1.longValue() - num2.longValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }
}