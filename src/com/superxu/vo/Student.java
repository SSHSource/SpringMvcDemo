package com.superxu.vo;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String school;
	/**
	 * age 如果是基本类型int 那么数据绑定的时候必须传值，只能是int类型。否则500
	 * 如果定义成包装类型Integer 可以不传key
	 * 对可能为空的数据，最好定义成包装类型
	 * 
	 */
	private Integer age;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [username=" + username + ", school=" + school
				+ ", age=" + age + "]";
	}
}
