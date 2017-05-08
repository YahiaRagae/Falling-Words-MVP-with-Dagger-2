package xom.xyz.fallingwords.DataAccessLayer;

import android.content.Context;

import java.util.ArrayList;

import xom.xyz.fallingwords.DataAccessLayer.DataSource.DataSourceInterface;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.DataSourceType;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.Local.LocalDataSource;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.Online.OnlineDataSource;

/**
 * Created by yahia on 5/8/17.
 * This is a Single Tone which will provide the application with data
 */

public class DataAccessController implements DataSourceInterface{
    private DataSourceType dataSourceType;
    private OnlineDataSource  onlineDataSource;
    private LocalDataSource localDataSource;
    private DataSourceInterface dataSource;

    private static DataAccessController sharedInstance;

    public static DataAccessController getInstance(Context context) {
        if (sharedInstance == null) {
            sharedInstance = new DataAccessController(context);
        }

        return sharedInstance;
    }
    private DataAccessController(Context context) {
        onlineDataSource = new OnlineDataSource();
        localDataSource = new LocalDataSource();
    }

    /*
    Repository Pattern
     */
    private DataSourceInterface getDataSourceForType(DataSourceType dataSourceType){
        DataSourceInterface dataSource = null;
        switch (dataSourceType){
            case DataSourceLocal:
                dataSource =  localDataSource;
                break;

            case DataSourceOnline:{
                dataSource =  onlineDataSource;
                break;
            }
        }
        return dataSource;
    }
    public void setDataSource (DataSourceType dataSourceType){
        this.dataSourceType = dataSourceType;
        dataSource = getDataSourceForType(dataSourceType);
    }

    /*
    DataSourceInterface
     */
    @Override
    public ArrayList getWord() {
        return dataSource.getWord();
    }
}
