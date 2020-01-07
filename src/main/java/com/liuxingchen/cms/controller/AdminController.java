package com.liuxingchen.cms.controller;
/**
 * 
 * @ClassName: AdminController 
 * @Description: 管理员后台控制器
 * @author: HP
 * @date: 2020年1月7日 下午7:13:16
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdminController {
	/**
	 * 
	 * @Title: index 
	 * @Description: 后台首页
	 * @return
	 * @return: String
	 */
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}

}
