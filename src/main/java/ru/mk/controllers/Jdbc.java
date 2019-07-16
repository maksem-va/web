package ru.mk.controllers;

import java.sql.*;

public class Jdbc {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL =
            "jdbc:mysql://localhost/tutorial?serverTimezone=UTC";

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM students";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nStudents:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String secondName = resultSet.getString("secondname");
            int groupNumber = resultSet.getInt("groupNumber");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("FirstName: " + name);
            System.out.println("SecondName: " + secondName);
            System.out.println("Group: " + groupNumber);
        }

        System.out.println("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
