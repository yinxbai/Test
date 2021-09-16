package com.jad.controller;

import com.jad.po.Customer;
import com.jad.po.SysUser;
import com.jad.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ISysUserService iSysUserService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        if(null==sysUser){
            return "login";
        }
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        return "login";
    }

    @RequestMapping("/check")
    public String check(HttpServletRequest request,SysUser sysUser, Model model){
        SysUser _sysUser = iSysUserService.findSysUserByAccountAndPassword(sysUser);
        if(null!=_sysUser){
            request.getSession().setAttribute("sysUser",_sysUser);
            return "index";
        }
        model.addAttribute("message","用户名或密码错误！");
        return "login";
    }

    @RequestMapping("/changePassword")
    public String changePassword(HttpServletRequest request){
        String password = request.getParameter("password");

        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        sysUser.setPassword(password);
        iSysUserService.changePassword(sysUser);
        return "redirect:login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }
}
