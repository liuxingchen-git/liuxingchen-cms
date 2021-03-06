package com.liuxingchen.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuxingchen.cms.dao.LinksMapper;
import com.liuxingchen.cms.domain.Links;
import com.liuxingchen.cms.service.LinksService;
import com.liuxingchen.cms.util.CMSException;
import com.liuxingchen.util.StringUtil;

@Service
public class LinksServiceImpl implements LinksService {

	@Resource
	private LinksMapper linksMapper;

	@Override
	public boolean insert(Links links) {
		//调用工具类判断是否是有效url
		if(!StringUtil.isHttpUrl(links.getUrl())) {
			throw new CMSException("不是有效的地址值");
		}
		links.setCreated(new Date());
		linksMapper.insert(links);
		return true;
	}

	@Override
	public PageInfo<Links> selects(Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Links> list = linksMapper.selects();
		PageInfo<Links> info = new PageInfo<Links>(list);
		return info;
	}
	
}
