package xom.xyz.fallingwords.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xom.xyz.fallingwords.R;

public class MainActivity extends AppCompatActivity implements  IMainView   { 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showStartNewGameButton() {

    }

    @Override
    public void setGame(String question, Double Duration) {

    }

    @Override
    public void setRightScore(String scrore) {

    }

    @Override
    public void setWrongScore(String scrore) {

    }

    @Override
    public void showErrorMessage(String string) {

    }
}
