package com.suxiangyu.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suxiangyu.cms.dao.SlideMapper;
import com.suxiangyu.cms.domain.Slide;
import com.suxiangyu.cms.service.SlideService;


@Service
public class SlideServiceImpl implements SlideService {
	
	@Autowired
	private SlideMapper slideMapper;

	@Override
	public List<Slide> getList() {
		return slideMapper.getList();
	}

}
