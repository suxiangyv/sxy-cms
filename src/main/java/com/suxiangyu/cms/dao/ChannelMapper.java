package com.suxiangyu.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiangyu.cms.domain.Category;
import com.suxiangyu.cms.domain.Channel;

public interface ChannelMapper {

	List<Channel> getChannelList();

	List<Category> getCategoryList(@Param("channelId")Integer channelId);

}
