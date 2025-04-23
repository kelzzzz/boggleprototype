package org.ENSEACS.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import org.ENSEACS.core.Boggle;

public class BoggleDesktop {
	public static void main (String[] args) {
		System.out.println("Testing pre-commit hook");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Boggle(), config);
	}
}
