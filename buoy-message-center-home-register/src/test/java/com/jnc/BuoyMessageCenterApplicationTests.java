package com.jnc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jnc.dao.FocusRepositoryCrudRepository;
import com.jnc.dao.UsersRepositoryCrudRepository;
import com.jnc.pojo.Focus;
import com.jnc.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BuoyMessageCenterApplication.class)
public class BuoyMessageCenterApplicationTests {

	@Autowired
	private UsersRepositoryCrudRepository usersRepositoryCrudRepository;
	
	@Autowired
	private FocusRepositoryCrudRepository focusRepositoryCrudRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateUsers() {
		Users users = new Users();
		users.setUsersName("test01");
		users.setPassWord("pwd01");
		users.setInto(true);
		users.setIntoDate("123456");
		users.setExit(false);
		users.setExitDate("null");
		users.setMacAddress("AB-CD-E1-12-34-56");
		this.usersRepositoryCrudRepository.save(users);
	}
	
	@Test
	public void testCreateFocus() {
		
		Focus focus =new Focus();
		focus.setUsersName("test01");
		focus.setGoFocusNum(0);
		focus.setBuoyFocusNum(0);
		focus.setNewsFocusNum(0);
		focus.setAboutFocusNum(0);
		this.focusRepositoryCrudRepository.save(focus);
	}
	
	//List<Users> list=
	//this.usersRepositoryQueryAnnotation.queryByNameUseSQL("狗剩");
	
}
