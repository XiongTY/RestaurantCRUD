package com.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 1.测试springmvc的开发环境 */
@Controller
public class TestSpringMVC {
	//测试springmvc的开发环境
	@RequestMapping("/testSpringmvc")
	public String testSpringmvc() {
		System.out.println("testSpringmvc()...");
		return "test";
	}
	
}








