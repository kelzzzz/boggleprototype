package org.ENSEACS.core.util;

import com.badlogic.gdx.utils.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.badlogic.gdx.Application.LOG_INFO;

/*
* Author: Kels C.
* ENSEA 2025 */

public class BoggleLetterDistributionGenerator {

    /*Boggle has 16 dice with 6 constant letters each
    * This class places the "dice" in a random order
    * Then rolls each "die" for each letter on the board.*/

    private static final Logger LOGGER = new Logger(BoggleLetterDistributionGenerator.class.getName(),LOG_INFO);

    private final String[] DICEDISTRIBUTIONS = {
            "AAEEGN",
            "ABBJOO",
            "ACHOPS",
            "AFFKPS",
            "AOOTTW",
            "CIMOTU",
            "DEILRX",
            "DELRVY",
            "DISTTY",
            "EEGHNW",
            "EEINSU",
            "EHRTVW",
            "EIOSST",
            "ELRTTY",
            "HIMNQU",
            "HLNNRZ"
    };

    private String[] shuffleDice(String[] diceDistributions){
        List<String> shuffleString = Arrays.asList(diceDistributions);
        Collections.shuffle(shuffleString);
        LOGGER.info(shuffleString.toString());
        return shuffleString.toArray(new String[0]);
    }

    private char rollDie(String distribution){
        Random r = new Random();
        return distribution.charAt(r.nextInt(6));
    }

    public String getLetterDistributions(){
        String finalCombination = "";
        String[] shuffledDice = shuffleDice(this.DICEDISTRIBUTIONS);

        for(String sh : shuffledDice){
            finalCombination = finalCombination.concat(String.valueOf(rollDie(sh)));
        }

        return finalCombination;
    }
}
