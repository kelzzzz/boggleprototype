package org.ENSEACS.core;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Boggle implements ApplicationListener {
	FitViewport viewport;
	//For test commit
	@Override
	public void create () {
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
