package com.yq.aop.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.PackageElement;
import java.io.Serializable;

/**
 * @author InRoota
 * @date 2021-06-15  18:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog implements Serializable {
    private String id;
    private String account;
    private String ip;
    private String url;
    private String createTime;
    private String method;
}
