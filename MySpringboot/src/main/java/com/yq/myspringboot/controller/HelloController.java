package com.yq.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author InRoota
 * @date 2021-06-17  21:25
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){

        return "index";
    }
}
