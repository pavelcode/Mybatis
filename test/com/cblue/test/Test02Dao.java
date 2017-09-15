package com.cblue.test;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cblue.dao.UserDao;
import com.cblue.dao.UserDaoImpl;
import com.cblue.entity.User;

/**
 * MyBatis的原始Dao开发方式
 * @author pavel
 *
 */
public class Test02Dao {
	
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory()throws Exception{
		 // mybatis的配置文件
		  String resource = "SqlMapConfig.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testSave(){
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
	    User user = new User();
	    user.setUsername("yyy");
	    user.setBirthday(new Date());
		userDao.saveUser(user);
		 //执行提交事务
	}
	
	@Test
	public void testQueryById(){
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.queryById(2);
		System.out.println(user);
	}

	
}
