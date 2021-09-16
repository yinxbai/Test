package com.ll.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2021-06-30 09:47:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysUser implements Serializable {
    private static final long serialVersionUID = -39080959734093346L;

    private String id;

    private String account;

    private String password;

    private String name;

    private String photo;

    private String role;
}
