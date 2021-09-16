package com.jad.trainning.controller;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.po.Exercise;
import com.jad.trainning.po.Student;
import com.jad.trainning.service.IExerciseService;
import com.jad.trainning.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    private IExerciseService exerciseService;
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/list/{userId}/{pageNum}")
    public ModelAndView list(@PathVariable("pageNum") Integer pageNum, @PathVariable("userId") String userId){
        Student student = null;
        if(null!=userId){
            student = studentService.findById(userId);
        }
        PageInfo pageInfo = exerciseService.findByStudent(pageNum,10,student);
        return new ModelAndView("exercise/exercise_list","pageInfo",pageInfo);
    }

    @RequestMapping("/save")
    public ModelAndView save(Exercise exercise, MultipartFile upload, HttpServletRequest request) throws IOException {
        if(!upload.isEmpty()){
            String id = UUID.randomUUID().toString().replace("-","");
            String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String orginalFilename = upload.getOriginalFilename();
            String dir = "/upload/"+new SimpleDateFormat("yyyy-MM").format(new Date());
            File uploadPath = new File(request.getServletContext().getRealPath(dir));
            if(!uploadPath.exists()){
                uploadPath.mkdirs();
            }
            String uploadFilename = UUID.randomUUID().toString().replace("-","")+orginalFilename.substring(orginalFilename.lastIndexOf("."));
            upload.transferTo(new File(dir,uploadFilename));
            exercise.setFilename(orginalFilename);
            exercise.setFileUrl(uploadPath+"/"+uploadFilename);
            exercise.setId(id);
            exercise.setCreateTime(createTime);
            exerciseService.save(exercise);
        }
        return list(1,exercise.getStudentId());
    }
}
