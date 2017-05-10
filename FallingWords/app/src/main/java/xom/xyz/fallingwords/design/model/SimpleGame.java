package xom.xyz.fallingwords.design.model;

import java.util.List;

import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;

/**
 * Created by yahia on 5/8/17.
 */

public class SimpleGame implements  GameModel{
    List<WordItem> mWords;
    public SimpleGame(List<WordItem> words) {
        mWords = words;

    }

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
    public String getProposedAnswer() {
        return null;
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public Long getTime() {
        return null;
    }
}
