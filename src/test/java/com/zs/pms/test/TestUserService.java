package com.zs.pms.test;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.MD5;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService {
	@Autowired
	UserService us;

	public void testHello(){
		us.hello();
	}
	
	public void testlogin(){
		List< TPermission> list1 =us.queryByUid(3001);
		for (TPermission per: list1) {
			System.out.println(per.getPname());
		}
		System.out.println("------------整理后---------------");
		for (TPermission per1: us.getMenu(list1)) {
			//一级权限
			System.out.println(per1.getPname());
			for (TPermission per2 : per1.getChildren()) {
				System.out.println("----"+per2.getPname());
			}
		}
	}
	
	public void testQuery(){
		QueryUser qu = new QueryUser();
//		qu.setLoginname("test1");
//		qu.setPassword("123qwe");
		qu.setSex("男");
		for (TUser user: us.queryByPage(1, qu)) {
			System.out.println(user.getId()+"/ "+user.getLoginname());
		}
		System.out.println(us.queryPageCont(qu));
	}
	@Test
	public void testInsert(){
		TUser user =new TUser();
		TDep dep= new TDep();
		dep.setId(1);
		user.setDept(dep);
		user.setBirthday(new Date());
		user.setCreator(1007);
		user.setEmail("inst@123.com");
		user.setIsenabled(1);
		user.setLoginname("test4");
		MD5 md5 = new MD5();
		user.setPassword(md5.getMD5ofStr("123qwe"));
		user.setPic("in455");
		user.setRealname("新增");
		user.setSex("女");
	//	System.out.println(us.insertUser(user));
	}
	
	public void testDeletes(){
		int[] ids={1007,1008,1009};
		us.deleteByIds(ids);
	}

	public void testUpdate(){
		TUser user =new TUser();
		user.setId(1020);
//		TDep dep =new TDep();
//		dep.setId(3);
//		user.setDept(dep);
//		user.setEmail("update123@qq.com");
		user.setIsenabled(1);
//		user.setLoginname("update123");
//		user.setPassword("update12333");
//		user.setPic("update123.jpg");
//		user.setRealname("修改数据123");
//		user.setSex("男");
//		user.setUpdator(2000);
//		user.setBirthday(new Date());
		us.updateUser(user);
	}
	
	
	
}
