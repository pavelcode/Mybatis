package com.cblue.mapper;

import java.util.List;

import com.cblue.entity.User;
import com.cblue.entity.UserCustom;

public interface UserMapper {
	
	/**
	 * 输入映射
	 */
	//传入简单数据类型
	public User findUserById(int id);
	//传入对象数据类型
	public void insertUser(User user);
	//传入包装类型
	public List<User> findUserByPack(UserCustom userCustom);
	
	
	
	/**
	 * 输出映射
	 */
	//输出单个pojo类型
	//输出pojo集合类型
	//输出简单数据类型
	public int findUserCount();
	//投影
	public User findUserPart(int id);
	//使用别名
	public User findUserAlias(int id);
	//使用ResultMap
	public User findUserResultMap(int id);
	
	
	/**
	 * 动态sql
	 */
	//所有条件查询
	public List<User> findUserByCondition(UserCustom userCustom);
	//根据条件变化查询语句
	public List<User> findUserByCondition1(UserCustom userCustom);
	
	/**
	 * 语句片段
	 */
	public List<User> findUserByCondition2(UserCustom userCustom);
	
	/**
	 * foreach
	 */
	public List<User> findUserByCondition3(UserCustom userCustom);

	
	
	
}
