/**
 * Класс для сравнения двух массивов одинакового типа и длины.
 */
public class ArrayComparator {

    /**
     * Сравнивает два массива на идентичность.
     *
     * @param <T>  Тип элементов массива.
     * @param arr1 Первый массив для сравнения.
     * @param arr2 Второй массив для сравнения.
     * @return true, если массивы идентичны, false в противном случае.
     */
    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        // Проверка на равную длину массивов
        if (arr1.length != arr2.length) {
            return false;
        }

        // Проверка на идентичность каждого элемента массива
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }
}