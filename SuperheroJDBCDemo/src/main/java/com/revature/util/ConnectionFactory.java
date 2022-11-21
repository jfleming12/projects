package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

// will produce a connection object (Factory)
// Singleton - one instance of that object
public class ConnectionFactory {
    // What is a Connection in Java?
    private static Connection connection = null;

    // Java won't make a default constructor and we won't have access to the constructor outside of the class:
    private ConnectionFactory() {

    }

    // we need one public method that returns the connection:
    public static Connection getConnection() {
        if(connection == null) {
            // Resource Bundle:
            ResourceBundle bundle = ResourceBundle.getBundle("DbConfig");
            // create the connection:
            String url = bundle.getString("url");
            String user = bundle.getString("username");
            String password = bundle.getString("password");
            try {
                connection = DriverManager.getConnection(url, user, password);

            } catch(SQLException exception) {
                exception.printStackTrace();
            }
        }
        // either way, we are returning the connection:
        return connection;
    }
}
