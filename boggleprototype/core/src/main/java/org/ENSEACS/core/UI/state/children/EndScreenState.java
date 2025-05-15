package org.ENSEACS.core.UI.state.children;

import org.ENSEACS.core.UI.state.GameState;
import org.ENSEACS.core.UI.state.UIContext;

public class EndScreenState extends GameState {

    public EndScreenState(UIContext uic) {
        super(uic);
    }

    @Override
    public void create() {

    }

    @Override
    public void render(){
        super.render();
        stage.draw();
        stage.act();
    }

    @Override
    public void clickPlay() {

    }

    @Override
    public void clickExit() {

    }

    @Override
    public void clickInfo() {}

    @Override
    public void clickRules() {}

    @Override
    public void onTimerRunOut() {}
}
