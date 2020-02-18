package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class LeaderBoard {
    private ArrayList<GameResult> leaders = new ArrayList<>();

    public void addLeader(GameResult gr) {
        leaders.add(gr);
    }

    public void printResults() {
        // находит максимальную длину имени (не работает для варианта 3 печати)
        // так как maxLen должна быть final
//        int maxLen = 0;
//        for (GameResult r : leaders) {
//            maxLen = Math.max(maxLen, r.getName().length());
//        }

        // тоже самое, но только maxLen "эффективно final" так как инициализируется один раз и не меняется
        int maxLen = leaders.stream()
                .mapToInt(r -> r.getName().length())
                .max()
                .orElse(0);

//        сортирует сам список - меняет порядок записей в списке
//        Для нас не подходит, так как мы хотим хранить историю игр в этом списке
//        leaders.sort(Comparator.comparing(GameResult::getTriesCount)
//                               .thenComparing(GameResult::getTime));

        // вариант 1: печатает на экран максимум 5 результатов
//        int count = 0;
//        for (GameResult r : leaders) {
//            System.out.printf("%-" + maxLen + "s %2d %3.2f%n", r.getName(), r.getTriesCount(), r.getTime() / 1000.0);
//            count++;
//            if (count < 5) {
//                break;
//            }
//        }

        // вариант 2: печатает на экран максимум 5 результатов
//        for (int i = 0; i < Math.min(leaders.size(), 5); i++) {
//            GameResult r = leaders.get(i);
//            System.out.printf("%-" + maxLen + "s %2d %3.2f%n", r.getName(), r.getTriesCount(), r.getTime() / 1000.0);
//        }

        // вариант 3: сортирует и печатает первые 5 результатов
        leaders.stream()
                .sorted(Comparator.comparing(GameResult::getTriesCount)
                                  .thenComparing(GameResult::getTime))
                .limit(5)
                .forEach(r -> System.out.printf("%-" + maxLen + "s %2d %3.2f%n", r.getName(), r.getTriesCount(), r.getTime() / 1000.0));
    }

}
