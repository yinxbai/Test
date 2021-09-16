package com.ll.crm.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.ll.crm.entity.City;
import com.ll.crm.entity.Customer;
import com.ll.crm.service.CityService;
import com.ll.crm.service.CustomerService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (Customer)表控制层
 *
 * @author makejava
 * @since 2021-06-30 09:53:31
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerService customerService;
    @Resource
    private CityService cityService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Customer selectOne(String id) {
        return this.customerService.queryById(id);
    }

    @RequestMapping("/list/{pageNum}")
    public ModelAndView list(@PathVariable int pageNum){

        PageInfo pageInfo = customerService.findAll(pageNum,5);

        return new ModelAndView("customer/customer_list","pageInfo",pageInfo);
    }

    @RequestMapping("/queryName")
    public ModelAndView queryName(HttpServletRequest request, Model model) {
        List<Customer> customerList =customerService.list();
        String keywords = request.getParameter("keywords");
        List<Customer> result = new ArrayList<Customer>();
        if (keywords == null) {
            result = customerList;
        } else {
            for (Customer c : customerList) {
                if (c.getName().toLowerCase().contains(keywords.toLowerCase())) {
                    result.add(c);
                }
            }
        }
        model.addAttribute("empList", result);

        return findAll();
    }

    @RequestMapping("query")
    public ModelAndView findAll(){

        List<Customer> list = customerService.list();
        return new ModelAndView("customer/customer_list","list",list);
    }

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request){
        String id = UUID.randomUUID().toString();
        return new ModelAndView("customer/customer_add","id",id);
    }

    @RequestMapping("save")
    public ModelAndView save(Customer customer,@PathVariable("CityId")String cityId){
        String id = UUID.randomUUID().toString().replace("_","");
        customer.setId(id);
        City city = cityService.queryById(cityId);
        customer.setCityId(city);
        customerService.insert(customer);
        System.out.println(customer);
        return list(1) ;
    }

    @RequestMapping("delete")
    public ModelAndView deleteById(HttpServletRequest request){
        String id = request.getParameter("id");
        cityService.deleteById(id);
        System.out.println(id);
        return list(1);
    }

    @RequestMapping("/deleteAll/{ids}")
    public ModelAndView deleteAll(@PathVariable("ids")String ids){
        customerService.deleteAll(ids);
        return list(1);
    }

    @RequestMapping("/import")
    public ModelAndView im(){
        return null;
    }
    @RequestMapping("/export")
    public ModelAndView export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Customer> list =customerService.list();
        Customer customer = new Customer();
//        String titles[] = {"ID","姓名","性别","生日","地址","电话","邮箱","城市","来源","描述"};
//
//        HSSFWorkbook sheets = new HSSFWorkbook();
//        HSSFSheet sheet = sheets.createSheet("客户信息表");
//        HSSFRow titleRow = sheet.createRow(0);
//        for (int i=0;i<titles.length;i++){
//            HSSFCell cell = titleRow.createCell(i);
//            cell.setCellValue(titles[i]);
//        }
//        HSSFRow row = sheet.createRow(1);
//        row.createCell(0).setCellValue(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-hh");
        String fileName = simpleDateFormat.format(new Date())+"客户名单";
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) + ".xls");
        ServletOutputStream outputStream =response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLS,true);
        Sheet sheet =new Sheet(1,0,Customer.class);

        sheet.setAutoWidth(Boolean.TRUE);
        sheet.setSheetName("用户名单");
        if (list.equals(customer.getSex()=="1")){
            customer.setSex("男");
        }else {
            customer.setSex("女");
        }
        writer.write(list,sheet);
        writer.finish();
        outputStream.flush();
        response.getOutputStream().close();
        outputStream.close();
        return list(1);
    }
}
