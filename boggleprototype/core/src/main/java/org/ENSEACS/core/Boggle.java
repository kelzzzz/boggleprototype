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

import static com.badlogic.gdx.Application.LOG_INFO;

/*
 * Author: Kels C.
 * ENSEA 2025 */

public class Boggle implements ApplicationListener {
	private FitViewport viewport;
	private static final Logger LOGGER = new Logger(Boggle.class.getName(),LOG_INFO);

	/*TODO These could be in a list :/*/
	private Texture backgroundTextureA;
	private Texture backgroundTextureB;
	private Texture backgroundTextureC;
	private Texture backgroundTextureD;

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

	private void drawBgTexture(Texture backgroundTextureA) {
		spriteBatch.draw(backgroundTextureA, 0, 0, backgroundTextureA.getWidth(), backgroundTextureA.getHeight());
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
		backgroundTextureA = new Texture(Gdx.files.internal("1.png"));
		backgroundTextureB = new Texture(Gdx.files.internal("2.png"));
		backgroundTextureC = new Texture(Gdx.files.internal("3.png"));
		backgroundTextureD = new Texture(Gdx.files.internal("4.png"));
	}

	private void drawBackgroundTexturesBatch() {
		drawBgTexture(backgroundTextureA);
		drawBgTexture(backgroundTextureB);
		drawBgTexture(backgroundTextureC);
		drawBgTexture(backgroundTextureD);
	}
}
