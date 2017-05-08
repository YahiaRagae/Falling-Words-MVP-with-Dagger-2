package xom.xyz.fallingwords.DataAccessLayer.DataSource;

import java.util.List;

import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;

/**
 * Created by yahia on 5/9/17.
 */

public interface WordsCompletionHandler {
    public void completed(final List<WordItem> items , Boolean status);

}
