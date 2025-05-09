package org.ENSEACS.core.UI.stateUI;

import com.badlogic.gdx.Game;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class UIContext {
    private Game state;

    public void setState(Game state){
        this.state = state;
        this.state.create();
    }

    public void renderState(){
        this.state.render();
    }

}
