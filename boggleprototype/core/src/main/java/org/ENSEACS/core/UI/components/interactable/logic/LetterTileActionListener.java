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
    private final ArrayList<LetterTile> touched = new ArrayList<LetterTile>();
    private static final Logger LOGGER = new Logger(LetterTileActionListener.class.getName(),LOG_INFO);
    private String currentWord = "";
    private LetterTile hovering = null;

    public LetterTileActionListener(ArrayList<LetterTile> tiles){
        this.tiles = tiles;
    }

    @Override
    public void touchDragged (InputEvent event, float x, float y, int pointer) {
        for(LetterTile t : this.tiles){
            if(t.getButton().isOver() && !touched.contains(t) && hovering!=t){
                hovering = t;
                t.highlight();
                touched.add(t);
            }

            else if(touched.contains(t) && t.getButton().isOver() && hovering!=t){
                if(hovering!=null){
                    hovering.unhighlight();
                    touched.remove(hovering);
                }
                hovering = t;
            }

        }
    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        for(LetterTile t : this.tiles){
            if(t.getButton().isPressed()){
                t.highlight();
                if(!touched.contains(t)){
                    touched.add(t);
                }
            }
        }
        return true;
    }

    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        currentWord = "";
        for(LetterTile t : this.touched){
            t.unhighlight();
            currentWord = currentWord.concat(String.valueOf(t.getLetter()));
        }
        touched.clear();
        Player.getInstance().addWord(currentWord);
        LOGGER.info(currentWord);
    }
}
