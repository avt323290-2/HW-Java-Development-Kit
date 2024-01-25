package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Класс для демонстрации парадокса Монти Холла.
 */
public class MontyHallParadox {

    /**
     * Точка входа в приложение.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        int totalTests = 1000;
        Map<Integer, String> results = new HashMap<>();

        for (int i = 1; i <= totalTests; i++) {
            boolean result = playMontyHallGame();
            results.put(i, result ? "Победа" : "Поражение");
        }

        // Вывод статистики
        int wins = (int) results.values().stream().filter(result -> result.equals("Победа")).count();
        int losses = totalTests - wins;

        System.out.println("Победы: " + wins);
        System.out.println("Поражения: " + losses);
    }

    /**
     * Метод, реализующий сценарий игры Монти Холла.
     *
     * @return true, если игрок выиграл, false в противном случае.
     */
    private static boolean playMontyHallGame() {
        Random random = new Random();

        // Симуляция выбора игрока
        int chosenDoor = random.nextInt(3);

        // Симуляция расположения автомобиля за дверью
        int carDoor = random.nextInt(3);

        // Открытие одной из дверей с козой после выбора игрока
        int revealedDoor;
        do {
            revealedDoor = random.nextInt(3);
        } while (revealedDoor == chosenDoor || revealedDoor == carDoor);

        // Решение игрока о смене двери или оставлении выбранной
        boolean switchDoor = random.nextBoolean();

        // Если игрок решил сменить дверь, выбираем другую дверь
        if (switchDoor) {
            int newChosenDoor;
            do {
                newChosenDoor = random.nextInt(3);
            } while (newChosenDoor == chosenDoor || newChosenDoor == revealedDoor);
            chosenDoor = newChosenDoor;
        }

        // Возвращаем результат: true - победа, false - поражение
        return chosenDoor == carDoor;
    }
}