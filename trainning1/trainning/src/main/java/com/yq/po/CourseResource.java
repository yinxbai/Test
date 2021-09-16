package com.yq.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 54020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseResource {

    private String id;
    private String title;
    private String ppt;
    private String pptFileName;
    private String video;
    private String videoFileName;
    private String exercise;
    private String exerciseFileName;
    private String createTime;
    private Teacher creator;

}
