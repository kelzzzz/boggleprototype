package org.ENSEACS.core.gamelogic;
import org.ENSEACS.core.gamelogic.PointsCalculator;

import java.util.ArrayList;

/*Author: Thomas Czerwien*/
public class Player {
    private static Player playerInstance;
    private int score = 0;

    private Player(){
    }

    public static Player getInstance(){
        if(playerInstance == null){
            playerInstance = new Player();
        }
        return playerInstance;
    }

    private ArrayList<String> wordsCreated = new ArrayList<>();

    public void addWord(String word) {
        if(!wordsCreated.contains(word) && word.length()>=3){
            this.score += PointsCalculator.calculateScore(word);
            this.wordsCreated.add(word);
        }
    }

    public int getScore() {
        return score;
    }

    public ArrayList<String> getWordsCreated(){
        return this.wordsCreated;
    }

    public String getWordsCreatedAsString(){
        String result = "";
        if(!wordsCreated.isEmpty()){
            result = result.concat(wordsCreated.get(0));
            for(int i = 1; i < wordsCreated.size(); i++){
                result = result.concat("\n"+wordsCreated.get(i));
            }
        }
        return result;
    }
}