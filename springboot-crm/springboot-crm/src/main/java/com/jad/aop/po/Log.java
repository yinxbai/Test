package com.jad.aop.po;

import com.jad.po.SysUser;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Log {
	private String id;
	private String user;
	private String ip;
	private String url;
	private String description;
	private String creatTime;
}
