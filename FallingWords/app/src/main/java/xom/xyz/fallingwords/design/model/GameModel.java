package xom.xyz.fallingwords.design.model;

/**
 * Created by yahia on 5/8/17.
 */

public interface GameModel {
    String getQuestion();
    String getRightAnswer();
    String getProposedAnswer();
    int getScore();
    Long getTime();
}
