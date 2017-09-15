package com.cblue.dao;

import com.cblue.entity.User;

public interface UserDao {
	
	 //添加数据
	 public void saveUser(User user);
	 //根据ID查询
	 public User queryById(int id);

}
