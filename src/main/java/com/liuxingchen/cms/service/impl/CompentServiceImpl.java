package com.liuxingchen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuxingchen.cms.dao.CompentMapper;
import com.liuxingchen.cms.domain.Compent;
import com.liuxingchen.cms.service.CompentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CompentServiceImpl implements CompentService {
	
	@Resource
	private CompentMapper compentMapper;

	@Override
	public int insert(Compent compent) {
		return 	compentMapper.insert(compent);
	}

	@Override
	public PageInfo<Compent> selects(Integer articleId, Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		List<Compent> list = compentMapper.selects(articleId);	
		
		return new PageInfo<Compent>(list);
	}

	

	
	
}
