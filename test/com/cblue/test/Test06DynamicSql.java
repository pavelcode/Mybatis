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
import com.cblue.entity.UserCustom;
import com.cblue.mapper.UserMapper;

/**
 * 动态sql语句
 * @author pavel
 *
 */

public class Test06DynamicSql {

	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory()throws Exception{
		 // mybatis的配置文件
		  String resource = "SqlMapConfig.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	

	    //所有条件查询
		@Test
		public void testFindUserByCondition(){
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//得到mybatis自动生成UserMapper的实现类代理对象
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			UserCustom userCustom = new UserCustom();
			User user = new User();
			user.setUsername("张");
			user.setSex("0");
			userCustom.setUser(user);
			//调用实现类的方法
			List<User> u = userMapper.findUserByCondition(userCustom);
			System.out.println(u);
		}
		
		//动态sql查询
		@Test
		public void testFindUserByCondition1(){
					SqlSession sqlSession = sqlSessionFactory.openSession();
					//得到mybatis自动生成UserMapper的实现类代理对象
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
					UserCustom userCustom = new UserCustom();
					User user = new User();
					//user.setUsername("张");
					user.setSex("0");
					userCustom.setUser(user);
					//调用实现类的方法
					List<User> u = userMapper.findUserByCondition1(userCustom);
					System.out.println(u);
		}
		
		//sql片段查询
		@Test
		public void testFindUserByCondition2(){
					SqlSession sqlSession = sqlSessionFactory.openSession();
					//得到mybatis自动生成UserMapper的实现类代理对象
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
					UserCustom userCustom = new UserCustom();
					User user = new User();
					user.setUsername("张");
					//user.setSex("0");
					userCustom.setUser(user);
					//调用实现类的方法
					List<User> u = userMapper.findUserByCondition2(userCustom);
					System.out.println(u);
		}
		
		
		//foreach
		@Test
		public void testFindUserByCondition3(){
					SqlSession sqlSession = sqlSessionFactory.openSession();
					//得到mybatis自动生成UserMapper的实现类代理对象
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
					UserCustom userCustom = new UserCustom();
					userCustom.setIds(new Integer[]{1,2,3});
					List<User> u = userMapper.findUserByCondition3(userCustom);
					System.out.println(u);
		}
		
		
		

}
