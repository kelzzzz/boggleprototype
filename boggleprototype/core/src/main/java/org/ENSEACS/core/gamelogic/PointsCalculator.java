package org.ENSEACS.core.gamelogic;

public class PointsCalculator {
//Author: Thomas Czerwien
    public static int calculateScore(String word) {
        int length = word == null ? 0 : word.length();
        if (length < 3) return 0;
        if (length <= 4) return 100;
        if (length == 5) return 200;
        if (length == 6) return 300;
        if (length == 7) return 500;
        return 1100;
    }
}