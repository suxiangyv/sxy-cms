package com.suxiangyu.cms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.suxiangyu.cms.domain.Article;
import com.suxiangyu.cms.domain.Category;
import com.suxiangyu.cms.domain.Channel;
import com.suxiangyu.cms.domain.Slide;
import com.suxiangyu.cms.service.ArticleService;
import com.suxiangyu.cms.service.ChannelService;
import com.suxiangyu.cms.service.SlideService;
import com.github.pagehelper.PageInfo;

@Controller
public class IndexController {
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private SlideService slideService;
	
	@RequestMapping("/index.do")
	public String index(Model model,Integer channelId,Integer categoryId,@RequestParam(defaultValue="1")Integer pageNum) {
		//查询菜单 
		List<Channel>  list = channelService.getChannelList();
		model.addAttribute("channels", list);
		//通过菜单id查询分类
		List<Category> categorys = channelService.getCategoryList(channelId);
		model.addAttribute("categorys", categorys);
		
		//通过菜单id和分类id查询出所有文章
		     PageInfo<Article> info   =  new PageInfo<>();
		
			  if(channelId !=null) {
				  info =  articleService.getByChannelIdAndCategoryId(channelId,categoryId,pageNum);
			  }
		  
			if(channelId == null) {//查询广告列表 及热点文章	
				List<Slide>  slides = slideService.getList();
				model.addAttribute("slides", slides);
				//查询热点文章
				info=articleService.getHotList(pageNum);
			}	
			//查询最近的5篇文章用于右侧显示
			List<Article>  lasts = articleService.getLastArticles();
			model.addAttribute("lasts", lasts);
			
		model.addAttribute("info", info);
		model.addAttribute("channelId", channelId);
		model.addAttribute("categoryId", categoryId);
		return "index/index";
	}
	
	@RequestMapping("/detail.do")
	public String detail(Integer id,Model model) {
		Article article = articleService.getArticleById(id);
		model.addAttribute("article", article);
		return "index/article";
	}
}
