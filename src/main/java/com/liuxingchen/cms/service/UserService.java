package com.liuxingchen.cms.service;

import com.github.pagehelper.PageInfo;
import com.liuxingchen.cms.domain.User;

public interface UserService {
	
	PageInfo<User> selects(User user,Integer page,Integer pageSize);

}
