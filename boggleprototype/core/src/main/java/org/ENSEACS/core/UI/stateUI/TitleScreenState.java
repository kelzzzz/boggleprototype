package org.ENSEACS.core.UI.stateUI;

/*
 * Author: Kels C.
 * ENSEA 2025 */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import org.ENSEACS.core.UI.componentUI.TitleScreenComponents;

public class TitleScreenState extends Game {
    private final Stage stage = new Stage();
    private TitleScreenComponents tsc;
    private UIContext uic;

    public TitleScreenState(UIContext uic) {
        super();
        this.uic = uic;
    }

    @Override
    public void create() {
        tsc = new TitleScreenComponents(this.stage, this.uic);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(){
        super.render();
        stage.draw();
        stage.act();
        stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
    }
}
