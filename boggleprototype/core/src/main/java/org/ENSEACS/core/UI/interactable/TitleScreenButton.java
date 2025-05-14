package org.ENSEACS.core.UI.interactable;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class TitleScreenButton extends BoggleButton{
    public TitleScreenButton(int x, int y, String label, int dimensionsW, int dimensionsH, TextButton.TextButtonStyle tbs) {
        super(x, y, dimensionsW, dimensionsH, tbs);
        button = new TextButton(label,tbs);
        formatButton(x,y);
    }
}
