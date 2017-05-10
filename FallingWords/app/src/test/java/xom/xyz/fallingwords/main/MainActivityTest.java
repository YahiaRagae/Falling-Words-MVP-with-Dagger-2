package xom.xyz.fallingwords.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yahia on 5/10/17.
 */
public class MainActivityTest {
    @Test
    public void getProgress() throws Exception {
        MainActivity ac= new MainActivity();
        int progress = ac.getProgress(15,30) ;
        assertEquals(progress, 50 );
    }

    @Test
    public void getfinishedSeconds() throws Exception {
        MainActivity ac= new MainActivity();
        int seconds = ac.getfinishedSeconds(5000);
        assertEquals(seconds, 5 );
    }


}