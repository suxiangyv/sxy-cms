package com.suxiangyu.cms.service;

import com.suxiangyu.cms.domain.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
	
	
	User login(User u);

	PageInfo<User> getUserList(User user, Integer pageNum);

	Boolean updateLocked(User user);

	Boolean reg(User u);
	
	int getCountByUsername(String username);

}
