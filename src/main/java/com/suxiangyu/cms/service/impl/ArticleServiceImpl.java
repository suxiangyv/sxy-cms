package com.suxiangyu.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suxiangyu.cms.dao.ArticleMapper;
import com.suxiangyu.cms.domain.Article;
import com.suxiangyu.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public boolean add(Article article) {
		return articleMapper.add(article);
	}

	@Override
	public PageInfo<Article> getMyArticleList(int pageNum, int uid) {
		PageHelper.startPage(pageNum, 3);
		List<Article> list =  articleMapper.getMyArticleList(uid);
		PageInfo<Article> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Article getArticleById(Integer articleId) {
		// TODO Auto-generated method stub
		return articleMapper.getArticleById(articleId);
	}

	@Override
	public PageInfo<Article> getArticleList(Article article, Integer pageNum) {
		PageHelper.startPage(pageNum, 2);
		List<Article> list = articleMapper.getArticleList(article);
		PageInfo<Article> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Boolean update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article);
	}

	@Override
	public PageInfo<Article> getByChannelIdAndCategoryId(Integer channelId, Integer categoryId, Integer pageNum) {
		 PageHelper.startPage(pageNum, 5);
		 List<Article> list  = articleMapper.getByChannelIdAndCategoryId(channelId,categoryId);
		return new PageInfo<>(list);
	}

	@Override
	public PageInfo<Article> getHotList(Integer pageNum) {
		 PageHelper.startPage(pageNum, 5);
		 List<Article> hotList = articleMapper.getHotList();
		return new PageInfo<Article>(hotList); 
	}

	@Override
	public List<Article> getLastArticles() {
		// TODO Auto-generated method stub
		return articleMapper.getLastArticles();
	}
}
