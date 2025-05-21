package org.ENSEACS.core.UI.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import org.ENSEACS.core.UI.components.interactable.BoggleButton;
import org.ENSEACS.core.gamelogic.Player;

/*
 * Author: Kels C.
 * ENSEA 2025 */
public class EndScreen {
    Stage stage;
    public BoggleButton replayButton;
    public BoggleButton exitButton;
    public boolean playResponse;
    public Label thankYouMessage;

    public EndScreen(Stage stage){
        initComponents();
        this.stage = stage;
        this.stage.addActor(replayButton.getButton());
        this.stage.addActor(exitButton.getButton());
        this.stage.addActor(thankYouMessage);
        Gdx.input.setInputProcessor(this.stage);
    }

    private void initComponents() {
        initButtons();
        initMessage();
    }

    private void initMessage() {
        thankYouMessage = new Label("Thanks for playing! Your score: " + Player.getInstance().getScore(),
                replayButton.getSkin());
        thankYouMessage.setX(200);
        thankYouMessage.setY(210);
        thankYouMessage.setColor(Color.BLACK);
    }

    private void initButtons() {
        replayButton = new BoggleButton(230, 150, 100, 50) {};
        exitButton = new BoggleButton(250, 100, 60, 50) {};

        replayButton.setText("Play again?");
        exitButton.setText("Exit");

        replayButton.getButton().addListener(getInputListener(false));
        exitButton.getButton().addListener(getInputListener(true));
    }

    public InputListener getInputListener(boolean isExit){
        return new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if(isExit){
                    Gdx.app.exit();
                }
                else{
                    playResponse = true;
                }
            }
        };
    }

    public boolean clickPlayAgainResponse(){
        return this.playResponse;
    }
}
