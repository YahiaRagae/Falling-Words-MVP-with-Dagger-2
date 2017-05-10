package xom.xyz.fallingwords.main;

/**
 * Created by yahia on 5/9/17.
 */

public interface IMainView {
    void showLoading();
    void hideLoading();
    void showStartNewGameButton();
    void startGame(String question,String proposedAnswer,Double Duration);
    void setRightScore(String scrore);
    void setWrongScore(String scrore);


    void showErrorMessage(String string);
}
