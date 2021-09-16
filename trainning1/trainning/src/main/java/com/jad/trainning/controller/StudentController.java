package com.jad.trainning.controller;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.po.Student;
import com.jad.trainning.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/queryExerciseCoruseResource/{studentId}/{pageNum}")
    public ModelAndView queryExerciseCoruseResource(@PathVariable("pageNum") Integer pageNum,@PathVariable("studentId") String studentId){
       // PageInfo pageInfo = studentService.findCourseResourceByStudent(pageNum, 10,studentId);
        PageInfo pageInfo = studentService.findExerciseCoruseResourceByStudent(pageNum,10,studentId);

        return new ModelAndView("exercise/exercise_list","pageInfo",pageInfo);
    }
    @RequestMapping("/queryVideoCoruseResource/{studentId}/{pageNum}")
    public ModelAndView queryVideoCoruseResource(@PathVariable("pageNum") Integer pageNum,@PathVariable("studentId") String studentId){
        PageInfo pageInfo = studentService.findCourseResourceByStudent(pageNum, 10,studentId);
        return new ModelAndView("student/video_list","pageInfo",pageInfo);
    }

    /**
     *
     * @param sys 是否从系统管理入口进来，如果不是，则在前端页面不显示相关操作
     * @param teacherId
     * @param pageNum
     * @return
     */
    @RequestMapping("/findStudentByTeacher/{sys}/{teacherId}/{pageNum}")
    public ModelAndView findStudentByTeacher(@PathVariable("sys")String sys, @PathVariable("teacherId") String teacherId, @PathVariable("pageNum") Integer pageNum, Model model){
        PageInfo pageInfo = studentService.findStudentByTeaacher(pageNum,10,teacherId);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("sys", sys);
        return new ModelAndView("student/student_list");
    }

    @RequestMapping("/list/{pageNum}")
    public ModelAndView list(@PathVariable("pageNum") Integer pageNum){
        PageInfo pageInfo = studentService.findAll(pageNum,10);
        return new ModelAndView("student/student_list","pageInfo",pageInfo);
    }
    @RequestMapping("/save")
    public ModelAndView save(Student student){
        String id = UUID.randomUUID().toString().replace("-","");
        student.setId(id);
        studentService.save(student);
        return list(1);
    }

    @RequestMapping("/saveOrUpdate")
    public ModelAndView saveOrUpdate(Student student){
        if(StringUtils.isEmpty(student.getId())){
            student.setId(UUID.randomUUID().toString().replace("-",""));
            studentService.save(student);
        }else {
            studentService.update(student);
        }
        return list(1);
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Student findById(String id){
        return studentService.findById(id);
    }

    @RequestMapping("/del")
    public ModelAndView delete(String id){
        studentService.delete(id);
        return list(1);
    }

    @RequestMapping("/deleteAll")
    public ModelAndView deleteAll(String ids){
        studentService.deleteAll(ids);
        return list(1);
    }
}
