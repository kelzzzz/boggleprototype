package org.ENSEACS.core.gamelogic;
import org.ENSEACS.core.gamelogic.PointsCalculator;

public class Player {
    private int score = 0;

    public void addWord(String word) {
        this.score += PointsCalculator.calculateScore(word);
    }

    public int getScore() {
        return score;
    }

}