package xom.xyz.fallingwords.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

import xom.xyz.fallingwords.App;

/**
 * Created by yahia on 5/10/17.
 */

public class Connectivity {
    @Inject
    App mContext;

    public Connectivity(){
        App.getAppComponent().inject(this);
    }

    public  boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
