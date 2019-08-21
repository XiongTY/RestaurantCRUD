package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
/** 门店管理模块 */
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;
@Controller
public class DoorController {
	@Autowired
	DoorMapper dao;
	
	/** 1.查询所有门店信息 */
	@RequestMapping("/doorList")
	public String doorList(Model model) {
		//1.获取所有门店信息组成的集合
		List<Door> list = dao.findAll();
		//2.将门店集合存入Model中
		model.addAttribute("list", list);
		//3.将门店集合转发带到JSP进行显示
		return "door_list";
	}
	
	/** 2.根据id删除门店信息 */
	@RequestMapping("doorDelete")
	public String doorDelete(Integer id) {
		//调用dao的方法根据id删除门店信息
		dao.deleteById( id );
		//删除后跳转到门店列表，显示最新门店列表
		return "forward:/doorList";
	}
	
	/** 3.新增门店信息 */
	@RequestMapping("/doorAdd")
	public String doorAdd(Door door) {
		//调用dao的方法, 新增门店信息
		dao.add( door );
		//新增后跳转到门店列表，显示最新门店列表
		return "forward:/doorList";
	}
	
	/** 4.根据id查询门店信息 */
	@RequestMapping("/doorInfo")
	public String doorInfo(
			Integer id, Model model) {
		//调用dao的方法,根据id查询门店信息
		Door door = dao.findById( id );
		//将门店信息存入Model中
		model.addAttribute("door", door);
		//将当前门店信息带到修改页面进行回显
		return "door_update";
	}
	
	/** 5.根据id修改门店信息 */
	@RequestMapping("/doorUpdate")
	public String doorUpdate(Door door) {
		//调用dao的方法, 根据id修改门店信息
		dao.updateById( door );
		//修改后跳转到门店列表，显示最新门店列表
		return "forward:/doorList";
	}
	
	/** 通用的页面跳转方法
	 *  /index、/_top、/hello
	  *  比如浏览器访问的路径为 /index, {}中的page
	  *  变量的值则为index, 通过@PathVariable可以
	  *  提取{page}变量的值, 赋值给方法上的page参数
	  *  在方法中再通过return返回!!  */
	@RequestMapping("/{page}")
	public String toPage(
		@PathVariable String page) {
		return page;
	}
	
}



