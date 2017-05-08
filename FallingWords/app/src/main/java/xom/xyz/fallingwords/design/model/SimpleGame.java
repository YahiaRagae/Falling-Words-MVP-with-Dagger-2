package xom.xyz.fallingwords.design.model;

/**
 * Created by yahia on 5/8/17.
 */

public class SimpleGame implements  GameModel{
    //All the Data will be brought from Data Access Layer
    @Override
    public String getQuestion() {
        return null;
    }

    @Override
    public String getRightAnswer() {
        return null;
    }

    @Override
    public String getWrongAnser() {
        return null;
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public Double getTime() {
        return null;
    }
}
