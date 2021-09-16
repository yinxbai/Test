package com.jad.controller;

import com.github.pagehelper.PageInfo;
import com.jad.po.City;
import com.jad.po.Customer;
import com.jad.po.SysUser;
import com.jad.service.ISysUserService;
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
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private ISysUserService sysUserService;

    @RequestMapping("/list/{pageNum}")
    public ModelAndView list(@PathVariable("pageNum") Integer pageNum){
        PageInfo pageInfo = sysUserService.findAll(pageNum,5);
        return new ModelAndView("sysUser/sysUser_list","pageInfo",pageInfo);
    }

    @RequestMapping("/save")
    public ModelAndView save(SysUser sysUser){
        String id = UUID.randomUUID().toString();
        sysUser.setId(id);
        System.out.println(sysUser);
        sysUserService.save(sysUser);
        return list(1);
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        sysUserService.delete(id);
        return list(1);
    }

    @RequestMapping("/batchDelete")
    public ModelAndView batchDelete(@RequestParam("check") String ids[],HttpServletRequest request){
        sysUserService.batchDelete(ids);
        return list(1);
    }

    @RequestMapping("/check")
    @ResponseBody
    public Boolean check(String account, HttpServletResponse response){
        SysUser sysUser = sysUserService.findSysUserByAccount(account);

        Boolean isExist = false;
        if(null!=sysUser){
            isExist = true;
        }
        System.out.println(isExist);
        return  isExist;
    }
}
