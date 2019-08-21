package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.dao.OrderMapper;
import com.tedu.pojo.Door;
import com.tedu.pojo.Order;

@Controller
public class OrderController {
	@Autowired
	OrderMapper dao;
	@Autowired
	DoorMapper doorDao;
	
	/** 1.查询所有订单信息 */
	@RequestMapping("/orderList")
	public String orderList(Model model) {
		//0.查询所有门店集合
		List<Door> doorList = doorDao.findAll();
		//0.将门店集合存入Model中带到JSP显示
		model.addAttribute("dList", doorList);
		//1.调用dao的方法,查询所有订单信息
		List<Order> list = dao.findAll();
		//2.将所有订单的集合存入Model中
		model.addAttribute("oList", list);
		//3.通过转发将订单带到JSP,取出并显示
		return "order_list";
	}
	/** 2.根据id删除订单信息
	 */
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id) {
		//调用dao的方法,根据id删除订单信息
		dao.deleteById( id );
		//转向订单列表页面,查询最新订单列表
		return "forward:/orderList";
	}
	/** 3.查询所有门店, 将所有门店带到新增
	  *  订单页面 */
	@RequestMapping("/toAddOrder")
	public String toAddOrder(Model model) {
		//0.查询所有门店集合
		List<Door> doorList = doorDao.findAll();
		//0.将门店集合存入Model中带到JSP显示
		model.addAttribute("dList", doorList);
		//转向新增订单页面
		return "order_add";
	}
	/** 4.新增订单信息 */
	@RequestMapping("/orderAdd")
	public String orderAdd(Order order) {
		//调用dao的方法, 新增订单信息
		dao.add( order );
		//转向订单列表页面,查询最新订单列表
		return "forward:/orderList";
	}
	
	/** 5.根据id查询订单信息 */
	@RequestMapping("/orderInfo")
	public String orderInfo(
			Integer id, Model model) {
		//0.查询所有门店集合
		List<Door> doorList = doorDao.findAll();
		//0.将门店集合存入Model中带到JSP显示
		model.addAttribute("dList", doorList);
		
		//根据id查询订单信息
		Order order = dao.findById( id );
		//将订单信息存入Model中
		model.addAttribute("order", order);
		//将订单信息带到修改页面,进行数据回显
		return "order_update";
	}
	/** 6.根据id修改订单信息 */
	@RequestMapping("/orderUpdate")
	public String orderUpdate( Order order ) {
		//调用dao的方法,根据id修改订单信息
		dao.updateById( order );
		//转向订单列表页面,查询最新订单列表
		return "forward:/orderList";
	}
	
}










