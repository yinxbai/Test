package com.ll.crm.controller;

import com.ll.crm.entity.Log;
import com.ll.crm.entity.SysUser;
import com.ll.crm.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * (Log)表控制层
 *
 * @author makejava
 * @since 2021-06-30 09:53:32
 */
@Controller
@RequestMapping("log")
public class LogController {
    /**
     * 服务对象
     */
    @Resource
    private LogService logService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Log selectOne(String id) {
        return this.logService.queryById(id);
    }

    @RequestMapping("/list")
    public ModelAndView findAll(HttpServletRequest request){
        List<Log> list = logService.queryAll();
        ModelAndView modelAndView = new ModelAndView();
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        modelAndView.addObject("user",user);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("dateLog/log_list");
        return modelAndView;
    }
    @RequestMapping("/timeExport")
    public ModelAndView export() throws IOException {
        logService.exportExcel();
        List<Log> list = logService.queryAll();
        return new ModelAndView("dateLog/log_list","list",list);
    }

}
