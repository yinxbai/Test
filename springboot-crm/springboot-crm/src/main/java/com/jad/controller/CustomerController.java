package com.jad.controller;

import com.github.pagehelper.PageInfo;
import com.jad.po.City;
import com.jad.po.Customer;
import com.jad.service.ICityService;
import com.jad.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private ICustomerService customerService;
    @Resource
    private ICityService cityService;
    @RequestMapping("/list/{pageNum}")
    public ModelAndView list(@PathVariable("pageNum") Integer pageNum,HttpServletRequest request){
        String search = request.getParameter("search");
        PageInfo pageInfo = customerService.findAll(pageNum,5,search);
        return new ModelAndView("customer/customer_list","pageInfo",pageInfo);
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("customer/customer_edit","customer",customer);
    }

    @RequestMapping("/update")
    public ModelAndView update(Customer customer,@RequestParam("city.id") String cityId,HttpServletRequest request){
        City city = cityService.findCityById(cityId);
        customer.setCity(city);
        customerService.update(customer);
        return list(1,request);
    }

    @RequestMapping("/save")
    public ModelAndView save(Customer customer,@RequestParam("city.id") String cityId,HttpServletRequest request){
        String id = UUID.randomUUID().toString();
        City city = cityService.findCityById(cityId);
        customer.setCity(city);
        customer.setId(id);
        customerService.save(customer);
        return list(1,request);
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id,HttpServletRequest request){
        customerService.deleteById(id);
        return list(1,request);
    }

    @RequestMapping("/batchDelete")
    public ModelAndView batchDelete(@RequestParam("check") String ids[],HttpServletRequest request){
        customerService.batchDelete(ids);
        return list(1,request);
    }

    @RequestMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response){
        customerService.export(request,response);
    }

    @RequestMapping("/importExcel")
    public ModelAndView importExcel(HttpServletRequest request, HttpServletResponse response){
        customerService.importExcel(request,response);
        return list(1,request);
    }

    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response){
        customerService.download(request,response);
    }


}
