package com.suxiangyu.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiangyu.cms.domain.Article;

public interface ArticleMapper {

	boolean add(Article article);
	
	List<Article> getMyArticleList(int uid);

	Article getArticleById(Integer articleId);
	
	List<Article> getArticleList(Article article);

	Boolean update(Article article);
	
	List<Article> getByChannelIdAndCategoryId(@Param("channelId")Integer channelId, @Param("categoryId")Integer categoryId);
	
	List<Article> getHotList();

	List<Article> getLastArticles();
}
