package by.fpmibsu.find_a_friend.controller;

import by.fpmibsu.find_a_friend.services.DIContainer;
import by.fpmibsu.find_a_friend.utils.Mediatr;

import javax.sql.ConnectionPoolDataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) {
        var properties = new Properties();
        try {
            properties.load(new FileReader("config/config.properties"));
        } catch (IOException exception) {
            System.out.println("Failed to start the app, cannot read config");
            exception.printStackTrace();
            return;
        }
        var dbPath = (String) properties.getProperty("database_url");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbPath);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to closed db connection");
            e.printStackTrace();
            return;
        }
    }
}