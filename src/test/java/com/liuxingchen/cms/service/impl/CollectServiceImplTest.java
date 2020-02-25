package com.liuxingchen.cms.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.liuxingchen.cms.domain.Collect;
import com.liuxingchen.cms.domain.User;
import com.liuxingchen.cms.service.CollectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class CollectServiceImplTest {

	@Resource
	CollectService collectService;
	
	/**
	 * 
	 * @Title: testInsert 
	 * @Description: 测试 添加
	 * @return: void
	 */
	@Test
	public void testInsert() {
		Collect collect = new Collect();
		collect.setText("test收集");
		User user = new User();
		user.setId(217);
		collect.setUser(user);
		
//		collect.setUrl("aaa");
		collect.setUrl("https://www.baidu.com");
		collect.setCreated(new Date());
		collectService.insert(collect);
		
		
	}
	
	/**
	 * 
	 * @Title: testSelect 
	 * @Description: 测试查询
	 * @return: void
	 */
	@Test
	public void testSelect() {
		collectService.selects(1, 1, 3);
	}
	
	/**
	 * 
	 * @Title: testDelete 
	 * @Description: 测试删除
	 * @return: void
	 */
	@Test
	public void testDelete() {
		collectService.delete(1);
	}

}
