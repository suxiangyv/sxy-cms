package com.suxiangyu.cms.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suxiangyu.cms.domain.User;
import com.suxiangyu.cms.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class UserServiceImplTest {
	
	@Resource 
	private UserService userService;
	
	@Test
	public void lgoin() {
		User user = new User();
		user.setUsername("bbb");
		user.setPassword("321321");
		User u = userService.login(user);
		System.out.println(u);
	}
	
	
	
}
