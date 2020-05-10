package com.suxiangyu.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.suxiangyu.cms.domain.Article;

public interface ArticleService {

	boolean add(Article article);
	
	PageInfo<Article> getMyArticleList(int pageNum, int uid);

	Article getArticleById(Integer articleId);
	
	PageInfo<Article> getArticleList(Article article, Integer pageNum);

	Boolean update(Article article);
	
	PageInfo<Article> getByChannelIdAndCategoryId(Integer channelId, Integer categoryId, Integer pageNum);

	PageInfo<Article> getHotList(Integer pageNum);

	List<Article> getLastArticles();
}
