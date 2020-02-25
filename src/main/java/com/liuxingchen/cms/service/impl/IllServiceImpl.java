package com.liuxingchen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuxingchen.cms.dao.IllMapper;
import com.liuxingchen.cms.domain.City;
import com.liuxingchen.cms.domain.Ill;
import com.liuxingchen.cms.service.IllService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class IllServiceImpl implements IllService {

	@Resource
	private IllMapper illMapper;
	@Override
	public int insert(Ill ill) {
		
		return illMapper.insert(ill);
	}
	@Override
	public City selectByCityName(String cityname) {
		// TODO Auto-generated method stub
		return illMapper.selectByCityName(cityname);
	}
	@Override
	public Ill selectTotal() {
		// TODO Auto-generated method stub
		return illMapper.selectTotal();
	}
	@Override
	public PageInfo<Ill> selects(Integer page,Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Ill> list = illMapper.selects();
		
		return new PageInfo<Ill>(list);
	}
	@Override
	public List<Ill> selectsByPid(Integer pid) {
		// TODO Auto-generated method stub
		return illMapper.selectsByPid(pid);
	}

}
