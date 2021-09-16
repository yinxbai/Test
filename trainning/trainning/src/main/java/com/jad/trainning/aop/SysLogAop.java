package com.jad.trainning.aop;

import com.jad.trainning.aop.po.SysLog;
import com.jad.trainning.aop.service.ISysLogService;
import com.jad.trainning.po.Student;
import com.jad.trainning.po.Teacher;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
@Aspect
public class SysLogAop {
    @Resource
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;
    private String account = null;

    /**
     * @param jp 连接点
     *  切登陆方法，且为前置通知（即在登陆方法login执行前，先执行该通知）
     */
   @Before("execution(* com.jad.trainning.controller.LoginController.login(..))")
    public  void doBefore(JoinPoint jp){
       /*
        *获取login(HttpServletRequest request)登陆方法中的参数列表
        * 由于login方法只有一个参数，所以取下标为0，即可获得参数request对象
        * 通过getParameter（）获取表单提交过来的登陆账号，并存到成员变量account中
        */
       HttpServletRequest request =  (HttpServletRequest) jp.getArgs()[0];
       this.account = request.getParameter("account");
    }

    /**
     * @param jp
     * 如果是登陆操作，则session中还没有存储user对象，所以账号可从成员变量account中获取
     * 如果是非登陆操作，则之前肯定登陆过，此时session中已有user对象，account值可从user中获取
     */
    @AfterReturning("execution(* com.jad.trainning.service.*.*(..))")
    public void deAfter(JoinPoint jp){
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        if(null!=obj){
            if(obj instanceof Teacher){
                Teacher teacher = (Teacher) obj;
                account = teacher.getAccount();
            }else{
                Student student = (Student) obj;
                account = student.getAccount();
            }
        }
        String id = UUID.randomUUID().toString().replace("-","");
        String url = request.getRequestURI();
        String ip  = request.getRemoteAddr();
        String method = jp.getTarget().getClass()+"类"+jp.getSignature().getName()+"方法";

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sf.format(new Date());
        SysLog sysLog = new SysLog(id,account,ip,url,method,createTime);
        sysLogService.save(sysLog);
    }

}
