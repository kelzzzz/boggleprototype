package org.ENSEACS.core.UI.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import org.ENSEACS.core.UI.components.interactable.BoggleButton;

public class EndScreen {
    Stage stage;
    public BoggleButton replayButton;
    public BoggleButton exitButton;
    public boolean playResponse;
    public boolean exitResponse;
    public Label thanksMessage;

    public EndScreen(Stage stage){
        initComponents();
        this.stage = stage;
        this.stage.addActor(replayButton.getButton());
        this.stage.addActor(exitButton.getButton());
        this.stage.addActor(thanksMessage);
        Gdx.input.setInputProcessor(this.stage);
    }

    private void initComponents() {
        initButtons();
        initMessage();
    }

    private void initMessage() {
        thanksMessage = new Label("Thanks for playing!",replayButton.getSkin());
        thanksMessage.setX(200);
        thanksMessage.setY(210);
        thanksMessage.setColor(Color.BLACK);
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
                if(isExit){
                    Gdx.app.exit();
                }
                else{
                    playResponse = true;
                }
                return true;
            }
        };
    }

    public boolean clickPlayAgainResponse(){
        return this.playResponse;
    }
}
