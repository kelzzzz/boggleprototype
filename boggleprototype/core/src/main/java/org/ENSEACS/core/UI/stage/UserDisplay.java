package org.ENSEACS.core.UI.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import org.ENSEACS.core.UI.components.CountdownTimer;
import org.ENSEACS.core.UI.components.WordScrollPane;
import org.ENSEACS.core.gamelogic.Player;

import static org.ENSEACS.core.util.Constants.SKIN_GLASSY_UI_JSON_PATH;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class UserDisplay {

    private final Skin skin = new Skin(Gdx.files.internal(SKIN_GLASSY_UI_JSON_PATH));
    private final Label score = new Label("Score: " + 0, skin);
    private final WordScrollPane wsp = new WordScrollPane(335,160,100f);
    private CountdownTimer timer;

    public UserDisplay(Stage stage){
        initTimerActor(stage);
        initScoreLabelActor(stage, 353, 270, 1.2f);
        initFoundWordsScrollPane(stage);
    }

    public CountdownTimer getTimer(){
        return this.timer;
    }

    private void initFoundWordsScrollPane(Stage stage) {
        stage.addActor(wsp.getScrollPane());
    }

    private void initTimerActor(Stage stage) {
        this.timer = new CountdownTimer(350,100,100,50);
        stage.addActor(this.timer.getButton());
    }

    private void initScoreLabelActor(Stage stage, int x, int y, float scale) {
        score.setX(x); score.setY(y); score.setFontScale(scale); score.setColor(Color.BLACK);
        stage.addActor(score);
    }

    public void updateHud(){
        this.score.setText("Score: " + Player.getInstance().getScore());
        this.wsp.updateWordsInDisplay();
        this.timer.updateTime();
    }

}
