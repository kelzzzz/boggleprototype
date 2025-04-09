package org.ENSEA-CS.html;

import org.ENSEA-CS.core.Boggle;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class BoggleHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new Boggle();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
