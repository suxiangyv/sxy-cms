package com.suxiangyu.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiangyu.cms.domain.Category;
import com.suxiangyu.cms.domain.Channel;
import com.suxiangyu.cms.service.ChannelService;

@RequestMapping("/channel")
@Controller
public class ChannelController {
	
	@Autowired
	private ChannelService  service;
	
	@PostMapping("getChannelList.do")
	@ResponseBody
	public List<Channel> getChannelList(){
		return service.getChannelList();
	}
	
	@RequestMapping("getCategoryList.do")
	@ResponseBody
	public List<Category> getCategoryList(Integer channelId){
		return service.getCategoryList(channelId);
	}

}
