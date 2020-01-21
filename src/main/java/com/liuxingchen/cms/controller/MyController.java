package com.liuxingchen.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.liuxingchen.cms.domain.Article;
import com.liuxingchen.cms.domain.Category;
import com.liuxingchen.cms.domain.Channel;
import com.liuxingchen.cms.service.ArticleService;
import com.liuxingchen.cms.service.ChannelService;

/**
 * 
 * @ClassName: MyController
 * @Description: 个人中心
 * @author: HP
 * @date: 2020年1月10日 下午4:01:40
 */
@RequestMapping("my")
@Controller
public class MyController {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private ChannelService channelService;

	/**
	 * 
	 * @Title: index
	 * @Description: 进入个人中心
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"", "/", "index" })
	public String index() {
		return "my/index";
	}

	/**
	 * 
	 * @Title: articles
	 * @Description: 我的文章
	 * @return
	 * @return: String
	 */
	@RequestMapping("/article/articles")
	public String articles(Model model, Article article, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer pageSize) {
//		article.setUserId(userId);
		// 暂时先把所得的文章查询出来
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("article", article);
		return "my/article/articles";
	}

	/**
	 * 
	 * @Title: publish
	 * @Description: 去发布文章页面
	 * @return
	 * @return: String
	 */
	@GetMapping("article/publish")
	public String publish() {

		return "my/article/publish";

	}

	/**
	 * 
	 * @Title: publish
	 * @Description: 去发布文章页面
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@PostMapping("article/publish")
	public boolean publish(@RequestParam("file2") MultipartFile file, Article article) {

		if (!file.isEmpty()) {
			String upload = "d:/pic/"; // 文件路径
			// 获取文件名称
			String filename = file.getOriginalFilename();
			// 防止文件重名。改文件名称
			String newFilename = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
			File f = new File(upload, newFilename);
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
			} catch (IOException e) {
				e.printStackTrace();
			}
			article.setPicture(newFilename);// 封装上传的文件名称
		}

		// 封装文件的基本属性

		article.setUserId(177);
		article.setStatus(0);// 默认待审核
		article.setHits(0);
		;// 默认点击量为 0
		article.setDeleted(0);// 默认未删除
		article.setCreated(new Date());// 默认发布时间
		article.setUpdated(new Date());// 默认发布时间
		article.setContentType(0);// 发布的文章类型

		return articleService.insert(article);

	}

	// 查询单个文章
	@ResponseBody
	@RequestMapping("article/select")
	public Article select(Integer id) {
		return articleService.select(id);
	}

	/**
	 * 
	 * @Title: channels
	 * @Description: 返回所有分类
	 * @return
	 * @return: List<Channel>
	 */
	@ResponseBody
	@RequestMapping("channel/channels")
	public List<Channel> channels() {
		return channelService.selects();

	}

	/**
	 * 
	 * @Title: channels
	 * @Description: 返回所有分类
	 * @return
	 * @return: List<Channel>
	 */
	@ResponseBody
	@RequestMapping("channel/categorys")
	public List<Category> categorys(Integer channelId) {
		return channelService.selectsByCid(channelId);

	}
}