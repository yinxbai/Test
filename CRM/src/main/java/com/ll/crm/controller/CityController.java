package com.ll.crm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.ll.crm.entity.City;
import com.ll.crm.service.CityService;
import org.junit.Test;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

/**
 * (City)表控制层
 *
 * @author makejava
 * @since 2021-06-30 09:53:31
 */
@RestController
@RequestMapping("city")
public class CityController {
    /**
     * 服务对象
     */
    @Resource
    private CityService cityService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public City selectOne(String id) {
        return this.cityService.queryById(id);
    }

    @GetMapping("list/{pageNum}")
    public ModelAndView cityList(@PathVariable Integer pageNum){

        PageInfo pageInfo = cityService.queryAll(pageNum,6);
        return  new ModelAndView("City/city_list","pageInfo",pageInfo);
    }

    @RequestMapping("list")
    public ModelAndView list(){
        List<City> list = cityService.findAll();
        return  new ModelAndView("City/city_list","list",list);
    }

    @RequestMapping("delete")
    public ModelAndView deleteById(HttpServletRequest request){
        String id = request.getParameter("id");
        cityService.deleteById(id);
        System.out.println(id);
        return list();
    }
    @RequestMapping("deleteAll/{ids}")
    public ModelAndView deleteAll(@PathVariable String ids){
        cityService.deleteAll(ids);
        return list();
    }

    @PostMapping(value = "/save")
    public ModelAndView save(HttpServletRequest request){
        String id = UUID.randomUUID().toString().replace("_","");
        String name = request.getParameter("name");
        City city = new City(id,name);
        cityService.insert(city);
        return list();
    }

    @GetMapping(value = "getAll",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllCity(HttpServletResponse response) throws JsonProcessingException, UnsupportedEncodingException {
        List<City> list = cityService.findAll();
        response.addHeader("Content-Type", "application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        return json;
    }

}
