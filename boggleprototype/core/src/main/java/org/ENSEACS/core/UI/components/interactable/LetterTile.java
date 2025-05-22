package org.ENSEACS.core.UI.components.interactable;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class LetterTile extends BoggleButton {
    private char letter;

    public LetterTile(int x, int y, int dimensionsW, int dimensionsH){
        super(x,y,dimensionsW,dimensionsH);
        this.setText(String.valueOf(letter));
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter){
        this.letter = letter;
        this.button.setText(String.valueOf(this.letter));
    }
}
