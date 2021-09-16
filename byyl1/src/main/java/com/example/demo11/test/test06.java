package com.example.demo11.test;

import com.example.demo11.ConnectionTest;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class test06 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql = "select * from user";
        ConnectionTest connectionTest = new ConnectionTest();
        PreparedStatement ps = connectionTest.Connection1().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<ArrayList> aa = new ArrayList<>();
        while (rs.next()){
            ArrayList al = new ArrayList();
            al.add(rs.getInt("id"));
            al.add(rs.getInt("number"));
            al.add(rs.getString("name"));
            al.add(rs.getString("gender"));
            al.add(rs.getInt("age"));
            aa.add(al);
        }
        File file = new File("D://test12_01.xls");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            Label label =null;
            String[] title = {"id", "number", "name", "gender", "age"};
            for(int i=0; i<title.length; i++){
                label = new Label(i, 0, title[i]);
                sheet.addCell(label);
            }
            for (int i=0; i<aa.size(); i++){
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
