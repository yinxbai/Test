package com.ll.crm.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Log)实体类
 *
 * @author makejava
 * @since 2021-06-30 09:47:37
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Log extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = -81007149649189398L;

    @ExcelProperty(value = "ID",index = 1)
    private String id;

    @ExcelProperty(value = "创建时间",index = 2)
    private String createTime;

    @ExcelProperty(value = "用户Id",index = 3)
    private String userId;

    @ExcelProperty(value = "IP",index = 4)
    private String ip;

    @ExcelProperty(value = "行为",index = 5)
    private String description;

}
