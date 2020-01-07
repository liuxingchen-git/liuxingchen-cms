package com.liuxingchen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuxingchen.cms.dao.UserMapper;
import com.liuxingchen.cms.domain.User;
import com.liuxingchen.cms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper mapper;

	@Override
	public PageInfo<User> selects(User user, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<User> list = mapper.selects(user);
		PageInfo<User> info = new PageInfo<User>(list);
		return info;
	}
	
}
