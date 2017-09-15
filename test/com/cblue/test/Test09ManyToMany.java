package com.cblue.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cblue.manytomany.OrderDetail;
import com.cblue.manytomany.Orders;
import com.cblue.manytomany.User;
import com.cblue.manytomany.UserMapper;


public class Test09ManyToMany {

	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory()throws Exception{
		 // mybatis的配置文件
		  String resource = "SqlMapConfig.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//使用resultMap实现多对多映射
	@Test
	public void testUserProductResultMap(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到mybatis自动生成UserMapper的实现类代理对象
	    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用实现类的方法
	    List<User> users = userMapper.findUserProductResultMap();
	    for(User user:users){
	    	System.out.println(user);
	    	for(Orders order:user.getOrderList()){
	    		System.out.println(order);
	    		for(OrderDetail orderDetail:order.getOrderDetails()){
	    			System.out.println(orderDetail);
	    			System.out.println(orderDetail.getProduct());
	    		}
	    	}
	    }

		sqlSession.close();
	}
}
