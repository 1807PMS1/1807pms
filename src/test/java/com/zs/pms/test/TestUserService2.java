package com.zs.pms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.service.UserService2;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService2 {
	@Autowired
	UserService2 us2;
	@Test
	public void testQuery(){
		QueryUser qu = new QueryUser();
		qu.setSex("男");
		System.out.println(us2.queryByCon(qu).size());
	}
}
