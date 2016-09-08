package com.superxu.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器，实现HandlerInterceptor接口，有三个方法
 * afterCompletion 请求结束，展示页面后处理
 * postHandle 请求执行后处理
 * preHandle 请求前处理
 * @author xuzj
 *
 */
public class MyInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion执行了 "+arg2);
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView mv) throws Exception {
		// TODO Auto-generated method stub
		mv.addObject("message", "i am a MyInterceptor!");
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("second");
		System.out.println("postHandle执行了 "+arg2);
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle执行了"+" v "+arg2);
//		arg0.setCharacterEncoding(arg0)
		return true;
	}

	

}
