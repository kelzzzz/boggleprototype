package org.ENSEACS.core.graphics;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;

public class LetterTileGrid extends Game {
    private Stage stage;
    private final Skin buttonSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    private final ArrayList<LetterTile> letterTiles = new ArrayList<LetterTile>();
    private final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();

    /*Magic Numbers*/
    private final int X_INIT = 40;
    private final int Y_INIT = 20;
    private final int X_INCR = 50;
    private final int Y_INCR = 50;

    @Override
    public void create() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        textButtonStyle.font = new BitmapFont();
        textButtonStyle.up = buttonSkin.getDrawable("button-small");
        textButtonStyle.down = buttonSkin.getDrawable("button-small-down");
        int x = X_INIT;
        int y = Y_INIT;

        stage = new Stage();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j<4;j++){
                y+=Y_INCR;
                LetterTile lt = new LetterTile(x,y,textButtonStyle);
                letterTiles.add(lt);
            }
            y=Y_INIT;
            x+=X_INCR;
        }

        for(LetterTile t : letterTiles){
            t.addButtonToStage(stage);
        }
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        super.render();
        stage.draw();
        stage.act();
        stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
    }

    /*TODO
        No letters can appear more than thrice
        Randomize a tile of that letter, if so*/
    public void normalizeLetterTilesCounts(ArrayList<LetterTile> tiles){
        for(LetterTile t : tiles){

        }
    }
}
