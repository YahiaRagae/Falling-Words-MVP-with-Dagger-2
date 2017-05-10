package xom.xyz.fallingwords.main;

import java.util.List;

import xom.xyz.fallingwords.DataAccessLayer.DataAccessController;
import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.WordsCompletionHandler;
import xom.xyz.fallingwords.design.model.GameModel;
import xom.xyz.fallingwords.design.model.factory.GameFactory;

/**
 * Created by yahia on 5/10/17.
 */

public class MainInteractorImpl implements  IMainInteractor {

    @Override
    public void loadWordsFromDataSource(WordsCompletionHandler wordsCompletionHandler) {
        DataAccessController.getInstance().getWords(wordsCompletionHandler);
    }

    @Override
    public GameModel loadNewGame(GameFactory.GameTypes type, List<WordItem> words) {
        return GameFactory.getGameModel(type,words);
    }


}
