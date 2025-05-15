package org.ENSEACS.core.UI.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import org.ENSEACS.core.gamelogic.Player;

import static org.ENSEACS.core.util.Constants.SCROLLPANE_TEXTURE_PATH;
import static org.ENSEACS.core.util.Constants.SKIN_GLASSY_UI_JSON_PATH;

public class WordScrollPane {
    private final Skin skin = new Skin(Gdx.files.internal(SKIN_GLASSY_UI_JSON_PATH));

    private final Texture texture = new Texture(SCROLLPANE_TEXTURE_PATH); // Replace with a suitable image
    private final TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(texture));

    private final Label display = new Label("",skin);
    private final Table container = new Table();
    private final ScrollPane scrollPane = new ScrollPane(container,skin);

    public WordScrollPane(int x, int y, float h){
        display.setColor(Color.BLUE);
        initContainer();
        initScrollPane(x,y,h);
    }

    private void initContainer() {
        container.add(display);
        container.setBackground(drawable);
    }

    private void initScrollPane(int x, int y, float h) {
        scrollPane.setHeight(h);
        scrollPane.setX(x);
        scrollPane.setY(y);
    }

    public void updateWordsInDisplay(){
        this.display.setText(Player.getInstance().getWordsCreatedAsString());
    }

    public ScrollPane getScrollPane(){
        return this.scrollPane;
    }

}
