package com.ll.crm.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2021-06-30 09:47:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = 682578265486817685L;

    private String id;

    @ExcelProperty(value = "姓名",index = 0)
    private String name;

    @ExcelProperty(value = "性别",index = 1 )
    private String sex;

    @ExcelProperty(value = "生日",index = 2)
    private String birthday;

    @ExcelProperty(value = "地址",index = 3)
    private String address;

    @ExcelProperty(value = "电话",index = 4)
    private String telephone;

    @ExcelProperty(value = "邮箱",index = 5)
    private String email;

    public City cityId;

    @ExcelProperty(value = "来源",index = 6)
    private String sources;

    @ExcelProperty(value = "描述",index = 7)
    private String description;

}
