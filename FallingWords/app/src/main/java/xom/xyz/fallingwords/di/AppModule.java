package xom.xyz.fallingwords.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xom.xyz.fallingwords.App;

/**
 * Created by yahia on 5/11/17.
 */

@Module
public class AppModule {
    private App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Singleton
    @Provides
    App providesContext() {
        return application;
    }


}