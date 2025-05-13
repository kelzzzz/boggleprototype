package org.ENSEACS.core.UI.stateUI;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import org.ENSEACS.core.UI.componentUI.LetterTileGrid;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class MainGameplayState extends Game {

    private final Stage stage = new Stage();
    private LetterTileGrid lt;

    @Override
    public void create() {
        lt = new LetterTileGrid(stage);
    }

    @Override
    public void render(){
        super.render();
        stage.draw();
        stage.act();
        stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
    }
}
