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
import com.cblue.lazy.OrderMapper;
import com.cblue.lazy.Orders;



public class Test10Lazy {

	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory()throws Exception{
		 // mybatis的配置文件
		  String resource = "SqlMapConfig.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//使用resultMap实现延迟加载
		@Test
		public void testFindOrderUserLazy(){
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//得到mybatis自动生成UserMapper的实现类代理对象
		    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			//调用实现类的方法
		    List<Orders> orders = orderMapper.findOrderUserLazy();
		    for(Orders order:orders){
		    	User user = order.getUser();
		    	System.out.println(user);
		    }

			sqlSession.close();
		}
}
