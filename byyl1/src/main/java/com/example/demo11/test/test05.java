package com.example.demo11.test;

import java.sql.*;

public class test05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlite:spring.sqlite";
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(url);
        System.out.println("连接成功！");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from user");
        while (rs.next()){
            int id = rs.getInt("id");
            int number = rs.getInt("number");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            int age = rs.getInt("age");
            System.out.println(id + " " + number + " "+ name +" "+gender+" "+age);
        }
    }
}
