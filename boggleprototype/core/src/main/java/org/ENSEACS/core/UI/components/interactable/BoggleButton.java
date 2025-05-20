package org.ENSEACS.core.UI.components.interactable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import static org.ENSEACS.core.util.Constants.SKIN_GLASSY_UI_JSON_PATH;

public abstract class BoggleButton {
    private int x;
    private int y;

    protected final int dimensionsW;
    protected final int dimensionsH;

    protected TextButton button;

    protected final Skin skin = new Skin(Gdx.files.internal(SKIN_GLASSY_UI_JSON_PATH));
    protected final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();


    public BoggleButton(int x, int y, int dimensionsW, int dimensionsH){
        this.x = x;
        this.y = y;

        this.dimensionsW = dimensionsW;
        this.dimensionsH = dimensionsH;

        textButtonStyle.font = new BitmapFont();
        textButtonStyle.up = skin.getDrawable("button-small");
        button = new TextButton("",textButtonStyle);
        this.formatButton(x,y);

    }
    public void setText(String txt){
        this.button.setText(txt);
    }

    public void formatButton(int x, int y) {
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

    public TextButton getButton() {
        return button;
    }
    public Skin getSkin(){return this.skin;}
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
