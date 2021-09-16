package com.yq.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author InRoota
 * @date 2021-06-21  17:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Exercise {

    private String id;
    private String doc;
    private Student studentId;
    private CourseResource courseResource;
    private String score;
    private String createTime;
}
