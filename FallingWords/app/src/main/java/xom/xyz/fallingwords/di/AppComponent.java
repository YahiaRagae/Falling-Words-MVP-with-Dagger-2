package xom.xyz.fallingwords.di;

import javax.inject.Singleton;

import dagger.Component;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.Local.LocalDataSource;
import xom.xyz.fallingwords.Utils.Connectivity;
import xom.xyz.fallingwords.main.MainPresenterImpl;

/**
 * Created by yahia on 5/11/17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(LocalDataSource mainActivity);
    void inject(MainPresenterImpl mainPresenterImpl);
    void inject(Connectivity connectivity);
}

