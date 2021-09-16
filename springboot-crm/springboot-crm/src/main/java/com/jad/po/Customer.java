package com.jad.po;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
	private String id;
	private String name;
	private String sex;
	private String birthday;
	private String telphone;
	private String email;
	private String address;
	private City city;
	private String sources;
	private String description;

	
}
