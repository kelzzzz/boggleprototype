package org.ENSEACS.core.graphics;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.Random;

public class LetterTile {
    private char letter;
    private final int x;
    private final int y;
    private final TextButton button;
    private final int DIMENSIONS = 50;

    public LetterTile(int x, int y, TextButton.TextButtonStyle tbs){
        this.x = x;
        this.y = y;

        assignRandomCharacterToTile();

        button = new TextButton(String.valueOf(this.letter).toUpperCase(),tbs);
        formatButton(x, y);
        initButtonActionListeners();
    }

    private void formatButton(int x, int y) {
        button.setBounds(x,y, DIMENSIONS, DIMENSIONS);
        button.setWidth(DIMENSIONS);
        button.setHeight(DIMENSIONS);
    }

    public void assignRandomCharacterToTile(){
        Random r = new Random();
        this.letter = (char) (r.nextInt(26) + 'a');
    }

    public void addButtonToStage(Stage stage){
        stage.addActor(this.button);
    }

    /*TODO
    *  Click and drag on long press */
    public void initButtonActionListeners(){
        this.button.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("down");
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("up");
            }
        });
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
}
