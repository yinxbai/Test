package com.jad.trainning.po;

import lombok.Data;

@Data
public class CourseResource {
    private String id;
    private String title;
    private String pptUrl;
    private String pptFileName;
    private String videoUrl;
    private String videoFileName;
    private String exerciseUrl;
    private String exerciseFileName;
    private Teacher createror;
    private String createTime;
}
