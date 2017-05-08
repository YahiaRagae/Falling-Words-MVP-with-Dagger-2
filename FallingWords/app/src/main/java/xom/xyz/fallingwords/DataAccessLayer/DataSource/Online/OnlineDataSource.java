package xom.xyz.fallingwords.DataAccessLayer.DataSource.Online;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.DataSourceInterface;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.WordsCompletionHandler;

/**
 * Created by yahia on 5/8/17.
 */

public class OnlineDataSource implements DataSourceInterface {
    private Services mServices = ServiceUtils.getService();

    @Override
    public void getWords(final WordsCompletionHandler wordsCompletionHandler) {
        mServices.getWords().enqueue(new Callback<List<WordItem>>() {
            @Override
            public void onResponse(Call<List<WordItem>> call, Response<List<WordItem>> response) {
                wordsCompletionHandler.completed(response.body() , true );
            }

            @Override
            public void onFailure(Call<List<WordItem>> call, Throwable t) {
                wordsCompletionHandler.completed(new ArrayList() , false);
            }
        });
    }
}
