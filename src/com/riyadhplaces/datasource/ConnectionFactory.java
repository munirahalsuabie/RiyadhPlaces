package com.riyadhplaces.datasource;

import com.riyadhplaces.exceptions.DataSourceException;
import java.sql.Connection;

public abstract class ConnectionFactory {

    public abstract String getURL();

    public abstract String getUser();

    public abstract String getPassword();

    public abstract String getDriverName();

    public abstract Connection creatConnection() throws DataSourceException;

    public static ConnectionFactory getConnectionFactory(DataSourceType factory) {
        return new MySQLConnectionFactory();
    }
}
