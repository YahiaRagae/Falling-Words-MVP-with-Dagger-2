package xom.xyz.fallingwords.main;

import java.util.List;

import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.WordsCompletionHandler;
import xom.xyz.fallingwords.design.model.GameModel;
import xom.xyz.fallingwords.design.model.factory.GameFactory;

/**
 * Created by yahia on 5/10/17.
 */

public interface IMainInteractor {

    void loadWordsFromDataSource(WordsCompletionHandler wordsCompletionHandler );
    GameModel loadNewGame(GameFactory.GameTypes type, List<WordItem> words);
}
