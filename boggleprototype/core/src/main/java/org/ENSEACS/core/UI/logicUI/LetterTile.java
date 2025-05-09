package org.ENSEACS.core.UI.logicUI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class LetterTile {
    private char letter;
    private final int x;
    private final int y;
    private final TextButton button;
    private final int DIMENSIONS = 50;

    public LetterTile(int x, int y, TextButton.TextButtonStyle tbs){
        this.x = x;
        this.y = y;

        button = new TextButton(String.valueOf(this.letter).toUpperCase(),tbs);
        formatButton(x, y);
    }

    private void formatButton(int x, int y) {
        button.setBounds(x,y, DIMENSIONS, DIMENSIONS);
        button.setWidth(DIMENSIONS);
        button.setHeight(DIMENSIONS);
    }
    public void highlight(){
        this.button.setColor(Color.YELLOW);
    }

    public void unhighlight(){
        this.button.setColor(Color.WHITE);
    }

    public void addButtonToStage(Stage stage){
        stage.addActor(this.button);
    }

    public TextButton getButton() {
        return button;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter){
        this.letter = letter;
        this.button.setText(String.valueOf(this.letter));
    }
}
