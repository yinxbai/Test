package com.example.demo11.controller;


import com.example.demo11.ConnectionTest;
import com.example.demo11.entities.User;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.core.io.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@org.springframework.stereotype.Controller
public class Controller {



    String sql = "select * from user";




    @RequestMapping("/index")
    public String index(){
        return "IndexM";
    }

    @GetMapping("/index1")
    public String index1(){
        return "IndexM";
    }


    @RequestMapping("list1")
    @ResponseBody
    public List li() throws ClassNotFoundException, SQLException {
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
        return aa;
    }

    @RequestMapping("/list2")
    @ResponseBody
    public ArrayList list2() throws ClassNotFoundException, SQLException{
        ConnectionTest connectionTest = new ConnectionTest();
        PreparedStatement ps = connectionTest.Connection1().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<HashMap> ah = new ArrayList<>();
        while (rs.next()){
            HashMap hm = new HashMap();
            hm.put("id", rs.getInt("id"));
            hm.put("number", rs.getInt("number"));
            hm.put("name", rs.getString("name"));
            hm.put("gender", rs.getString("gender"));
            hm.put("age", rs.getInt("age"));
            ah.add(hm);
        }
        //System.out.println(ah.get(0).get("name"));
        return ah;
    }

    @RequestMapping("/list3")
    @ResponseBody
    public List list3() throws ClassNotFoundException, SQLException{
        ConnectionTest connectionTest = new ConnectionTest();
        PreparedStatement ps = connectionTest.Connection1().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<User> au = new ArrayList<>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setNumber(rs.getInt("number"));
            user.setName(rs.getString("name"));
            user.setGender(rs.getString("gender"));
            user.setAge(rs.getInt("age"));
            au.add(user);
        }
        return au;
    }

    @RequestMapping("/list4")
    @ResponseBody
    public User[] list4() throws ClassNotFoundException, SQLException{
        ConnectionTest connectionTest = new ConnectionTest();
//        PreparedStatement ps = conn.prepareStatement("");
//        ResultSet rs = ps.executeQuery("select * from users;");
        Statement st = connectionTest.Connection1().createStatement();
        ResultSet rs = st.executeQuery(sql);
        User[] users = new User[3];
        int i = 0;
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setNumber(rs.getInt("number"));
            user.setName(rs.getString("name"));
            user.setGender(rs.getString("gender"));
            user.setAge(rs.getInt("age"));
            users[i] = user;
            i ++;
        }
        return users;
    }

    @RequestMapping("/list5")
    public String list5(Model model){
        String t1 = "hello! world";
        String t2 = "你好！";
        model.addAttribute("h", t1);
        model.addAttribute("h2", t2);
        return "list";
    }

    @RequestMapping("/list")
    public String list(Model model) throws ClassNotFoundException, SQLException{
        ConnectionTest connectionTest = new ConnectionTest();
       // String sql = "select * from user";
        PreparedStatement ps = connectionTest.Connection1().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<User> au = new ArrayList<>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setNumber(rs.getInt("number"));
            user.setName(rs.getString("name"));
            user.setGender(rs.getString("gender"));
            user.setAge(rs.getInt("age"));
            au.add(user);
        }
        model.addAttribute("users", au);
        return "list";
    }

    @RequestMapping("/del")
    public String del(int id) throws ClassNotFoundException, SQLException {
        ConnectionTest connectionTest = new ConnectionTest();
        String sql = String.format("delete from user where id='%s'", id);
        PreparedStatement ps = connectionTest.Connection1().prepareStatement(sql);
        ps.execute();
        return "redirect:list";
    }

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/add_save")
    public String add_save(String name, String gender, int age) throws ClassNotFoundException, SQLException {
        ConnectionTest connectionTest = new ConnectionTest();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy");
        String da = sf.format(new Date());
        String numb = String.valueOf(new Random().nextInt(10000));
        if(numb.length()==1){
            numb = "000" + numb;
        }else if(numb.length()==2){
            numb = "00" + numb;
        }else if(numb.length()==3){
            numb = "0" + numb;
        }
        String number = da + numb;
        String sql = String.format("insert into user(number, name, gender, age) values('%s', '%s', '%s', '%s')", number, name, gender, age);
        PreparedStatement ps = connectionTest.Connection1().prepareStatement(sql);
        ps.execute();
        return "redirect:list";
    }

    @RequestMapping("/update")
    public String update(int id, Model model) throws ClassNotFoundException, SQLException {
        ConnectionTest connectionTest = new ConnectionTest();
        Statement st = connectionTest.Connection1().createStatement();
        String sql = String.format("select * from user where id='%s'", id);
        ResultSet rs = st.executeQuery(sql);
        ArrayList<HashMap> ah = new ArrayList<>();
        while (rs.next()){
            HashMap h = new HashMap();
            h.put("id", rs.getInt("id"));
            h.put("number", rs.getInt("number"));
            h.put("name", rs.getString("name"));
            h.put("gender", rs.getString("gender"));
            h.put("age", rs.getInt("age"));
            ah.add(h);
        }
        model.addAttribute("users", ah);
        return "update";
    }

    @RequestMapping("/update_save")
    public String update_save(int id,String name, String gender, int age) throws ClassNotFoundException, SQLException {
        ConnectionTest connectionTest = new ConnectionTest();

        String sql = String.format("update user set name='%s',gender='%s',age='%s' where id='%s'", name, gender, age, id);
        PreparedStatement ps = connectionTest.Connection1().prepareStatement(sql);
        ps.execute();
        return "redirect:list";
    }
    @RequestMapping("/print")
    public String print() throws SQLException, ClassNotFoundException, IOException {
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
        File file = new File("D:\\IDEA\\demo11\\src\\main\\resources\\static\\test12_01.xls");
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

        return "redirect:list";
    }
    @RequestMapping("/download")
    public static void downFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Resource resource = new ClassPathResource("static/test12_01.xls");
        File file = resource.getFile();
        String filename = resource.getFilename();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        OutputStream fos = null;
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            fos = response.getOutputStream();
            bos = new BufferedOutputStream(fos);
            setFileDownloadHeader(request,response, filename);
            int byteRead = 0;
            byte[] buffer = new byte[8192];
            while((byteRead=bis.read(buffer,0,8192))!=-1){
                bos.write(buffer,0,byteRead);
            }
            bos.flush();
            fis.close();
            bis.close();
            fos.close();
            bos.close();
        } catch (Exception e) {
        }
    }

    public static void setFileDownloadHeader(HttpServletRequest request,HttpServletResponse response, String fileName) {
        try {
            //中文文件名支持
            String encodedfileName = null;
            String agent = request.getHeader("USER-AGENT");

            if(null != agent && -1 != agent.indexOf("MSIE")){//IE
                encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
            }else if(null != agent && -1 != agent.indexOf("Mozilla")){
                encodedfileName = new String (fileName.getBytes("UTF-8"),"iso-8859-1");
            }else{
                encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
            }
            response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
   /* @RequestMapping("/download")
    public void downloadFile(HttpServletResponse response) throws IOException {
        try {
            Resource resource = new ClassPathResource("static/test12_01.xls");
            File file = resource.getFile();
            String filename = resource.getFilename();
            InputStream inputStream = new FileInputStream(file);
            //强制下载不打开
            response.setContentType("application/force-download");
            OutputStream out = response.getOutputStream();
            //使用URLEncoder来防止文件名乱码或者读取错误
            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename, "UTF-8"));
            int b = 0;
            byte[] buffer = new byte[1000000];
            while (b != -1) {
                b = inputStream.read(buffer);
                if(b!=-1) out.write(buffer, 0, b);
            }
            inputStream.close();
            out.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
}
