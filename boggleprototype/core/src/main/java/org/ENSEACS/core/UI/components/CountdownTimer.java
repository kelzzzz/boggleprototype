package org.ENSEACS.core.UI.components;

import org.ENSEACS.core.UI.components.interactable.BoggleButton;

import java.text.SimpleDateFormat;

import static org.ENSEACS.core.util.Constants.MINUTES_REGEX;
import static org.ENSEACS.core.util.Constants.THREE_MINUTES_MILLIS;

/*
 * Author: Kels C.
 * ENSEA 2025 */
public class CountdownTimer extends BoggleButton {

    private final long endTime;

    public CountdownTimer(int x, int y, int dimensionsW, int dimensionsH) {
        super(x, y, dimensionsW, dimensionsH);
        long startTime = System.currentTimeMillis();
        endTime = startTime + THREE_MINUTES_MILLIS;
    }

    public void updateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat(MINUTES_REGEX);
        String strTime = sdf.format(this.endTime-System.currentTimeMillis());
        this.getButton().setText(strTime); //change each elapsed sec
    }

    public boolean getTimeoutResponse(){
        return this.endTime - System.currentTimeMillis() <= 0;
    }

}
