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

import com.cblue.dao.UserDao;
import com.cblue.dao.UserDaoImpl;
import com.cblue.entity.User;
import com.cblue.mapper.UserMapper;

/**
 * Mybatis接口代理方式
 * @author pavel
 *
 */

public class Test03Mapper {
	
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory()throws Exception{
		 // mybatis的配置文件
		  String resource = "SqlMapConfig.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testQueryById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到mybatis自动生成UserMapper的实现类代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用实现类的方法
		User user = userMapper.findUserById(2);
		System.out.println(user);
	}
	
	@Test
	public void testSave(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//mybatis自动生成UserMapper的实现类代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	    User user = new User();
	    user.setUsername("rrr");
	    user.setBirthday(new Date());
	    userMapper.insertUser(user);
	    sqlSession.commit();
	    sqlSession.close();
	}
	
	

}
