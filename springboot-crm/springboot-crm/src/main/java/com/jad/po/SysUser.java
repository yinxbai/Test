package com.jad.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SysUser {
	private String id;
	private String account;
	private String password;
	private String name;
	private String photo;
	private String role;
}
