package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

/** 1.测试SSM的开发环境 */
@Controller
public class TestSSM {
	/*@Autowired自动装配, 由框架底层为接口提供实现类
	  * 并创建实例, 将创建好的实例, 赋值给当前变量。  */
	@Autowired
	DoorMapper dao;
	
	//测试SSM的开发环境
	@RequestMapping("/testssm")
	public String testssm() {
		System.out.println("testssm()...");
		
		//查询所有门店信息
		List<Door> list = dao.findAll();
		for(Door d : list) {
			System.out.println( d );
		}
		
		return "test";
	}
}








