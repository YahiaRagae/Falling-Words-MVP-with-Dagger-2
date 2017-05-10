package xom.xyz.fallingwords.DataAccessLayer.DataSource.Local;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.DataSourceInterface;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.WordsCompletionHandler;

/**
 * Created by yahia on 5/8/17.
 */

public class LocalDataSource implements DataSourceInterface{
    Context  mContext;
    public LocalDataSource(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public void getWords(WordsCompletionHandler wordsCompletionHandler) {
        new LoadLocalData().execute(wordsCompletionHandler);
    }


    protected String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = mContext.getAssets().open("words.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    private class LoadLocalData extends AsyncTask< WordsCompletionHandler   , Void, Void> {


        @Override
        protected Void doInBackground(WordsCompletionHandler... params) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type listType = new TypeToken<ArrayList<WordItem>>(){}.getType();
            List<WordItem > items = gson.fromJson(loadJSONFromAsset(), listType);
            params[0].completed(items,true);
            return null;
        }
    }

}
