package org.ENSEACS.core.UI.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import org.ENSEACS.core.UI.components.interactable.LetterTile;
import org.ENSEACS.core.UI.components.interactable.logic.LetterTileActionListener;
import org.ENSEACS.core.util.BoggleLetterDistributionGenerator;

import java.util.ArrayList;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class LetterTileGrid {
    private final ArrayList<LetterTile> letterTiles = new ArrayList<LetterTile>();
    private final BoggleLetterDistributionGenerator bldg = new BoggleLetterDistributionGenerator();

    /*Magic Numbers*/
    private final int X_INIT = 50;
    private final int Y_INIT = 45;
    private final int X_INCR = 55;
    private final int Y_INCR = 55;
    private final int LETTER_BUTTON_DIMENSIONS = 50;

    public LetterTileGrid(Stage stage) {
        String letters = bldg.getLetterDistributions();
        initLetterTilesInGrid(Y_INIT, X_INIT);
        distributeLettersToTiles(letters);
        addLetterTilesToStage(stage);
        stage.addListener(new LetterTileActionListener(this.letterTiles));
        Gdx.input.setInputProcessor(stage);
    }

    private void addLetterTilesToStage(Stage stage) {
        for(LetterTile t : letterTiles){
            stage.addActor(t.getButton());
        }
    }

    private void distributeLettersToTiles(String letters) {
        for(int i = 0 ; i < 16; i++){
            letterTiles.get(i).setLetter(letters.charAt(i));
        }
    }

    private void initLetterTilesInGrid(int y, int x) {
        if (baseCase()) return;
        addNewTileToGrid(y, x);
        x+=X_INCR;
        if(letterTiles.size()%4==0){
            y+=Y_INCR;
            x=X_INIT;
        }
        initLetterTilesInGrid(y,x);
    }

    private void addNewTileToGrid(int y, int x) {
        LetterTile lt = new LetterTile(x, y,LETTER_BUTTON_DIMENSIONS,LETTER_BUTTON_DIMENSIONS);
        letterTiles.add(lt);
    }

    private boolean baseCase() {
        return letterTiles.size() == 16;
    }
}
