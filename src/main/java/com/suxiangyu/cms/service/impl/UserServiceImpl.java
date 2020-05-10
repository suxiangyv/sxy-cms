package com.suxiangyu.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.suxiangyu.cms.dao.UserMapper;
import com.suxiangyu.cms.domain.User;
import com.suxiangyu.cms.exception.CmsException;
import com.suxiangyu.cms.service.UserService;
import com.suxiangyu.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service 
public class UserServiceImpl implements UserService {
	
	//密码在加上改字段
	 private final static String salt="sxy";

	 @Autowired  
	 private UserMapper userMapper;
	
	

	@Override
	public User login(User u) {
		//MD5加密
		String newPwd = DigestUtils.md5DigestAsHex((u.getPassword()+salt).getBytes());
		u.setPassword(newPwd);
		return userMapper.login(u);
	}


	@Override
	public PageInfo<User> getUserList(User user, Integer pageNum) {
		PageHelper.startPage(pageNum, 3);
		List<User> userList = userMapper.getUserList(user);
		PageInfo<User> info = new PageInfo<>(userList);
		return info;
	}
	
	@Override
	public Boolean updateLocked(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateLocked(user);
	}


	@Override
	public Boolean reg(User u) {
		//判断用户名是否为空
		 if(!StringUtil.hasText(u.getUsername())) {
			 throw new CmsException("用户名不能为空");
		 }
		 //判断用户名的长度
		 if(!(u.getUsername().length()>=3 && u.getUsername().length()<=6)) {
			 throw new CmsException("用户名长度3-6位");
		 }
		 //判断用户名是否存在
		 if(getCountByUsername(u.getUsername())>0) {
			 throw new CmsException("用户名称已经存在");
		 }
		//判断密码是否为空
		 if(!StringUtil.hasText(u.getPassword())) {
			 throw new CmsException("密码不能为空");
		 }
		 //判断用户名的长度
		 if(!(u.getPassword().length()>=3 && u.getPassword().length()<=6)) {
			 throw new CmsException("密码长度3-6位");
		 }
		 
		//MD5加密
		String newPwd = DigestUtils.md5DigestAsHex((u.getPassword()+salt).getBytes());
		u.setPassword(newPwd);
		
		return userMapper.reg(u);
	}
	
	
	
	/**
	 * 通过用户的名称查询数量
	 */
	@Override
	public int getCountByUsername(String username) {
		return userMapper.getCountByUsername(username);
	}

}
