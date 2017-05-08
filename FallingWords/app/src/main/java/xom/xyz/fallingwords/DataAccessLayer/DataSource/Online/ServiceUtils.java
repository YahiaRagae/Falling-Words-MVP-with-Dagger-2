package xom.xyz.fallingwords.DataAccessLayer.DataSource.Online;

/**
 * Created by yahia on 5/8/17.
 */

public class ServiceUtils {
    public static final String BASE_URL = "https://gist.githubusercontent.com/DroidCoder/";

    public static Services getService() {
        return OnlineClient.getClient(BASE_URL).create(Services.class);
    }
}
