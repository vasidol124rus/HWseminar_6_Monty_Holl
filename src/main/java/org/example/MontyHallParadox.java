package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {

    public static void main(String[] args) {
        Map<Integer, Result> results = new HashMap<>();
        int numTests = 1000;
        int wins = 0;

        for (int i = 1; i <= numTests; i++) {
            boolean win = playGame();
            Result result = new Result();
            result.setStep(i);
            result.setWin(win);
            results.put(i, result);
            if (win) {
                wins++;
            }
        }

        System.out.println("Статистика:");
        System.out.println("Всего игр: " + numTests);
        System.out.println("Побед: " + wins);
        System.out.println("Проигрышей: " + (numTests - wins));
        System.out.println("Процент побед: " + (double) wins / numTests * 100 + "%");
    }

    private static boolean playGame() {
        Random random = new Random();

        // Выбор игрока
        int playerChoice = random.nextInt(3); // 0, 1, 2

        // Выбор правильной двери
        int correctDoor = random.nextInt(3); // 0, 1, 2

        // Открытие неправильной двери (Монти открывает дверь)
        int openedDoor = 0;
        while (openedDoor == playerChoice || openedDoor == correctDoor) {
            openedDoor = random.nextInt(3);
        }

        // Переключение выбора (основная логика парадокса)
        int newChoice = 0;
        while (newChoice == playerChoice || newChoice == openedDoor) {
            newChoice = random.nextInt(3);
        }

        // Проверка выигрыша
        return newChoice == correctDoor;
    }

    @Getter
    @Setter
    private static class Result {
        private int step;
        private boolean win;

        public void setStep(int i) {
        }

        public void setWin(boolean win) {
        }
    }
}

