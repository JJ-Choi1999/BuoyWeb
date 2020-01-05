package com.jnc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jnc.dao.FocusRepositoryQueryAnnotation;
import com.jnc.dao.FocusRepositoryCrudRepository;
import com.jnc.pojo.Focus;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BuoyMessageCenterApplication.class)
public class BuoyRegisterApplicationTests {
	
	@Autowired
	private FocusRepositoryQueryAnnotation focusRepositoryQueryAnnotation;
	
	@Autowired
	private FocusRepositoryCrudRepository focusRepositoryCrudRepository;
	
	@Test
	public void contextLoads() {
	}
	
	/**
	 * List<Focus> list=
			this.focusRepositoryQueryAnnotation.queryByNameUseSQL("test01");
		//System.out.println("size="+list.size());
	 */
	
	@Test
	public void testQurayFocusId() {
		List<Focus> list=
				this.focusRepositoryQueryAnnotation.queryByNameUseSQL("test04");
		System.out.println("test03_id="+list.get(0).getFocusId());
	}
	
	@Test
	public void testUpdataFocusJPA() {
		List<Focus> list=
				this.focusRepositoryQueryAnnotation.queryByNameUseSQL("test04");
		list.get(0).setGoFocusNum(3);
		
		this.focusRepositoryCrudRepository.save(list.get(0));
	}
	
}
