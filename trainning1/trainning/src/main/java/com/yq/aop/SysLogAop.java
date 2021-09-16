package com.yq.aop;

import com.yq.aop.po.SysLog;
import com.yq.aop.service.ISysLogService;
import com.yq.po.Student;
import com.yq.po.Teacher;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author InRoota
 * @date 2021-06-15  19:44
 */
//@Component
//@Aspect
public class SysLogAop {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;
    private String account = null;

    @Before("execution(* com.yq.controller.LoginController.login(..))")
    void doBefore(JoinPoint joinPoint){

        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        this.account = request.getParameter("account");
    }

    @After("execution(* com.yq.service.*.*(..))")
    void doAfter(JoinPoint joinPoint){

        String id = UUID.randomUUID().toString().replace("_","");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sf.format(new Date());
        HttpSession session = request.getSession();
        Object obj =  session.getAttribute("user");
        if (obj instanceof Teacher) {
            Teacher teacher = (Teacher) obj;
            account = teacher.getAccount();
        }else {
            Student student = (Student) obj;
            account = student.getAccount();
        }
        String url = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String method = joinPoint.getClass()+joinPoint.getSignature().getName();
        SysLog sysLog = new SysLog(id,account,ip,url,method,createTime);
        sysLogService.save(sysLog);
    }
}
