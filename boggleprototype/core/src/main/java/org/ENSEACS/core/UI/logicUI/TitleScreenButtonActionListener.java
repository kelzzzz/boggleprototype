package org.ENSEACS.core.UI.logicUI;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import org.ENSEACS.core.UI.stateUI.UIContext;

public class TitleScreenButtonActionListener extends InputListener {

    /*TODO
    *  Implement action listeners. They should move between screen states. */

    UIContext uic;

    public TitleScreenButtonActionListener(UIContext uic){
        super();
        this.uic = uic;

    }
    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
    }

}
