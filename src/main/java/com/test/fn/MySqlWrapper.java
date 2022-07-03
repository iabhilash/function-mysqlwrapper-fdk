package com.test.fn;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import java.sql.SQLException;

import java.util.Properties;

public class MySqlWrapper {

    private String jdbcUrl = "jdbc:mysql://%s:%d";
    private Properties dbProperties;
    private Connection connection;


    public MySqlWrapper(String user, String pass, String ipAddress, Integer port) {
        try {
            dbProperties = new Properties();
            dbProperties.setProperty("user", user);
            dbProperties.setProperty("password", pass);
            jdbcUrl = String.format(jdbcUrl, ipAddress, port);
        } catch (Exception e) {
            System.out.printf("Error setting up MySqlWrapper:", e);
        }
    }

    public boolean connect() throws SQLException {
        try {
            connection = java.sql.DriverManager.getConnection(jdbcUrl, dbProperties);
        } catch (Exception e) {
            System.out.printf("Error setting up connection and Message: " + e.getMessage());
            throw e;

        }
        return true;
    }

    public String getClientVersion() {
        try {
            connection = java.sql.DriverManager.getConnection(jdbcUrl, dbProperties);
            DatabaseMetaData metadata = connection.getMetaData();
            return metadata.getDriverName() + " " + metadata.getDriverMajorVersion() + " "
                + metadata.getDriverMinorVersion();
        } catch (SQLException e) {
            System.out.printf("Error getting client version and Message: ", e.getMessage());
        }
        return null;
    }

}