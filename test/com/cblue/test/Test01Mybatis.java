package com.cblue.test;

import java.io.IOException;
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


/**
 * 使用Mybatis实现CRUD
 * @author pavel
 *
 */

public class Test01Mybatis {
	
	SqlSession sqlSession;
	InputStream inputStream;
	
	@Before
    public void getSqlSession(){
		try {
			 // mybatis的配置文件
			  String resource = "SqlMapConfig.xml";
			  inputStream = Resources.getResourceAsStream(resource);
	          // 传入mybatis的配置文件信息，创建Session工厂
			  SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	          // 通过Session工厂得到SqlSession
	          sqlSession = sqlSessionFactory.openSession();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
	
	// 根据Id查询用户信息，得到一条记录结果
    @Test
    public void findUserByIdTest() {
        try {
            // 通过sqlSession操作数据库
            // 第一个参数：映射文件中的statement,等于namespace + "." + sql的id;
            // 第二个参数:指定和映射文件中所匹配的parameterType类型的参数;
            // sqlSession.selectOne结果是与映射文件所匹配的resultType类型的对象;
            // selectOne：查询一条结果
            User user = sqlSession.selectOne("test.findUserById",1);
            System.out.println(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 根据姓名模糊查询用户信息，得到一条或多条记录结果
    @Test
    public void findUserByNameTest() {
        try {
            // list中的user和resultType类型一致
            List<User> list = sqlSession.selectList("test.findUserByName", "红");
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 添加用户
    @Test
    public void insertUserTest() {
        try {
            //插入用户的对象
            User user = new User();
            user.setUsername("小红");
            user.setBirthday(new Date());
            sqlSession.insert("test.insertUser", user);
            //执行提交事务
            sqlSession.commit();
            //项目中经常需要 获取新增的用户的主键
            System.out.println(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // 根据Id删除用户
        @Test
        public void deleteUserTest() { 
            try {
                //传入Id，删除用户
                sqlSession.delete("test.deleteUser", 1);
                //执行提交事务
                sqlSession.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        // 根据Id更新用户信息
        @Test
        public void updateUserTest() {
            try {
                //更新用户的信息
                User user = new User();
                user.setId(2);
                user.setUsername("小黑");
                user.setBirthday(new Date());
                //更具Id更新用户
                sqlSession.update("test.updateUser", user);
                //执行提交事务
                sqlSession.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
