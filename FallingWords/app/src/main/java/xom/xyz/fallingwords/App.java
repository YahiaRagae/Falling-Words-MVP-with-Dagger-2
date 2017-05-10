package xom.xyz.fallingwords;

import android.app.Application;
import android.content.Context;

/**
 * Created by yahia on 5/10/17.
 */

public class App extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
