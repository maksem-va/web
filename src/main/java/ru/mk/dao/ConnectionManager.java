package ru.mk.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ConnectionManager {
    private Properties properties = null;


    private static ConnectionManager ourInstance = new ConnectionManager();

    public static ConnectionManager getInstance() {
        return ourInstance;
    }

    private ConnectionManager() {
        init();
    }

    private void init() {
        try {
            properties = getProperties();
            Connection connection = getInitialConnection();
            Statement statement = connection.createStatement();
            createInitialState(statement);
            destroy(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        try {
            Class.forName(properties.getProperty("jdbc.driver"));
            return initConnection(
                    properties.getProperty("jdbc.url") + "/" + properties.getProperty("jdbc.name")
                            + "?" + properties.getProperty("jdbc.timezone"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password"));
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Connection getInitialConnection() {
        try {
            Class.forName(properties.getProperty("jdbc.driver"));
            return initConnection(
                    properties.getProperty("jdbc.url")
                            + "?" + properties.getProperty("jdbc.timezone"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password"));
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Connection initConnection(String url, String username, String password) {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void destroy(Connection connection, Statement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }


    private void createInitialState(Statement statement) {
        String initPath = "init.sql";
        String createTableSQL = getInitQuieries(initPath);
        Arrays.stream(createTableSQL.split(";")).filter(x -> (!x.equals("\n"))).forEach(x -> {
            try {
                statement.execute(x);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }


    private String getInitQuieries(String path) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        return new BufferedReader(new InputStreamReader(inputStream)).lines()
                .parallel().collect(Collectors.joining("\n"));

    }

    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            String propertiesPath = "dataBase.properties";
            properties.load(getClass().getClassLoader().getResourceAsStream(propertiesPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
