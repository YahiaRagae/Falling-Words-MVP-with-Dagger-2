package xom.xyz.fallingwords.design.model.factory;

import xom.xyz.fallingwords.design.model.GameModel;
import xom.xyz.fallingwords.design.model.SimpleGame;

/**
 * Created by yahia on 5/8/17.
 */

public class GameFactory {

    public enum GameTypes{
        GameTypesSimpleGame
    }


    public static GameModel getGameModel(GameTypes type){
        GameModel game = null;
        switch (type){
            case GameTypesSimpleGame:
                game = new SimpleGame();
            break;

            default:
                game = null;

        }

        return  game;
    }
}
