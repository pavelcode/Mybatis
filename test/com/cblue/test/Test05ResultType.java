package com.cblue.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cblue.entity.User;
import com.cblue.mapper.UserMapper;

/**
 * 输出映射
 * @author pavel
 *
 */
public class Test05ResultType {
	
	
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory()throws Exception{
		 // mybatis的配置文件
		  String resource = "SqlMapConfig.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//输出简单数据类型
		@Test
		public void testFindUserCount(){
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//得到mybatis自动生成UserMapper的实现类代理对象
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用实现类的方法
			int count = userMapper.findUserCount();
			System.out.println(count);
		}
		
       //投影部分字段		
		@Test
		public void testFindUserPart(){
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//得到mybatis自动生成UserMapper的实现类代理对象
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用实现类的方法
			User user = userMapper.findUserPart(1);
			System.out.println(user);
		}
	
		//使用别名
		@Test
		public void testFindUserAlias(){
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//得到mybatis自动生成UserMapper的实现类代理对象
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用实现类的方法
			User user = userMapper.findUserAlias(1);
			System.out.println(user);
		}
		
		//使用别名
		@Test
		public void testFindUserResultMap(){
				SqlSession sqlSession = sqlSessionFactory.openSession();
				//得到mybatis自动生成UserMapper的实现类代理对象
				UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
				//调用实现类的方法
				User user = userMapper.findUserResultMap(1);
				System.out.println(user);
		}
	

}
