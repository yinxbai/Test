package com.example.demo11.test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class test07 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://106.12.61.111:3306/jike18_12?useCursorFetch=true&amp;autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=UTF-8";
        String username = "root";
        String password = "Asd688549@";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("连接成功");
        PreparedStatement ps = conn.prepareStatement("");
        ResultSet rs = ps.executeQuery("select * from users;");
        ArrayList<ArrayList> aa = new ArrayList<>();
        while(rs.next()){
            ArrayList a = new ArrayList();
            a.add(rs.getInt("id"));
            a.add(rs.getInt("number"));
            a.add(rs.getString("name"));
            a.add(rs.getString("gender"));
            a.add(rs.getInt("age"));
            aa.add(a);
        }
        File file = new File("F://test12.xls");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            Label label = null;
            String[] title = {"id", "number", "name", "gender", "age"};
            for(int i=0; i<title.length; i++){
                label = new Label(i, 0, title[i]);
                sheet.addCell(label);
            }
            for(int i=0; i<aa.size(); i++){
                for(int j=0; j<aa.get(i).size(); j++){
                    label = new Label(j, i+1, aa.get(i).get(j).toString());
                    sheet.addCell(label);
                }
            }
            workbook.write();
            workbook.close();
        }catch (Exception e){

        }
    }
}
