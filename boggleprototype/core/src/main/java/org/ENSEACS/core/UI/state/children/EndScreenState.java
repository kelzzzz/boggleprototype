package org.ENSEACS.core.UI.state.children;

import org.ENSEACS.core.UI.stage.EndScreen;
import org.ENSEACS.core.UI.state.GameState;
import org.ENSEACS.core.UI.state.UIContext;

public class EndScreenState extends GameState {

    public EndScreenState(UIContext uic) {
        super(uic);
    }
    EndScreen es;

    @Override
    public void create() {
        this.es = new EndScreen(this.stage);
    }

    @Override
    public void render(){
        super.render();
        stage.draw();
        stage.act();
        clickPlay();
        clickExit();
        updateViewport();
    }

    @Override
    public void clickPlay() {
        if(this.es.clickPlayAgainResponse()){
            this.uic.setState(new MainGameplayState(this.uic));
        }
    }

    @Override
    public void clickExit() {
        if(this.es.clickExitResponse()){
            System.exit(0);
        }
    }

    @Override
    public void clickInfo() {}

    @Override
    public void clickRules() {}

    @Override
    public void onTimerRunOut() {}
}
