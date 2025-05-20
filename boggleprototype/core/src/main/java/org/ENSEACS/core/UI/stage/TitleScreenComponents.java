package org.ENSEACS.core.UI.stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import org.ENSEACS.core.UI.components.interactable.BoggleButton;

/*Author: Thomas Czerwien*/
public class TitleScreenComponents {
    private Stage stage;
    private final Skin buttonSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    private final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
    public boolean playResponse = false;

    private final BoggleButton startButton;
    private final BoggleButton exitButton;
    private final BoggleButton returnButton;
    private final BoggleButton rulesButton;

    public TitleScreenComponents(Stage stage){
        this.stage = stage;
        textButtonStyle.font = new BitmapFont();
        textButtonStyle.up = buttonSkin.getDrawable("button-small");
        textButtonStyle.down = buttonSkin.getDrawable("button-small-down");

        initTitle(stage);

        Label rules = getRulesLabel(stage);

        startButton = getStartButton();
        rulesButton = getRulesButton(rules);
        returnButton = getReturnButton(rules);
        exitButton = getExitButton();
        initInfoButton(stage);

    }

    private Label getRulesLabel(Stage stage) {
        Label rules = new Label(
                "Boggle Rules:\n\n1. Form words by connecting adjacent letters.\n2. Words must be 3 letters or longer.\n4. Long words earn more points.", buttonSkin);
        rules.setFontScale(1f);
        rules.setWrap(true);
        rules.setWidth(500);
        rules.setPosition(100, 70);
        stage.addActor(rules);
        rules.setVisible(false);
        return rules;
    }

    private BoggleButton getReturnButton(Label rules) {
        final BoggleButton returnButton;
        returnButton = new BoggleButton(400, 140,  70, 40) {};
        returnButton.setText("Return");
        this.stage.addActor(returnButton.getButton());
        returnButton.getButton().setVisible(false);
        returnButton.getButton().addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                startButton.getButton().setVisible(true);
                rulesButton.getButton().setVisible(true);
                returnButton.getButton().setVisible(false);
                rules.setVisible(false);
                return true;
            }
        });
        return returnButton;
    }

    private BoggleButton getStartButton() {
        final BoggleButton startButton;
        startButton = new BoggleButton(225,100,100,60){};
        startButton.setText("Start");
        this.stage.addActor(startButton.getButton());
        startButton.getButton().addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                playResponse = true;
            }
        });
        return startButton;
    }

    private BoggleButton getRulesButton(Label rules) {
        final BoggleButton rulesButton;
        rulesButton = new BoggleButton(225,25,100,60){};
        rulesButton.setText("Rules");
        this.stage.addActor(rulesButton.getButton());
        rulesButton.getButton().addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                startButton.getButton().setVisible(false);
                rulesButton.getButton().setVisible(false);
                returnButton.getButton().setVisible(true);
                rules.setVisible(true);
                return true;
            }
        });
        return rulesButton;
    }

    private BoggleButton getExitButton() {
        final BoggleButton exitButton;
        exitButton = new BoggleButton(0, 275,  40, 40) {};
        exitButton.setText("X");
        this.stage.addActor(exitButton.getButton());
        exitButton.getButton().addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
        });
        return exitButton;
    }

    private void initInfoButton(Stage stage) {
        Label authorTitle = new Label("Authors", buttonSkin);
        authorTitle.setVisible(false);
        authorTitle.setFontScale(2f);
        authorTitle.setPosition(400,250);
        stage.addActor(authorTitle);
        Label authorNames = new Label("Edilson A.\nKels C.\nThomas C.",buttonSkin);
        authorNames.setVisible(false);
        authorNames.setFontScale(1f);
        authorNames.setPosition(400,180);
        stage.addActor(authorNames);
        BoggleButton infoButton = new BoggleButton(500, 275, 40, 40) {};
        infoButton.setText("i");
        this.stage.addActor(infoButton.getButton());
        infoButton.getButton().addListener(new InputListener(){
            public void enter(InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor fromActor) {
                authorTitle.setVisible(true);
                authorNames.setVisible(true);
            }
            public void exit(InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor toActor) {
                authorTitle.setVisible(false);
                authorNames.setVisible(false);
            }
        });
    }

    private void initTitle(Stage stage) {
        Image titleImage = new Image(new Texture(Gdx.files.internal("assets/GameTitle.png")));
        titleImage.setPosition(125, 210);
        stage.addActor(titleImage);
    }
}
