package xom.xyz.fallingwords.main;

import java.util.List;

import javax.inject.Inject;

import xom.xyz.fallingwords.App;
import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.WordsCompletionHandler;
import xom.xyz.fallingwords.R;
import xom.xyz.fallingwords.design.model.GameModel;
import xom.xyz.fallingwords.design.model.factory.GameFactory;

/**
 * Created by yahia on 5/9/17.
 */

public class MainPresenterImpl implements IMainPresenter,WordsCompletionHandler {
    private IMainView iMainView;
    private MainInteractorImpl mainInteractor;
    private List<WordItem> items;

    private GameModel currentGame;
    private int rightScore = 0 ;
    private int wrongScore = 0 ;

    @Inject
    App mContext;

    public MainPresenterImpl(IMainView iMainView,MainInteractorImpl mainInteractor) {
        this.iMainView = iMainView;
        this.mainInteractor = mainInteractor;

        App.getAppComponent().inject(this);
    }

    @Override
    public void onLoadData() {
        if (iMainView != null) {
            iMainView.showLoading();
        }
        mainInteractor.loadWordsFromDataSource(this);
    }

    @Override
    public void completed(List<WordItem> items, Boolean status) {
        if (iMainView != null) {
            iMainView.hideLoading();
        }
        if(status){
            this.items = items;
        }
        if (iMainView != null) {
            iMainView.showStartNewGameButton();
        }
    }

    @Override
    public void onStartNewGameClicked() {
        if(items != null){
            currentGame = mainInteractor.loadNewGame(GameFactory.GameTypes.GameTypesSimpleGame,items);
            iMainView.startGame(currentGame.getQuestion(),currentGame.getProposedAnswer(),currentGame.getTime());
        }else{
            iMainView.showErrorMessage(mContext.getString(R.string.error));
        }
    }

    @Override
    public void onCorrectTranslationButtonClicked() {
        if(currentGame.getProposedAnswer().equals(currentGame.getRightAnswer())){
            rightScore += currentGame.getScore();
        }else{
            wrongScore += currentGame.getScore();
        }
        setScore();

    }


    @Override
    public void onWrongTranslationButtonClicked() {
        if(!currentGame.getProposedAnswer().equals(currentGame.getRightAnswer())){
            rightScore += currentGame.getScore();
        }else{
            wrongScore += currentGame.getScore();
        }
        setScore();

    }

    @Override
    public void onWordReachBottomOfScreen() {
        wrongScore += currentGame.getScore();
        setScore();
    }


    private void setScore() {
        if(iMainView != null ){
            iMainView.setWrongScore(wrongScore+"");
            iMainView.setRightScore(rightScore+"");
            iMainView.showStartNewGameButton();
        }
    }

}