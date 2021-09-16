package com.example.controller;

import com.example.service.IProvinceService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-24  17:22
 */
@RestController
@RequestMapping("/pro")
public class TestController {

    @Resource
    private IProvinceService provinceService;

    @GetMapping("/getAll")
    public List getAll(){
        List list = provinceService.findAll();
        return list;
    }
}
