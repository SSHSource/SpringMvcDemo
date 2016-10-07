package com.superxu.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.superxu.service.StringService;

@Controller
@RequestMapping("/string") //类级别的@RequestMapping
public class StringController {
	
	private StringService stringService;

	@Autowired
	public void setStringService(StringService stringService) {
		this.stringService = stringService;
	}
	
	// /string/show?showId=1
	@RequestMapping(value="/show",method=RequestMethod.GET) //方法级别的RequestMapping
	//@RequestParam 参数
	public String showString(@RequestParam("showId") Integer showId, Model model){
		System.out.println("showId == "+showId);
		String showMessage = stringService.showMessage();
		model.addAttribute("showMessage",showMessage);
		return "show";
	}
	
	// /string/show2/{showId}
	@RequestMapping(value="/show2/{showId}",method=RequestMethod.GET) 
	public String showString2(@PathVariable("showId") Integer showId,Map<String,Object> model){
		System.out.println("showId == "+showId);
		String showMessage = stringService.showMessage();
		model.put("showMessage",showMessage);
		return "show";
	}
	// /string/show3?showId=1
	@RequestMapping("/show3")
	public String showString(HttpServletRequest request){
		Integer showId = Integer.valueOf(request.getParameter("showId"));
		System.out.println("showId == "+showId);
		String showMessage = stringService.showMessage();
		request.setAttribute("showMessage", showMessage);
		return "show";
	}
	
	
}
