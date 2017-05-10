package xom.xyz.fallingwords.design.model;

import java.util.List;
import java.util.Random;

import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;


/**
 * Created by yahia on 5/8/17.
 */

public class SimpleGame implements  GameModel{
    WordItem word;
    String proposedAnswer;
    public SimpleGame(List<WordItem> words) {
        Random r = new Random();

        int randomWord = r.nextInt(words.size()-1);
        int randomProposedAnswer = r.nextInt(words.size()-1);


        word = words.get(randomWord);
        proposedAnswer = words.get(randomProposedAnswer).getTextEng();

    }

    //All the Data will be brought from Data Access Layer
    @Override
    public String getQuestion() {
        return word.getTextSpa();
    }

    @Override
    public String getRightAnswer() {
        return word.getTextEng();
    }

    @Override
    public String getProposedAnswer() {
        return proposedAnswer;
    }

    @Override
    public int getScore() {
        return 1;
    }

    @Override
    public Long getTime() {
        return 30L;
    }
}
