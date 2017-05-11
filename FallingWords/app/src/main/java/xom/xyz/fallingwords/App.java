package xom.xyz.fallingwords;

import android.app.Application;

import xom.xyz.fallingwords.di.AppComponent;
import xom.xyz.fallingwords.di.AppModule;
import xom.xyz.fallingwords.di.DaggerAppComponent;

/**
 * Created by yahia on 5/10/17.
 */


public class App extends Application {

    static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initAppCompnent(this);
    }

    private AppComponent initAppCompnent(App app) {
        if(appComponent == null){
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }

        return appComponent;
    }

    public static AppComponent getAppComponent(){
        return  appComponent;
    }


}