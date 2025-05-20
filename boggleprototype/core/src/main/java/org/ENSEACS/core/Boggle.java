package org.ENSEACS.core;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.ENSEACS.core.UI.state.children.MainGameplayState;
import org.ENSEACS.core.UI.state.UIContext;
import org.ENSEACS.core.UI.state.children.TitleScreenState;

import java.util.ArrayList;

import static com.badlogic.gdx.Application.LOG_INFO;
import static org.ENSEACS.core.util.Constants.BACKGROUND_TEXTURE_PATH;

/*
 * Author: Kels C
 * ENSEA 2025 */

public class Boggle implements ApplicationListener {
	private FitViewport viewport;
	private static final Logger LOGGER = new Logger(Boggle.class.getName(),LOG_INFO);
	private Texture backgroundTexture;
	private final ArrayList<Texture> bgTextures = new ArrayList<Texture>();

	private SpriteBatch spriteBatch;

	private final UIContext uic = new UIContext();

	@Override
	public void create () {
		LOGGER.info("Creating main viewport.");
		viewport = new FitViewport(8,5);
		this.spriteBatch = new SpriteBatch();
		this.backgroundTexture = new Texture(Gdx.files.internal(BACKGROUND_TEXTURE_PATH));
		uic.setState(new TitleScreenState(uic));
	}


	@Override
	public void resize (int width, int height) {
		viewport.update(width, height, true); // true centers the camera
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		drawBgTexture(this.backgroundTexture);
		spriteBatch.end();
		uic.renderState();
	}

	private void drawBgTexture(Texture backgroundTexture) {
		spriteBatch.draw(backgroundTexture, 0, 0, backgroundTexture.getWidth(), backgroundTexture.getHeight());
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}
}
