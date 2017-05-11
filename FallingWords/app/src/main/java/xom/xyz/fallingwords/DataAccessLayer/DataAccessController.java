package xom.xyz.fallingwords.DataAccessLayer;

import xom.xyz.fallingwords.DataAccessLayer.DataSource.DataSourceInterface;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.DataSourceType;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.Local.LocalDataSource;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.Online.OnlineDataSource;
import xom.xyz.fallingwords.DataAccessLayer.DataSource.WordsCompletionHandler;
import xom.xyz.fallingwords.Utils.Connectivity;

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

    public static DataAccessController getInstance( ) {
        if (sharedInstance == null) {
            sharedInstance = new DataAccessController();
        }

        if(new Connectivity().isNetworkAvailable()){
            sharedInstance.setDataSource(DataSourceType.DataSourceOnline);
        }else{
            sharedInstance.setDataSource(DataSourceType.DataSourceLocal);
        }

        return sharedInstance;
    }
    private DataAccessController() {
        onlineDataSource = new OnlineDataSource();
        localDataSource = new LocalDataSource( );
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
    public void getWords(WordsCompletionHandler wordsCompletionHandler) {
        dataSource.getWords(wordsCompletionHandler);
    }

}
