package org.ENSEACS.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import org.ENSEACS.core.Boggle;

public class BoggleDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "ENSEA Boggle";
		config.height = 324;
		config.width = 540;
		new LwjglApplication(new Boggle(), config);
	}
}
