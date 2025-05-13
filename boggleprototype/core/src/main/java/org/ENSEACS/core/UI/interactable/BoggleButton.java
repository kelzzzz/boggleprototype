package org.ENSEACS.core.UI.interactable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public abstract class BoggleButton {
    int x;
    int y;

    protected TextButton button;
    protected final int dimensionsW;
    protected final int dimensionsH;

    public BoggleButton(int x, int y, int dimensionsW, int dimensionsH, TextButton.TextButtonStyle tbs){
        this.x = x;
        this.y = y;
        this.dimensionsW = dimensionsW;
        this.dimensionsH = dimensionsH;
        button = new TextButton("",tbs);
    }

    void formatButton(int x, int y) {
        button.setBounds(x,y, dimensionsW, dimensionsH);
        button.setWidth(dimensionsW);
        button.setHeight(dimensionsH);
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
}
