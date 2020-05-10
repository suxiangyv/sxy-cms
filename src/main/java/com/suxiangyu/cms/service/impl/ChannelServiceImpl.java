package com.suxiangyu.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suxiangyu.cms.dao.ChannelMapper;
import com.suxiangyu.cms.domain.Category;
import com.suxiangyu.cms.domain.Channel;
import com.suxiangyu.cms.service.ChannelService;

@Service
public class ChannelServiceImpl implements  ChannelService {

	 @Autowired
	 private ChannelMapper mapper;

	@Override
	public List<Channel> getChannelList() {
		return mapper.getChannelList();
	}

	@Override
	public List<Category> getCategoryList(Integer channelId) {
		return mapper.getCategoryList(channelId);
	}
	
}
