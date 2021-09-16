package com.example.demo11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public Connection Connection1 ()throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/user?serverTimezone=GMT";
        String name = "root";
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,name,password);
        return connection;
    }
}
