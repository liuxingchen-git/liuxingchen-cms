package com.liuxingchen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuxingchen.cms.dao.ChannelMapper;
import com.liuxingchen.cms.domain.Category;
import com.liuxingchen.cms.domain.Channel;
import com.liuxingchen.cms.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {
@Resource
private ChannelMapper channelMapper;
	@Override
	public List<Channel> selects() {
		
		return channelMapper.selects();
	}

	@Override
	public List<Category> selectsByCid(Integer channelId) {
		return channelMapper.selectsByCid(channelId);
	}

}
