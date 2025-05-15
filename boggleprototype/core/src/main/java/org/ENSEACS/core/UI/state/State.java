package org.ENSEACS.core.UI.state;

public interface State {
    void clickPlay();
    void clickExit();
    void clickInfo();
    void clickRules();
    void onTimerRunOut();
}
