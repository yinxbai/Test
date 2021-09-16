package com.jad.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jad.mapper.CustomerMapper;
import com.jad.po.Customer;
import com.jad.po.SysUser;
import com.jad.service.ICityService;
import com.jad.service.ICustomerService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private ICityService cityService;

    @Override
    public PageInfo findAll(Integer pageNum, Integer pageSize,String search) {

        PageHelper.startPage(pageNum,pageSize);
        List<Customer> list = customerMapper.findAll(search);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void save(Customer customer) {
        customerMapper.save(customer);
    }

    @Override
    public void deleteById(String id) {
        customerMapper.deleteById(id);
    }

    @Override
    public void batchDelete(String[] ids) {
        for (String s : ids) {
            customerMapper.deleteById(s);
        }
    }

    @Override
    public void update(Customer customer) {
        customerMapper.update(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerMapper.findById(id);
    }

    @Override
    public void export(HttpServletRequest request, HttpServletResponse response) {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("客户信息");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("序号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("出生日期");
        row.createCell(4).setCellValue("城市");
        row.createCell(5).setCellValue("来源");
        row.createCell(6).setCellValue("地址");
        row.createCell(7).setCellValue("邮箱");
        row.createCell(8).setCellValue("电话");
        row.createCell(9).setCellValue("描述");
        List<Customer> list = customerMapper.findAll("");
        ServletOutputStream os = null;
        for (int i = 0; i < list.size(); i++) {
            Customer customer = list.get(i);
            row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(i+1);
            row.createCell(1).setCellValue(customer.getName());
            row.createCell(2).setCellValue("1".equals(customer.getSex())?"男":"女");
            row.createCell(3).setCellValue(customer.getBirthday());
            if(null!= customer.getCity()) {
                row.createCell(4).setCellValue(cityService.findCityById(customer.getCity().getId()).getName());
            }else {
                row.createCell(4).setCellValue("");
            }
            row.createCell(5).setCellValue(customer.getSources());
            row.createCell(6).setCellValue(customer.getAddress());
            row.createCell(7).setCellValue(customer.getEmail());
            row.createCell(8).setCellValue(customer.getTelphone());
            row.createCell(9).setCellValue(customer.getDescription());
        }

        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            String filename = "导出"+sf.format(new Date())+".xls";
            filename = URLEncoder.encode(filename, "utf-8");
            response.setHeader("Content-disposition", "attachment;filename="+filename);
            os = response.getOutputStream();
            wb.write(os);

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                os.close();
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void importExcel(HttpServletRequest request, HttpServletResponse response) {
        InputStream is = null;
        Workbook wb = null;
        Sheet sheet = null;
        try {
            Part part = request.getPart("importFile");
            is = part.getInputStream();
            wb = new HSSFWorkbook(is);

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ServletException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i=1; i<=lastRowNum; i++) {
            Row row = sheet.getRow(i);
            Customer customer = new Customer();
            String id = UUID.randomUUID().toString();
            customer.setId(id);
            customer.setAddress(row.getCell(6).getStringCellValue());
            customer.setBirthday(row.getCell(3).getStringCellValue());
            if(null!= cityService.findCityByName(row.getCell(4).getStringCellValue())) {
                customer.setCity(cityService.findCityByName(row.getCell(4).getStringCellValue()));
            }else {
                customer.setCity(null);
            }
            customer.setSources(row.getCell(5).getStringCellValue());
            customer.setEmail(row.getCell(7).getStringCellValue());
            customer.setTelphone(row.getCell(8).getStringCellValue());
            customer.setDescription(row.getCell(9).getStringCellValue());
            customer.setName(row.getCell(1).getStringCellValue());
            customer.setSex("男".equals(row.getCell(2).getStringCellValue())?"1":"0");
            save(customer);

        }
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter outWriter = response.getWriter();
            outWriter.print("<script type='text/javascript'>");
            outWriter.print("alert('导入成功');");
            outWriter.print("</script>");

            /*
             * request.setAttribute("message", "close");
             * request.getRequestDispatcher("customer/customer_list.jsp").forward(request,
             * response);
             */
            is.close();
            wb.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void download(HttpServletRequest request, HttpServletResponse response) {
//        String filename = request.getParameter("filename");
        String filename = "模板2021-07-02.xls";
        ServletContext servletContext = request.getServletContext();
//        String realpath = servletContext.getRealPath("/WEB-INF/img/"+filename);
        try {
            FileInputStream is = new FileInputStream("G:/images/模板2021-07-02.xls");
            String type = servletContext.getMimeType(filename);
            response.setHeader("Content-Type", type);
            response.setHeader("Content-disposition", "attachment;filename="+filename);
            ServletOutputStream os = response.getOutputStream();
            byte[] buff = new byte[1024];
            int len = 0;
            while((len = is.read(buff)) != -1){
                os.write(buff,0,len);
            }

            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int findCount(String cityId) {
        return customerMapper.findCount(cityId);
    }


}
