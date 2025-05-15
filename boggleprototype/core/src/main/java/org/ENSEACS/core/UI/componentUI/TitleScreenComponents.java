package org.ENSEACS.core.UI.componentUI;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import org.ENSEACS.core.UI.interactable.BoggleButton;
import org.ENSEACS.core.UI.interactable.TitleScreenButton;
import org.ENSEACS.core.UI.logicUI.TitleScreenButtonActionListener;
import org.ENSEACS.core.UI.stateUI.MainGameplayState;
import org.ENSEACS.core.UI.stateUI.UIContext;

import javax.swing.*;

public class TitleScreenComponents {
    /*TODO
    *  Take a stage object in the constructor, and add all components to it. */

    private Stage stage;
    private final Skin buttonSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    private final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
    private final UIContext uiContext;

    public TitleScreenComponents(Stage stage, UIContext uiContext){
        this.stage = stage;
        this.uiContext = uiContext;

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


        BoggleButton returnButton = new TitleScreenButton(400, 140, "Return", 70, 40, textButtonStyle);
        returnButton.addButtonToStage(stage);
        returnButton.getButton().setVisible(false);

        BoggleButton StartButton = new TitleScreenButton(225,100,"Start",100,60,textButtonStyle);
        StartButton.addButtonToStage(stage);
        StartButton.getButton().addListener(new TitleScreenButtonActionListener(uiContext){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                uiContext.setState(new MainGameplayState());
                return true;
            }
        });

        BoggleButton RulesButton = new TitleScreenButton(225,25,"Rules",100,60,textButtonStyle);
        RulesButton.addButtonToStage(stage);
        RulesButton.getButton().addListener(new TitleScreenButtonActionListener(uiContext){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                StartButton.getButton().setVisible(false);
                RulesButton.getButton().setVisible(false);
                returnButton.getButton().setVisible(true);
                rules.setVisible(true);
                return true;
            }
        });

        returnButton.getButton().addListener(new TitleScreenButtonActionListener(uiContext){
           @Override
           public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               StartButton.getButton().setVisible(true);
               RulesButton.getButton().setVisible(true);
               returnButton.getButton().setVisible(false);
               rules.setVisible(false);
               return true;
           }
        });

        BoggleButton ExitButton = new TitleScreenButton(0,275,"X",40,40,textButtonStyle);
        ExitButton.addButtonToStage(stage);
        ExitButton.getButton().addListener(new TitleScreenButtonActionListener(uiContext){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }
        });

        BoggleButton infoButton = new TitleScreenButton(500,275,"i",40,40,textButtonStyle);
        infoButton.addButtonToStage(stage);
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
