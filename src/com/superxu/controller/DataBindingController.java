package com.superxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.superxu.vo.Admin;
import com.superxu.vo.User;
import com.superxu.vo.UserListForm;
import com.superxu.vo.UserMapForm;
/**
 * 数据绑定·
 * @author xuzj
 *
 */
@Controller
public class DataBindingController {

	@RequestMapping(value="baseType.do")
	@ResponseBody
	public String baseType(int age) {//基本类型
		return "age：" + age;
	}
	//http://127.0.0.1:8080/baseType2.do?age=21
	@RequestMapping(value="baseType2.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public String baseType2(Integer age) {//封装类型
		return "age：" + age;
	}
	
	@RequestMapping(value="stringType.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public String StringType(String name) {
		return "name：" + name;
	}
	
	//http://127.0.0.1:8080/array.do?name=mii&name=fs&name=电风扇
	@RequestMapping(value="array.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public String array(String[] name) {
		StringBuilder sbf= new StringBuilder();
		for(String item:name){
			sbf.append(item).append(" ");
		}
		return "names: "+sbf.toString();
	}
	
	//http://127.0.0.1:8080/object.do?name=di&age=12
	//http://127.0.0.1:8080/object.do?name=di&age=12&contactInfo.phone=10086
	@RequestMapping(value="object.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public String object(User user) {
		return "user: "+user;
	}
	
	/**
	 http://127.0.0.1:8080/doubleObject.do?name=di&age=12
	 	user: User [name=tom, age=12, contactInfo=null] admin: Admin [name=tom, age=12]
	 http://127.0.0.1:8080/doubleObject.do?user.name=tom&age=12&admin.name=lucy
	 	user: User [name=tom, age=12, contactInfo=null] admin: Admin [name=lucy, age=12]
	 */
	@RequestMapping(value="doubleObject.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public String doubleObject(User user,Admin admin) {
		return "user: "+user+"  admin: "+admin;
	}
	
	@InitBinder(value="user")//作用范围是当前的Controller 初始化
	public void initUser(WebDataBinder binder){
		binder.setFieldDefaultPrefix("user.");
	}
	@InitBinder(value="admin")
	public void initAdmin(WebDataBinder binder){
		binder.setFieldDefaultPrefix("admin.");
	}

	//http://127.0.0.1:8080/list.do?users[0].name=ton&users[1].name=lucu&users[1].age=123
	@RequestMapping(value="list.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public String list( UserListForm userListForm) {
		return "userListForm: "+userListForm;
	}
	
	//http://127.0.0.1:8080/map.do?users['x'].name=tom&users['x'].age=12&users['y'].name=lili&users['y'].age=13
	@RequestMapping(value="map.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public String map(UserMapForm userMapForm) {
		return "userMapForm: "+userMapForm;
	}
	
	
}
