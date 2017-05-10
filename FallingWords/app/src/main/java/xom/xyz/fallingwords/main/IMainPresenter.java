package xom.xyz.fallingwords.main;

/**
 * Created by yahia on 5/9/17.
 */

public interface IMainPresenter {
    void onLoadData();
    void onStartNewGameClicked();
    void onCorrectTranslationButtonClicked();
    void onWrongTranslationButtonClicked();
    void onWordReachBottomOfScreen();
    void onTimeOutWithoutSelection();
}
