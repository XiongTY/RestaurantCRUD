package com.tedu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

/** 测试mybatis的开发环境 */
public class TestMybatis {
	@Test
	public void testFindAll() throws IOException {
		//1.读取mybatis的配置文件
		InputStream in = Resources
			.getResourceAsStream(
			"mybatis/mybatis-config.xml");
		//2.获取SqlSession工厂对象
		SqlSessionFactory factory = 
			new SqlSessionFactoryBuilder()
			.build(in);
		//3.获取SqlSession对象
		SqlSession session = factory.openSession();
		//4.获取mapper接口的实例
		DoorMapper dao = session.getMapper( 
					DoorMapper.class );
		//5.执行查询所有门店的方法,返回所有门店
		List<Door> list = dao.findAll();
		//6.输出结果
		for(Door d:list) {
			System.out.println( d );
		}
	}
	
}





