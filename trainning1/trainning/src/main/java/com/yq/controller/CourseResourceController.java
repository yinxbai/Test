package com.yq.controller;

import com.github.pagehelper.PageInfo;
import com.yq.po.CourseResource;
import com.yq.po.Student;
import com.yq.po.Teacher;
import com.yq.service.ICourseResourceService;
import com.yq.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/courseResource")
public class CourseResourceController {

    @Autowired
    private ICourseResourceService courseResourceService;
    @Resource
    private ITeacherService teacherService;

    @RequestMapping("/list/{pageNum}/{teacherId}")
    public ModelAndView list(@PathVariable("pageNum") Integer pageNum, @PathVariable("teacherId") String teacherId) {
        PageInfo pageInfo = courseResourceService.queryByPage(pageNum, 5, teacherId);
        return new ModelAndView("courseResourceService/courseResourceService_list", "pageInfo", pageInfo);
    }

    @RequestMapping("/add")
    public ModelAndView add() {
        String id = UUID.randomUUID().toString();
        return new ModelAndView("courseResourceService/courseResource_add", "id", id);
    }

    @RequestMapping("/play")
    public ModelAndView play(HttpServletRequest request) {

        Student student = (Student) request.getSession().getAttribute("user");
        List<CourseResource> list = courseResourceService.findByStudent(student);

        return new ModelAndView("courseResourceService/courseResource_play", "list", list);
    }

    @RequestMapping("/video")
    public ModelAndView video(HttpServletRequest request) {

        String video = request.getParameter("path");
        return new ModelAndView("courseResourceService/courseResource_video", "video", video);
    }

    @RequestMapping("/save")
    public ModelAndView save(CourseResource courseResource, HttpServletRequest request, MultipartFile pptFile, MultipartFile videoFile, MultipartFile exerciseFile) {
        String uploadPath = request.getServletContext().getRealPath("/upload");
        File directory = new File(uploadPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        courseResource.setCreateTime(sf.format(new Date()));
        courseResource.setCreator(teacher);
        if (null != pptFile && !pptFile.isEmpty()) {
            String pptOriginalFilename = pptFile.getOriginalFilename();
            String filename = UUID.randomUUID().toString() + pptOriginalFilename.substring(pptOriginalFilename.lastIndexOf("."));
            courseResource.setPpt("/upload/" + filename);
            courseResource.setPptFileName(pptOriginalFilename);
            try {
                pptFile.transferTo(new File(directory, filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != videoFile && videoFile.isEmpty()) {
            String videoOriginalFilename = videoFile.getOriginalFilename();
            String filename = UUID.randomUUID().toString() + videoOriginalFilename.substring(videoOriginalFilename.lastIndexOf("."));
            courseResource.setVideo("/upload/" + filename);
            courseResource.setVideoFileName(videoOriginalFilename);
            try {
                videoFile.transferTo(new File(directory, filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != exerciseFile && exerciseFile.isEmpty()) {
            String exerciseOriginalFilename = exerciseFile.getOriginalFilename();
            String filename = UUID.randomUUID().toString() + exerciseOriginalFilename.substring(exerciseOriginalFilename.lastIndexOf("."));
            courseResource.setExercise("/upload/" + filename);
            courseResource.setExerciseFileName(exerciseOriginalFilename);
            try {
                exerciseFile.transferTo(new File(directory, filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        courseResourceService.save(courseResource);
        return list(1, teacher.getId());
    }

    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        String filename = request.getParameter("filename");
        // String path = request.getServletContext().getRealPath("/upload");
        String path = request.getParameter("path");
        path = request.getServletContext().getRealPath(path);
        try {
            //1、设置response 响应头
            //    response.reset(); //设置页面不缓存,清空buffer
            response.setCharacterEncoding("UTF-8"); //字符编码
            // response.setContentType("multipart/form-data"); //二进制传输数据
            //设置响应头URLEncoder.encode()
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);

            File file = new File(path);
            //2、 读取文件--输入流
            InputStream input = new FileInputStream(file);
            //3、 写出文件--输出流
            OutputStream out = response.getOutputStream();

            byte[] buff = new byte[1024];
            int len = 0;
            //4、执行 写出操作
            while ((len = input.read(buff)) != -1) {
                out.write(buff, 0, len);
                out.flush();
            }
            out.close();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request) {

        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        List<CourseResource> list = courseResourceService.findAllByStudent(teacher);

        return new ModelAndView("Exercise_edit", "list", list);
    }

    @RequestMapping("/write")
    public ModelAndView write(HttpServletRequest request) {
        String video = request.getParameter("path");
        return new ModelAndView("Exercise_write", "video", video);
    }

    @RequestMapping("/exercise")
    public ModelAndView exercise(HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("user");
        List<CourseResource> list = courseResourceService.findByStudent(student);

        return new ModelAndView("Exercise_exercise","list",list);
    }

    @RequestMapping("/success")
    public ModelAndView success(HttpServletRequest request){
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        List<CourseResource> list = courseResourceService.findAllByStudent(teacher);

        return new ModelAndView("Exercise_edit", "list", list);
    }
}
