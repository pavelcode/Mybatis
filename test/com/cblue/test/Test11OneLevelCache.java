package com.cblue.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cblue.entity.User;
import com.cblue.mapper.UserMapper;

/**
 * 测试一级缓存
 * @author pavel
 *
 */
public class Test11OneLevelCache {
	
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory()throws Exception{
		 // mybatis的配置文件
		  String resource = "SqlMapConfig.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testOneLevelCache(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到mybatis自动生成UserMapper的实现类代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//第一次访问数据
		User user1 = userMapper.findUserById(2);
		
		//保存了数据
		User u = new User();
		u.setUsername("test");
		userMapper.insertUser(u);
		sqlSession.commit();
		
		//第二次访问数据
		User user2 = userMapper.findUserById(2);
		
		sqlSession.close();
	}

}
