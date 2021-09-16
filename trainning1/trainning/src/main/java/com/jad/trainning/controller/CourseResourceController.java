package com.jad.trainning.controller;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.po.CourseResource;
import com.jad.trainning.po.Teacher;
import com.jad.trainning.service.ICourseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/courseResource")
public class CourseResourceController {
    @Autowired
    private ICourseResourceService courseResourceService;

    @RequestMapping("/list/{pageNum}/{teacherId}")
    public ModelAndView list(@PathVariable("pageNum") Integer pageNum, @PathVariable("teacherId") String teacherId){
        PageInfo pageInfo = courseResourceService.queryByPage(pageNum,5,teacherId);
        return new ModelAndView("courseResource/courseResource_list","pageInfo",pageInfo);
    }

    @RequestMapping("/add")
    public ModelAndView add(){
        String id = UUID.randomUUID().toString();
        return new ModelAndView("courseResource/courseResource_add","id",id);
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request,CourseResource courseResource, MultipartFile ppt, MultipartFile video, MultipartFile exercise){
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        if(null!=teacher){
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String uploadPath = "/upload/"+sf.format(new Date()).substring(0,7);
            courseResource.setCreateTime(sf.format(new Date()));
            courseResource.setCreateror(teacher);
            File parent = new File(request.getServletContext().getRealPath(uploadPath));
            System.out.println(request.getServletContext().getRealPath(uploadPath)+"===============");
            if(!parent.exists()){
                parent.mkdirs();
            }
            /*上传PPT*/
            if(null!=ppt && !ppt.isEmpty()){
               String pptOriginalFilename = ppt.getOriginalFilename();
               String uplodFilename = UUID.randomUUID().toString()+pptOriginalFilename.substring(pptOriginalFilename.lastIndexOf("."));
               courseResource.setPptFileName(pptOriginalFilename);
               courseResource.setPptUrl(uploadPath+"/"+uplodFilename);
               try {
                   ppt.transferTo(new File(parent, uplodFilename));
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
            /*上传视频*/

            if(null!=video && !video.isEmpty()){

                String videoOriginalFilename = video.getOriginalFilename();
                String uplodFilename = UUID.randomUUID().toString()+videoOriginalFilename.substring(videoOriginalFilename.lastIndexOf("."));
                courseResource.setVideoFileName(videoOriginalFilename);
                courseResource.setVideoUrl(uploadPath+"/"+uplodFilename);
                try {
                    video.transferTo(new File(parent,uplodFilename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            /*上传作业*/
            if(null!=exercise && !exercise.isEmpty()){
                String exerciseOriginalFilename = exercise.getOriginalFilename();
                String uplodFilename = UUID.randomUUID().toString()+exerciseOriginalFilename.substring(exerciseOriginalFilename.lastIndexOf("."));
                courseResource.setExerciseFileName(exerciseOriginalFilename);
                courseResource.setExerciseUrl(uploadPath+"/"+uplodFilename);
                try {
                    exercise.transferTo(new File(parent,uplodFilename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            courseResourceService.save(courseResource);
            return list(1,teacher.getId());
        }
        return new ModelAndView("login");
    }

    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response, String url,String filename) throws UnsupportedEncodingException {
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(filename,"utf-8"));
        try {
            String uploadUrl = request.getServletContext().getRealPath(url);
            InputStream is = new FileInputStream(new File(uploadUrl));
            OutputStream os = response.getOutputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while((len=is.read(buf))!=-1){
                os.write(buf,0,len);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
