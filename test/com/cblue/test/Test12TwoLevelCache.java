package com.cblue.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cblue.cache.UserMapper;
import com.cblue.entity.User;

/**
 * 测试二级缓存和ehcache
 * @author pavel
 *
 */
public class Test12TwoLevelCache {

	
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory()throws Exception{
		 // mybatis的配置文件
		  String resource = "SqlMapConfig.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testTwoLevelCache(){
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		//得到mybatis自动生成UserMapper的实现类代理对象
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		//第一次访问数据
		User user1 = userMapper1.findUserById(2);
		//这个sqlSession必须关闭，才会把数据放入到二级缓存中国
		sqlSession1.close();
		
		//保存数据
//		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
//		User u = new User();
//		u.setUsername("twolevel");
//		userMapper3.insertUser(u);
//		sqlSession3.commit();
//		sqlSession3.close();
		
		
		//第二次访问数据
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		User user2 = userMapper2.findUserById(2);
		
		sqlSession2.close();
		
		
	}
}
