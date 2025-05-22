package org.ENSEACS.core.UI.state.children;

import org.ENSEACS.core.UI.stage.UserDisplay;
import org.ENSEACS.core.UI.stage.LetterTileGrid;
import org.ENSEACS.core.UI.state.GameState;
import org.ENSEACS.core.UI.state.UIContext;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class MainGameplayState extends GameState {

    private UserDisplay hud;

    public MainGameplayState(UIContext uic) {
        super(uic);
    }

    @Override
    public void create() {
        LetterTileGrid lt = new LetterTileGrid(stage);
        hud = new UserDisplay(stage);
    }

    @Override
    public void render(){
        super.render();
        stage.draw();
        stage.act();
        hud.updateHud();
        refreshTimerResponseCheck();
        updateViewport();
    }

    private void refreshTimerResponseCheck() {
        if(this.hud.getTimer().getTimeoutResponse()){
            this.onTimerRunOut();
        }
    }

    @Override
    public void onTimerRunOut() {
        this.uic.setState(new EndScreenState(this.uic));
    }

}
