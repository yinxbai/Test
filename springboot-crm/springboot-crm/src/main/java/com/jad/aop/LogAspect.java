package com.jad.aop;

import com.jad.aop.mapper.LogMapper;
import com.jad.aop.po.Log;
import com.jad.aop.service.ILogService;
import com.jad.po.SysUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
@Aspect
public class LogAspect {

    @Resource
    private HttpServletRequest request;
    @Resource
    private ILogService logService;
    private String account = null;

    @Before("execution(* com.jad.controller.LoginController.check(..))")
    public void doBefore(JoinPoint jp){
        HttpServletRequest request = (HttpServletRequest) jp.getArgs()[0];
        this.account = request.getParameter("account");
    }

    @AfterReturning("execution(* com.jad.service.impl.*.*(..))")
    public void save(JoinPoint jp){
        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        if(null!=sysUser){
            account=sysUser.getAccount();
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String id = UUID.randomUUID().toString().replace("-","");
        String createTime = sf.format(new Date());
        String url = request.getRequestURI().toString();
        String ip = request.getRemoteAddr();
        String method = jp.getSignature().getName();
        logService.save(new Log(id,account,ip,url,method,createTime));


    }
}
