package com.suxiangyu.cms.dao;

import java.util.List;

import com.suxiangyu.cms.domain.User;

public interface UserMapper {
	 
	int addUser(User u);
 
 	List<User> getUserList(User user);
 
 	User login(User u);

 	Boolean updateLocked(User user);
 
 	Boolean reg(User u);

 	int getCountByUsername(String username);

}
