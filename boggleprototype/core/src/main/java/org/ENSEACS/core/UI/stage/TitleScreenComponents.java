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

public class TitleScreenComponents {
    private Stage stage;
    private final Skin buttonSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    private final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
    public boolean exitResponse = false;
    public boolean playResponse = false;

    public TitleScreenComponents(Stage stage){
        this.stage = stage;
        textButtonStyle.font = new BitmapFont();

        textButtonStyle.up = buttonSkin.getDrawable("button-small");
        textButtonStyle.down = buttonSkin.getDrawable("button-small-down");

        initTitle(stage);

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

        Label rules = new Label(
                "Boggle Rules:\n\n1. Form words by connecting adjacent letters.\n2. Words must be 3 letters or longer.\n4. Long words earn more points.", buttonSkin);
        rules.setFontScale(1f);
        rules.setWrap(true);
        rules.setWidth(500);
        rules.setPosition(100, 70);
        stage.addActor(rules);
        rules.setVisible(false);


        BoggleButton returnButton = new BoggleButton(400, 140,  70, 40) {};
        returnButton.setText("Return");
        this.stage.addActor(returnButton.getButton());
        returnButton.getButton().setVisible(false);

        BoggleButton StartButton = new BoggleButton(225,100,100,60){};
        StartButton.setText("Start");
        this.stage.addActor(StartButton.getButton());

        StartButton.getButton().addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                playResponse = true;
                return true;
            }
        });

        BoggleButton RulesButton = new BoggleButton(225,25,100,60){};
        RulesButton.setText("Rules");
        this.stage.addActor(RulesButton.getButton());
        RulesButton.getButton().addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                StartButton.getButton().setVisible(false);
                RulesButton.getButton().setVisible(false);
                returnButton.getButton().setVisible(true);
                rules.setVisible(true);
                return true;
            }
        });

        returnButton.getButton().addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                StartButton.getButton().setVisible(true);
                RulesButton.getButton().setVisible(true);
                returnButton.getButton().setVisible(false);
                rules.setVisible(false);
                return true;
            }
        });

        BoggleButton ExitButton = new BoggleButton(0, 275,  40, 40) {};
        ExitButton.setText("X");
        this.stage.addActor(ExitButton.getButton());
        ExitButton.getButton().addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }
        });

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
