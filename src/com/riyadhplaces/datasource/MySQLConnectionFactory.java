package com.riyadhplaces.datasource;

import com.riyadhplaces.common.PropertiesReader;
import com.riyadhplaces.exceptions.DataSourceException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionFactory extends ConnectionFactory {

    private static final String CONFIG_FILE = "src/resources/mysql.properties";
    private static final String DRIVER_NAME = "MySQL";
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static PropertiesReader READER;
    private static final String ERROR_MSG = "can't connect to the DB, Please check your credentials";

    public MySQLConnectionFactory() {
        READER = new PropertiesReader(CONFIG_FILE);
        URL = READER.get("url");
        USER = READER.get("user");
        PASSWORD = READER.get("password");
    }

    @Override
    public String getURL() {
        return URL;
    }

    @Override
    public String getUser() {
        return USER;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getDriverName() {
        return DRIVER_NAME;
    }

    @Override
    public Connection creatConnection() throws DataSourceException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException ex) {
            System.out.println(ex);
            throw new DataSourceException(ERROR_MSG, ex);

        }
    }

}
