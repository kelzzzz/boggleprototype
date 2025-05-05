package org.ENSEACS.core.gamelogic;

public class PointsCalculator {

    public static int calculateScore(String word) {
        int length = word == null ? 0 : word.length();
        if (length < 3) return 0;
        if (length <= 4) return 1;
        if (length == 5) return 2;
        if (length == 6) return 3;
        if (length == 7) return 5;
        return 11;
    }
}