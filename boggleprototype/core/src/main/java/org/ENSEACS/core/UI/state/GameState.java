package org.ENSEACS.core.UI.state;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
/*
 * Author: Kels C.
 * ENSEA 2025 */
public abstract class GameState extends Game implements State {
    protected UIContext uic;
    protected final Stage stage = new Stage();

    public GameState(UIContext uic){
        super();
        this.uic = uic;
    }

    public void updateViewport(){
        stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
    }

    @Override
    public void create() {

    }

    @Override public void render(){

    }

    @Override
    public void clickPlay() {

    }

    @Override
    public void onTimerRunOut() {

    }
}
