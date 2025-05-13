package org.ENSEACS.core.gamelogic;
import org.ENSEACS.core.gamelogic.PointsCalculator;

import java.util.ArrayList;

/*Author: Thomas Czerwien*/
public class Player {
    private int score = 0;
    private ArrayList<String> wordsCreated = new ArrayList<>();

    public void addWord(String word) {
        this.score += PointsCalculator.calculateScore(word);
        this.wordsCreated.add(word);
    }

    public int getScore() {
        return score;
    }

    public ArrayList<String> getWordsCreated(){
        return this.wordsCreated;
    }
}