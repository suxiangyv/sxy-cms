package com.suxiangyu.cms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.suxiangyu.cms.domain.User;
import com.suxiangyu.cms.exception.CmsException;
import com.suxiangyu.cms.exception.MyCmsException;
import com.suxiangyu.cms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
  
	  @Autowired
	  private UserService userService;
	 
	 
	  @RequestMapping("/to/login.do")
	  public String toLogin() {
		  return "user/login";
	  }
	
	  @RequestMapping("/to/reg.do")
	  public String toReg() {
		  return "user/reg";
	  }
	  
	 
	  @RequestMapping("reg.do")
	  @ResponseBody
	  public MyCmsException<User>  reg(User u,MyCmsException<User> reCmsException) {
		  try {
			  userService.reg(u);
			  reCmsException.setCode("200");  //自定义的状态码
			  reCmsException.setMsg("注册成功！"); //自定义的信息
		} catch (CmsException e) {
			reCmsException.setCode("300");
			reCmsException.setMsg(e.getMessage());
		}catch(Exception e) {
			reCmsException.setCode("405");
			reCmsException.setMsg("系统出现错误，请联系管理员！");
		}
		  return  reCmsException;
	  }
	  
	  
	 
	  @RequestMapping("login.do")
	  @ResponseBody
	  public Boolean login(User u,HttpSession session) {
		  try {
			  User user = userService.login(u);
			  if(user !=null) {
				  session.setAttribute("loginu", user);  //用于拦截器，页面处理
				  return true;
			  }
			  return false;
		} catch (Exception e) {
			  return false;
		}
	  }
	  
	
	  @RequestMapping("/loginout.do")
	  public String loginout(HttpSession session) {
		  session.invalidate();
		  return "redirect:/index.do";
	  }

}
