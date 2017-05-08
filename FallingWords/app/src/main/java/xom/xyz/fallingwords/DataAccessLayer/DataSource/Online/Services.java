package xom.xyz.fallingwords.DataAccessLayer.DataSource.Online;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;

/**
 * Created by yahia on 5/8/17.
 */

public interface Services {
    @GET("7ac6cdb4bf5e032f4c737aaafe659b33/raw/baa9fe0d586082d85db71f346e2b039c580c5804/words.json")
    Call<List<WordItem>> getWords();


}
