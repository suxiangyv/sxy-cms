package com.suxiangyu.cms.service;

import java.util.List;

import com.suxiangyu.cms.domain.Category;
import com.suxiangyu.cms.domain.Channel;

public interface ChannelService {

	List<Channel> getChannelList();

	List<Category> getCategoryList(Integer channelId);

}
