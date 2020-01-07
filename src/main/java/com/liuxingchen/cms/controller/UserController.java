package com.liuxingchen.cms.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.liuxingchen.cms.domain.User;
import com.liuxingchen.cms.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService service;
	
	@RequestMapping("users")
	public String users(Model model,User user,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "5")Integer pageSize) {
		PageInfo<User> info = service.selects(user, page, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("user", user);
		return "admin/user/users";
	}

}
