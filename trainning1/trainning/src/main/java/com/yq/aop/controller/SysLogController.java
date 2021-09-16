package com.yq.aop.controller;

import com.github.pagehelper.PageInfo;
import com.yq.aop.service.ISysLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author InRoota
 * @date 2021-06-15  19:w
 */
//@Controller
//@RequestMapping("/log")
public class SysLogController {
    @Resource
    private ISysLogService sysLogService;

    @RequestMapping("/list/{pageNum}")
        public ModelAndView list(@PathVariable Integer pageNum) {
        PageInfo list = sysLogService.findAll(pageNum,8);
        return new ModelAndView("log/syslog_list","pageInfo",list);
    }
}
