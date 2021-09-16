package com.jad.aop.controller;

import com.github.pagehelper.PageInfo;
import com.jad.aop.service.ILogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/log")
public class LogController {

    @Resource
    private ILogService logService;

    @RequestMapping("/list/{pageNum}")
    public ModelAndView list(@PathVariable Integer pageNum){
        PageInfo pageInfo = logService.findAll(pageNum,10);
        return new ModelAndView("log/log_list","pageInfo",pageInfo);
    }


}
