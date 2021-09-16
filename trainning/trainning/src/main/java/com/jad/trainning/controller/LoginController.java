package com.jad.trainning.controller;

import com.jad.trainning.po.Student;
import com.jad.trainning.po.Teacher;
import com.jad.trainning.service.IStudentService;
import com.jad.trainning.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = {"/toLogin","/",""})
    public String welcome(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String flag = request.getParameter("flag");
        request.getSession().setAttribute("flag",flag);
        if("1".equals(flag)){
            Teacher teacher = new Teacher();
            teacher.setAccount(account);
            teacher.setPassword(password);
            Teacher _teacher =  teacherService.findTeacherByAccountAndPassword(teacher);
            if(null!=_teacher){
                request.getSession().setAttribute("user", _teacher);
                return "index";
            }

        }else{
            Student student = new Student();
            student.setAccount(account);
            student.setPassword(password);
            Student _student = studentService.findStudentByAccountAndPassword(student);
            if(null!=_student){
                System.out.println(_student+"---------------");
                request.getSession().setAttribute("user",_student);
                return "index";
            }
        }
        request.setAttribute("message","用户名或密码错误！");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping("/changePassword")
    public String changePassword(HttpServletRequest request,String newPassword){
        String flag = (String) request.getSession().getAttribute("flag");
        if("1".equals(flag)){
            Teacher teacher = (Teacher) request.getSession().getAttribute("user");
            teacher.setPassword(newPassword);
            teacherService.changePassword(teacher);
        }else{
            Student student = (Student) request.getSession().getAttribute("user");
            student.setPassword(newPassword);
            studentService.changePassword(student);
        }
        return "redirect:toLogin";
    }
}
