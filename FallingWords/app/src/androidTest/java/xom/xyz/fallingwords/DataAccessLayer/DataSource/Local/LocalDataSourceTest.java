package xom.xyz.fallingwords.DataAccessLayer.DataSource.Local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.jayway.awaitility.Awaitility;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import xom.xyz.fallingwords.DataAccessLayer.DataModels.WordItem;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.WordsCompletionHandler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by yahia on 5/10/17.
 */
public class LocalDataSourceTest {
    LocalDataSource localDataSource;
    @Before
    public void setUp() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        localDataSource = new LocalDataSource();
    }

    @Test
    public void getWords() throws Exception {
        final AtomicBoolean done = new AtomicBoolean() ;
        done.set(false);
        localDataSource.getWords(new WordsCompletionHandler() {
            @Override
            public void completed(List<WordItem> items, Boolean status) {
                assertThat(items, is(notNullValue()));
                assertThat(items.isEmpty(), is(false));
                done.set(true);
            }
        });
        Awaitility.await().atMost(10, TimeUnit.SECONDS).untilTrue(done);
    }

    @Test
    public void loadJSONFromAsset() throws Exception {
        String json = localDataSource.loadJSONFromAsset();
        assertThat(json, is(notNullValue()));
    }

}