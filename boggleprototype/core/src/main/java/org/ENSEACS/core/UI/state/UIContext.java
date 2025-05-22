package org.ENSEACS.core.UI.state;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class UIContext {
    private GameState state;

    public void setState(GameState state){
        this.state = state;
        this.state.create();
    }

    public void renderState(){
        this.state.render();
    }

}
