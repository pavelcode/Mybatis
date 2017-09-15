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

import com.cblue.entity.Product;
import com.cblue.entity.ProductExample;
import com.cblue.mapper.ProductMapper;

/**
 * 测试逆向工程
 * @author pavel
 *
 */
public class Test14Porject {
	
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void initSqlSessionFactory()throws Exception{
		 // mybatis的配置文件
		  String resource = "SqlMapConfig.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//根据id查询
	@Test
	public void testFindById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到mybatis自动生成UserMapper的实现类代理对象
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		Product product = productMapper.selectByPrimaryKey(1);
		System.out.println(product);
		sqlSession.close();
	}
	
	//自定义查询
	@Test
	public void testFindByCondition(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到mybatis自动生成UserMapper的实现类代理对象
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria = productExample.createCriteria();
		
		//criteria.andNameEqualTo("3600");
		criteria.andPriceEqualTo(6000f);
		
		List<Product> product = productMapper.selectByExample(productExample);
		System.out.println(product);
		sqlSession.close();
	}
	
	//保存数据
	@Test
	public void testSave(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到mybatis自动生成UserMapper的实现类代理对象
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        
		Product product = new Product();
		product.setName("苹果笔记本");
		product.setPrice(8000f);
		product.setCreatetime(new Date());
		productMapper.insert(product);
		sqlSession.commit();
		sqlSession.close();
	}
	
	//更新数据
	@Test
	public void testUpdate(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到mybatis自动生成UserMapper的实现类代理对象
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        
		Product product = new Product();
		product.setId(4);
		product.setName("苹果笔记本111");
		//productMapper.updateByPrimaryKey(product);  //对所有字段进行更新，需要查询出来，再更新
		productMapper.updateByPrimaryKeySelective(product); //直接对所需的字段进行更新
		sqlSession.commit();
		sqlSession.close();
	}
	
	//删除数据
	@Test
	public void testDelete(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到mybatis自动生成UserMapper的实现类代理对象
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
     
		productMapper.deleteByPrimaryKey(4);
		sqlSession.commit();
		sqlSession.close();
	}
	
	

}
