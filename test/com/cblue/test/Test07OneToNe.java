package com.cblue.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cblue.entity.User;
import com.cblue.mapper.UserMapper;
import com.cblue.onetone.OrderCustom;
import com.cblue.onetone.OrderCustomMapper;
import com.cblue.onetone.OrderMapper;
import com.cblue.onetone.Orders;

public class Test07OneToNe {
	
	
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory()throws Exception{
		 // mybatis的配置文件
		  String resource = "SqlMapConfig.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//使用resultType实现一对一映射
	@Test
	public void testOrderCustomResultType(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到mybatis自动生成UserMapper的实现类代理对象
	    OrderCustomMapper orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
		//调用实现类的方法
	    List<OrderCustom> orderCustoms = orderCustomMapper.getOrderCustomByResultType();
		System.out.println(orderCustoms);
		
		sqlSession.close();
	}
	
	//使用resultMap实现一对一映射
	@Test
	public void testOrderUserResultMap(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到mybatis自动生成UserMapper的实现类代理对象
	    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		//调用实现类的方法
	    List<Orders> orders = orderMapper.getOrderUserByResultMap();
		System.out.println(orders);
		
		sqlSession.close();
	}

}
