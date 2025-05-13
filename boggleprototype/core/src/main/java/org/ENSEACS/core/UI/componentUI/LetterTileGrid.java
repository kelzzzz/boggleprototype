package org.ENSEACS.core.UI.componentUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import org.ENSEACS.core.UI.interactable.LetterTile;
import org.ENSEACS.core.UI.logicUI.LetterTileActionListener;
import org.ENSEACS.core.util.BoggleLetterDistributionGenerator;

import java.util.ArrayList;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class LetterTileGrid{
    private final Skin buttonSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    private final ArrayList<LetterTile> letterTiles = new ArrayList<LetterTile>();
    private final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
    private final BoggleLetterDistributionGenerator bldg = new BoggleLetterDistributionGenerator();

    /*Magic Numbers*/
    private final int X_INIT = 40;
    private final int Y_INIT = 20;
    private final int X_INCR = 55;
    private final int Y_INCR = 55;
    private final int LETTER_BUTTON_DIMENSIONS = 50;

    public LetterTileGrid(Stage stage) {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        textButtonStyle.font = new BitmapFont();
        textButtonStyle.up = buttonSkin.getDrawable("button-small");
        textButtonStyle.down = buttonSkin.getDrawable("button-small-down");
        int x = X_INIT;
        int y = Y_INIT;
        String letters = bldg.getLetterDistributions();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j<4;j++){
                y+=Y_INCR;
                LetterTile lt = new LetterTile(x,y,LETTER_BUTTON_DIMENSIONS,LETTER_BUTTON_DIMENSIONS,textButtonStyle);
                letterTiles.add(lt);
            }
            y=Y_INIT;
            x+=X_INCR;
        }

        for(int i = 0 ; i < 16; i++){
            letterTiles.get(i).setLetter(letters.charAt(i));
        }

        for(LetterTile t : letterTiles){
            t.addButtonToStage(stage);
        }

        stage.addListener(new LetterTileActionListener(this.letterTiles));
        Gdx.input.setInputProcessor(stage);
    }
}
