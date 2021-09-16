package com.jad.trainning.aop.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog implements Serializable {
    private String id;
    private String account;
    private String ip;
    private String url;
    private String method;
    private String createTime;
}
