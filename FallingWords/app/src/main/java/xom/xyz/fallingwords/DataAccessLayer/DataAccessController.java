package xom.xyz.fallingwords.DataAccessLayer;

import android.content.Context;

/**
 * Created by yahia on 5/8/17.
 * This is a Single Tone which will provide the application with data
 */

public class DataAccessController {

    private static DataAccessController sharedInstance;

    public static DataAccessController getInstance(Context context) {
        if (sharedInstance == null) {
            sharedInstance = new DataAccessController(context);
        }

        return sharedInstance;
    }
    private DataAccessController(Context context) {
    }

}
