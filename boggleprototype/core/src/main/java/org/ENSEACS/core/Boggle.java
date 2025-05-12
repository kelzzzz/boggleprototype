package org.ENSEACS.core;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.ENSEACS.core.UI.stateUI.MainGameplayState;
import org.ENSEACS.core.UI.stateUI.UIContext;

import java.util.ArrayList;

import static com.badlogic.gdx.Application.LOG_INFO;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class Boggle implements ApplicationListener {
	private FitViewport viewport;

	private static final Logger LOGGER = new Logger(Boggle.class.getName(),LOG_INFO);

	private final ArrayList<Texture> bgTextures = new ArrayList<Texture>();

	private SpriteBatch spriteBatch;

	private final UIContext uic = new UIContext();

	@Override
	public void create () {
		LOGGER.info("Creating main viewport.");
		viewport = new FitViewport(8,5);
		initBackgroundTextures();
		spriteBatch = new SpriteBatch();
		uic.setState(new MainGameplayState());
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
		drawBackgroundTexturesBatch();
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

	private void initBackgroundTextures() {
		for(int i = 0; i < 4; i++){
			this.bgTextures.add(new Texture(Gdx.files.internal((i+1)+".png")));
		}
	}

	private void drawBackgroundTexturesBatch() {
		for(Texture t : this.bgTextures){
			drawBgTexture(t);
		}
	}
}
