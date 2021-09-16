package com.ll.crm.aop;

import com.ll.crm.entity.Log;
import com.ll.crm.entity.SysUser;
import com.ll.crm.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author InRoota
 * @date 2021-07-04  14:38
 */
@Aspect
@Component
public class SysLogAop {
    @Resource
    private HttpServletRequest request;
    @Resource
    private LogService logService;
    private String account;

    @Before("execution(* com.ll.crm.controller.LoginController.login(..))")
    public void doBefore(JoinPoint joinPoint){
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        this.account = request.getParameter("account");
    }

    @After("execution(* com.ll.crm.service.*.*(..))")
    public void doAfter(JoinPoint joinPoint){
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        if (null==obj){
            SysUser sysUser = (SysUser) obj;
            account =sysUser.getAccount();
        }
        String id = UUID.randomUUID().toString().replace("_","");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = simpleDateFormat.format(new Date());
        String userId = request.getSession().getId();
        String IP = request.getRemoteAddr();
        String description = joinPoint.getTarget().getClass()+"类"+joinPoint.getSignature().getName()+"方法";
        Log log = new Log(id,createTime,userId,IP,description);
        logService.insert(log);
    }
}
