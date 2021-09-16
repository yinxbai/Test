package com.jad.controller;

import com.jad.po.City;
import com.jad.po.SysUser;
import com.jad.service.ICityService;
import com.jad.service.ICustomerService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/city")
public class CityController {
    @Resource
    private ICityService cityService;
    @Resource
    private ICustomerService customerService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<City> list = cityService.findAll();
        return new ModelAndView("city/city_list","list",list);
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<City> list(){
        List<City> list = cityService.findAll();
        return list;
    }

    @RequestMapping("/save")
    public ModelAndView save(City city){
        String id = UUID.randomUUID().toString();
        city.setId(id);
        cityService.save(city);
        return findAll();
    }

    @RequestMapping("/check")
    @ResponseBody
    public Boolean check(String name, HttpServletResponse response){
        City city = cityService.findCityByName(name);

        Boolean isExist = false;
        if(null!=city){
            isExist = true;
        }
        return  isExist;
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id, HttpServletResponse response){
        int customerNum = customerService.findCount(id);
        response.setCharacterEncoding("utf-8");
        if(customerNum>0){
            try {
                PrintWriter outWriter = response.getWriter();
                outWriter.print("<script type='text/javascript'>");
                outWriter.print("alert('存在不能删除的城市');");
                outWriter.print("</script>");
                return findAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            cityService.deleteById(id);
        }
        return findAll();
    }

    @RequestMapping("/edit")
    public ModelAndView edit(City city){
        cityService.update(city);
        return findAll();
    }

}
