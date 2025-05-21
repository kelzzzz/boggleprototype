package org.ENSEACS.core.UI.components.interactable.logic;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Logger;
import org.ENSEACS.core.UI.components.interactable.LetterTile;
import org.ENSEACS.core.gamelogic.Player;

import java.util.ArrayList;

import static com.badlogic.gdx.Application.LOG_INFO;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class LetterTileActionListener extends InputListener {
    private final ArrayList<LetterTile> tiles;
    private final ArrayList<LetterTile> touched = new ArrayList<>();
    private static final Logger LOGGER = new Logger(LetterTileActionListener.class.getName(),LOG_INFO);
    private String currentWord = "";
    private LetterTile hovering = null;

    public LetterTileActionListener(ArrayList<LetterTile> tiles){
        this.tiles = tiles;
    }

    @Override
    public void touchDragged (InputEvent event, float x, float y, int pointer) {
        for(LetterTile t : this.tiles){
            if(hoveringOverNewTile(t)){
                selectTile(t);
            }
            else if(hoveringOverSelectedTile(t)){
                deselectTile(t);
            }

        }
    }

    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        for(LetterTile t : this.tiles){
            if(t.getButton().isPressed()){
                addFirstTileToSelection(t);
            }
        }
        return true;
    }

    @Override
    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        currentWord = "";
        buildWordFromLetters();
        Player.getInstance().addWord(currentWord);
        LOGGER.info(currentWord);
    }

    private boolean hoveringOverSelectedTile(LetterTile t) {
        return touched.contains(t) && t.getButton().isOver() && hovering != t;
    }

    private boolean hoveringOverNewTile(LetterTile t) {
        return t.getButton().isOver() && !touched.contains(t) && hovering != t;
    }

    private void addFirstTileToSelection(LetterTile t) {
        t.highlight();
        if(!touched.contains(t)){
            touched.add(t);
        }
    }

    private void buildWordFromLetters() {
        for(LetterTile t : this.touched){
            t.unhighlight();
            currentWord = currentWord.concat(String.valueOf(t.getLetter()));
        }
        touched.clear();
    }

    private void deselectTile(LetterTile t) {
        if(hovering!=null){
            hovering.unhighlight();
            touched.remove(hovering);
        }
        hovering = t;
    }

    private void selectTile(LetterTile t) {
        hovering = t;
        t.highlight();
        touched.add(t);
    }
}
