package com.suxiangyu.cms.controller;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import com.suxiangyu.cms.domain.Article;
import com.suxiangyu.cms.service.ArticleService;

@Controller
@RequestMapping("/my")
public class MyController {
	
	@Autowired
	private  ArticleService  articleService;
	
	@RequestMapping("/index.do")
	public String index() {
		return "my/index";
	}
	
	@RequestMapping("/article.do")
	public String article(Model model,@RequestParam(defaultValue="1")int pageNum) {
		
		int userId=4;
		PageInfo<Article> pageInfo = articleService.getMyArticleList(pageNum,userId);
		model.addAttribute("info", pageInfo);
		return "my/article";
	}
	
	@RequestMapping("/publish.do")
	public String publish() {
		return "my/publish";
	}
	
	@RequestMapping("/publish/article.do")
	@ResponseBody
	public boolean publishArticle(Article article,MultipartFile file) throws Exception {
		if(file !=null && !file.isEmpty()) {
			 String paht="C:\\img";  //图片存放位置  注意在判pom.xml中配置虚拟路径
			 String fileName = file.getOriginalFilename(); //获取上传图片的名称  
			 //abc.fa.png
			 String fianlName= UUID.randomUUID()+ fileName.substring(fileName.lastIndexOf(".")); //给图片重新命名
			  File file2 = new File(paht, fianlName);
			  file.transferTo(file2);
			  article.setPicture("/img/"+fianlName);
		}
		article.setCommentNum(0);
		article.setContentType(0);
		article.setCreated(new Date());
		article.setDeleted(0);
		article.setHits(0);
		article.setHot(1);
		article.setStatus(0);
		article.setSummary("摘要");
		article.setUpdated(new Date());
		//从session中获取登陆人的id
		article.setUserId(4);
		
		return articleService.add(article);
	}
	
	@RequestMapping("/getArticleById.do")
	@ResponseBody
	public Article getArticleById(Integer articleId) {
		return articleService.getArticleById(articleId);
	}
}
