package xom.xyz.fallingwords.main;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;
import com.leo.simplearcloader.SimpleArcLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xom.xyz.fallingwords.R;

public class MainActivity extends AppCompatActivity implements  IMainView   {
    MainPresenterImpl  mainPresenter;
    SimpleArcDialog hud;

    @BindView(R.id.tv_wrong_score)
    TextView mTVWrongScore;

    @BindView(R.id.tv_right_score)
    TextView mTVRightScore;

    @BindView(R.id.tv_question)
    TextView mTVQuestion;

    @BindView(R.id.tv_answer)
    TextView mTVAnswer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenterImpl(this,new MainInteractorImpl());
        mainPresenter.onLoadData();
    }

    @Override
    public void showLoading() {
        if (hud == null) {
            hud = new SimpleArcDialog(this);
            ArcConfiguration configuration = new ArcConfiguration(this);
            configuration.setLoaderStyle(SimpleArcLoader.STYLE.COMPLETE_ARC);
            int[] colors = {ContextCompat.getColor(this, R.color.colorAccent),
                    ContextCompat.getColor(this, R.color.colorPrimary),
                    ContextCompat.getColor(this, R.color.colorPrimaryDark)};
            configuration.setColors(colors);
            hud.setConfiguration(configuration);
        }
        hud.show();
    }

    @Override
    public void hideLoading() {
        if (hud != null) {
            hud.dismiss();
        }
    }

    @Override
    public void showStartNewGameButton() {

    }

    @Override
    public void setGame(String question, Double Duration) {

    }

    @Override
    public void setRightScore(String scrore) {
        mTVRightScore.setText(scrore);
    }

    @Override
    public void setWrongScore(String scrore) {
        mTVWrongScore.setText(scrore);
    }

    @Override
    public void showErrorMessage(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btn_correct_translation) void onRightBtnClicked(){
        mainPresenter.onCorrectTranslationButtonClicked();
    }

    @OnClick(R.id.btn_wrong_translation)void onWrongTranslationButtonClicked(){
        mainPresenter.onWrongTranslationButtonClicked();
    }

    @OnClick(R.id.btn_start_game)void onStartNewGameBtnClicked(){
        mainPresenter.onStartNewGameClicked();
    }
}
