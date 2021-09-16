package com.example.demo11;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionTest connectionTest = new ConnectionTest();
        String sql = "select * from user ";
        PreparedStatement preparedStatement = connectionTest.Connection1().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> list = new ArrayList<>();
        while (resultSet.next()){
            User user1 = new User();
            user1.setId(resultSet.getInt("id"));
            user1.setName(resultSet.getString("name"));
            user1.setPassword(resultSet.getString("password"));
            user1.setSex(resultSet.getString("sex"));
            user1.setTel(resultSet.getString("tel"));
            list.add(user1);
            //System.out.println("id:"+id+"   "+"name:"+name+"   "+"password:"+password+"   "+"sex:"+sex+"   "+"tel:"+tel);
            System.out.println(list);
        }
    }
}
