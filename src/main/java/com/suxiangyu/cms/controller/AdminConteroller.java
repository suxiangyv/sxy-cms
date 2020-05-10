package com.suxiangyu.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiangyu.cms.domain.Article;
import com.suxiangyu.cms.domain.Category;
import com.suxiangyu.cms.domain.Channel;
import com.suxiangyu.cms.domain.User;
import com.suxiangyu.cms.service.ArticleService;
import com.suxiangyu.cms.service.ChannelService;
import com.suxiangyu.cms.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("admin")
public class AdminConteroller {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ChannelService channelService;
	

	@RequestMapping("index.do")
	public String index() {
		return "admin/index";
	}
	
	
	@RequestMapping("getArticleList.do")
	public String  getArticleList(Model model,Article article,@RequestParam(defaultValue="1")Integer pageNum) {
		PageInfo<Article> info = articleService.getArticleList(article,pageNum);
		model.addAttribute("info", info);
		model.addAttribute("article", article);
		return "admin/article";
	}
	
	
	@RequestMapping("/getArticleById.do")
	@ResponseBody
	public Article getArticleById(Integer articleId) {
		return articleService.getArticleById(articleId);
	}
	
	
	@RequestMapping("/update.do")
	@ResponseBody
	public Boolean  update(Article article) {
		return  articleService.update(article);
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(Model model,Integer cid) {
		List<Channel> channels = channelService.getChannelList();
		model.addAttribute("channels", channels);
		List<Category> categoryList = channelService.getCategoryList(cid);
		model.addAttribute("categorys", categoryList);
		model.addAttribute("cid", cid);
		return "index/index";
	}
	
	
	@RequestMapping("getUserList.do")
	public String getUserList(Model model,User user,@RequestParam(defaultValue="1")Integer pageNum) {
		PageInfo<User> info =   userService.getUserList(user,pageNum);
		model.addAttribute("info", info);
		model.addAttribute("user", user);
		return "admin/user";
	}
	

	@RequestMapping("/user/update.do")
	@ResponseBody
	public Boolean updateUser(User user) {
		return userService.updateLocked(user);
	}
}
