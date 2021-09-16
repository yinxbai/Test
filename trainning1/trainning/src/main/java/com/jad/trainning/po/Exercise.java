package com.jad.trainning.po;

import lombok.Data;

@Data
public class Exercise {
    private String id;
    private String courseResourceId;
    private String filename;
    private String fileUrl;
    private Double score;
    private String studentId;
    private String createTime;
}
