package com.cblue.cache;

import java.util.List;

import com.cblue.entity.User;
import com.cblue.entity.UserCustom;

public interface UserMapper {
	
	
	public User findUserById(int id);
	
	public void insertUser(User user);
	
	
	
}
