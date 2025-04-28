package org.ENSEACS.core.graphics;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class LetterTile extends Game {
    Stage stage;
    TextButton button;

    @Override
    public void create() {
        stage = new Stage();
    }

    @Override
    public void render() {
        super.render();
        stage.draw();
    }
}
