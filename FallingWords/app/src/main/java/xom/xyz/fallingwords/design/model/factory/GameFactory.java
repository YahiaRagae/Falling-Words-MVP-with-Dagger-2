package xom.xyz.fallingwords.design.model.factory;

import java.util.List;

import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;
import xom.xyz.fallingwords.design.model.GameModel;
import xom.xyz.fallingwords.design.model.SimpleGame;

/**
 * Created by yahia on 5/8/17.
 */

public class GameFactory {

    public enum GameTypes{
        GameTypesSimpleGame
    }


    public static GameModel getGameModel(GameTypes type, List<WordItem> words){
        GameModel game = null;
        switch (type){
            case GameTypesSimpleGame:
                game = new SimpleGame(words);
            break;

            default:
                game = null;

        }

        return  game;
    }
}
