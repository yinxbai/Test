package com.ll.crm.controller;

import com.ll.crm.entity.SysUser;
import com.ll.crm.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author InRoota
 * @date 2021-06-30  10:09
 */
@Controller
public class LoginController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("toLogin")
    public ModelAndView toLogin(){

        return new ModelAndView("login");
    }

    @RequestMapping("login")
    public ModelAndView login( HttpServletRequest request){

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        request.getSession().setAttribute("role",role);
        if ("1".equals(role)){
            SysUser user = new SysUser();
            user.setAccount(account);
            user.setPassword(password);
            SysUser sysUser = sysUserService.login(user);
            if (null != sysUser){
                request.getSession().setAttribute("user",sysUser);
                return new ModelAndView("index","user",sysUser);
            }
        }
        request.getSession().setAttribute("message","用户名或者密码错误");
        return  new ModelAndView("login");
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping("changePassword")
    public String changePassword(HttpServletRequest request){
        String password = request.getParameter("password");
        String role = (String) request.getSession().getAttribute("role");
        if ("1".equals(role)){
             SysUser user = (SysUser) request.getSession().getAttribute("user");
             user.setPassword(password);
             sysUserService.changePassword(user);
        }
        return "redirect:toLogin";
    }
}
