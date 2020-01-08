package com.liuxingchen.cms.dao;

import com.liuxingchen.cms.domain.Channel;

public interface ChannelMapper {
	/**
	 * 
	 * @Title: select 
	 * @Description: 根据id返回栏目对象
	 * @param id
	 * @return
	 * @return: Channel
	 */
	Channel select(Integer id);

}
