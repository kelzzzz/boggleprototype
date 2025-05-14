package org.ENSEACS.core.UI.componentUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import org.ENSEACS.core.UI.interactable.BoggleButton;
import org.ENSEACS.core.gamelogic.Player;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class GameplayHUD {

    private final Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    private final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();

    private final Label scoreLbl = new Label("Score: " + 0, skin);
    private final Label listOfWordsCreated = new Label("",skin);
    private BoggleButton timer;

    public GameplayHUD(Stage stage){
        initTimerActor(stage);
        initScoreLabelActor(stage);
        initFoundWordsScrollPane(stage);
    }

    private void initFoundWordsScrollPane(Stage stage) {
        listOfWordsCreated.setColor(Color.BLUE);
        Table innerTable = new Table();
        innerTable.add(listOfWordsCreated);
        Texture texture = new Texture("white.png"); // Replace with a suitable image
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(texture));
        innerTable.setBackground(drawable);
        ScrollPane scrollPane = new ScrollPane(innerTable,skin);
        scrollPane.setHeight(100f);
        scrollPane.setX(335);
        scrollPane.setY(160);
        stage.addActor(scrollPane);
    }

    private void initTimerActor(Stage stage) {
        textButtonStyle.font = new BitmapFont();
        textButtonStyle.up = skin.getDrawable("button-small");
        timer = new BoggleButton(100,100,100,50,textButtonStyle) {};
        timer.formatButton(350,100);
        timer.getButton().setText("00:00");
        timer.addButtonToStage(stage);
    }

    private void initScoreLabelActor(Stage stage) {
        scoreLbl.setX(353);
        scoreLbl.setY(270);
        scoreLbl.setFontScale(1.2f);
        scoreLbl.setColor(Color.BLUE);
        stage.addActor(scoreLbl);
    }

    public void updateHud(){
        this.scoreLbl.setText("Score: " + Player.getInstance().getScore());
        this.listOfWordsCreated.setText(Player.getInstance().getWordsCreatedAsString());
        this.timer.getButton().setText("01:01"); //change each elapsed sec
    }
}
