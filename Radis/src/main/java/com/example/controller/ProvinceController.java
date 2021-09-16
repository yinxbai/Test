package com.example.controller;

import com.example.pojo.Province;
import com.example.service.IProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author InRoota
 * @date 2021-06-24  14:06
 */
@Controller
public class ProvinceController {

    @Resource
    private IProvinceService provinceService;

//    @RequestMapping("/list")
//    public String list(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String json = provinceService.findJson();
//        System.out.println(json);
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write(json);
//        return "province";
//    }

    @RequestMapping(params = "getComboTreeData")
    @ResponseBody
    public List<Map<String,Object>> getComboTreeData(){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        List<Province> provinces = provinceService.findAll();
        for (int i=0; i<provinces.size(); i++){
            Map<String,Object> objectMap = new HashMap<String,Object>();
            objectMap.put("id",provinces.get(i).getId());
            objectMap.put("name",provinces.get(i).getName());
            result.add(objectMap);
        }
        return result;
    }

    @RequestMapping("/index")
    public String index(){

        return "province";
    }

    @GetMapping("/getAllProvince")
    @ResponseBody
    public String getAllProvince() throws JsonProcessingException {
        String all = provinceService.findJson();
        return all;
    }

    @RequestMapping("/save")
    @ResponseBody
    public void save(){
        Province province = new Province(UUID.randomUUID().toString(),"HEDGE");
        provinceService.save(province);
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getAllJson(){
        List list = provinceService.findAll();
        // System.out.println("list==="+list);
        Gson gson = new Gson();
        System.out.println(gson.toJson(list));
        return gson.toJson(list);
    }
}
