package org.ENSEACS.core.UI.state.children;

/*
 * Author: Kels C.
 * ENSEA 2025 */

import com.badlogic.gdx.Gdx;
import org.ENSEACS.core.UI.stage.TitleScreenComponents;
import org.ENSEACS.core.UI.state.GameState;
import org.ENSEACS.core.UI.state.UIContext;

public class TitleScreenState extends GameState {
    private TitleScreenComponents tsc;

    public TitleScreenState(UIContext uic) {
        super(uic);
    }

    @Override
    public void create() {
        tsc = new TitleScreenComponents(this.stage);
        Gdx.input.setInputProcessor(this.stage);
    }

    @Override
    public void render(){
        super.render();
        stage.draw();
        clickPlay();
        stage.act();
        stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
    }

    @Override
    public void clickPlay() {
        if(this.tsc.playResponse){
            this.uic.setState(new MainGameplayState(this.uic));
        }
    }

}
