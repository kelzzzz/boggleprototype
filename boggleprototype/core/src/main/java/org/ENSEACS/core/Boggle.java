package org.ENSEACS.core;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.ENSEACS.core.graphics.LetterTile;

public class Boggle implements ApplicationListener {
	FitViewport viewport;
	LetterTile lt = new LetterTile();

	@Override
	public void create () {
		viewport = new FitViewport(8,5);
		lt.create();
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
