package com.superxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.superxu.vo.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping(value="/admin",method=RequestMethod.GET,params="add")
	public String createStudent(){
		return "stu/add";
	}
	
	/**
	 * Binding 将请求中的字段按照名字匹配的原则填入模型对象
	 * name属性
	 * @ModelAttribute 可要可不要 标示
	 * @param stu
	 * @return
	 */
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String addStudent(@ModelAttribute Student stu){
		System.out.println(stu);
		return "stu/success";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String showUploadPage(){
		return "stu/file";
	}
	
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile multipartFile){
		System.out.println(multipartFile.getOriginalFilename());
		return "stu/success";
	}
}
