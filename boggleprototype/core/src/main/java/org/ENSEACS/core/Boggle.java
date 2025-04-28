package org.ENSEACS.core;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static com.badlogic.gdx.Application.LOG_INFO;

public class Boggle implements ApplicationListener {
	FitViewport viewport;
	private static final Logger LOGGER = new Logger(Boggle.class.getName(),LOG_INFO);

	@Override
	public void create () {
		LOGGER.info("Creating main viewport.");
		viewport = new FitViewport(8,5);
	}

	@Override
	public void resize (int width, int height) {
		viewport.update(width, height, true); // true centers the camera
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
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
