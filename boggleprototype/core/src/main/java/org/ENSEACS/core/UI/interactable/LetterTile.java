package org.ENSEACS.core.UI.interactable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class LetterTile extends BoggleButton {
    private char letter;
    private final int DIMENSIONS = 50;

    public LetterTile(int x, int y, int dimensionsW, int dimensionsH, TextButton.TextButtonStyle tbs){
        super(x,y,dimensionsW,dimensionsH,tbs);
        button = new TextButton(String.valueOf(this.letter).toUpperCase(),tbs);
        formatButton(x, y);
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter){
        this.letter = letter;
        this.button.setText(String.valueOf(this.letter));
    }
}
