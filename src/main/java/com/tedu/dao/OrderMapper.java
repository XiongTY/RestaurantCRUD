package com.tedu.dao;

import java.util.List;
import com.tedu.pojo.Order;

public interface OrderMapper {
	/** 1.查询所有订单信息 */
	List<Order> findAll();
	/** 2.根据id删除订单信息 */
	void deleteById(Integer id);
	/** 4.新增订单信息 */
	void add(Order order);
	/** 5.根据id查询订单信息 */
	Order findById(Integer id);
	/** 6.根据id修改订单信息 */
	void updateById(Order order);
	
	
}







