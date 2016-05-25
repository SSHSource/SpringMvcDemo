package com.superxu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	/*org.springframework.web.servlet.mvc.Controller：页面控制器/处理器必须实现Controller接口；
	 ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) ：功能处理方法，实现相应的功能处理，
	 比如收集参数、验证参数、绑定参数到命令对象、将命令对象传入业务对象进行业务处理、最后返回ModelAndView对象；
	ModelAndView：包含了视图要实现的模型数据和逻辑视图名；“mv.addObject("message", "Hello World!");
	”表示添加模型数据，此处可以是任意POJO对象；“mv.setViewName("hello");”表示设置逻辑视图名为“hello”，
	视图解析器会将其解析为具体的视图，如前边的视图解析器InternalResourceVi。wResolver会将其解析为“WEB-INF/jsp/hello.jsp”。*/
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		// 1、收集参数、验证参数
		// 2、绑定参数到命令对象
		// 3、将命令对象传入业务对象进行业务处理
		// 4、选择下一个页面
		ModelAndView mv = new ModelAndView();
		// 添加模型数据 可以是任意的POJO对象
		mv.addObject("message", "i am a springmvc!");
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("hello");
		return mv;
	}

}
