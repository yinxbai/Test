package com.jad.trainning.aop.controller;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.aop.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/log")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/list/{pageNum}")
    public ModelAndView list(@PathVariable("pageNum") Integer pageNum){
        PageInfo pageInfo = sysLogService.findAll(pageNum, 10);
        return new ModelAndView("/log/sysLog_list","pageInfo",pageInfo);
    }
}
