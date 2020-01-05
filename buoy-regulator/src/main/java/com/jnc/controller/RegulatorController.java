package com.jnc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.dao.UsersRepositoryQueryAnnotation;
import com.jnc.pojo.Users;
import com.jnc.utils.MacUtils;




/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class RegulatorController {
	
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	@RequestMapping("/Regulator")
	public void myController(HttpServletRequest request, 
			HttpServletResponse response,Model model) throws Exception {
		
		String str = new MacUtils().getMacList().toString();
		String macAddress = str.replace(",","-");
		
		System.out.println(macAddress);
		
		// 连接数据库获得所有物理地址
		List<Users> list=
				 this.usersRepositoryQueryAnnotation.queryByMacAddressUseSQL(macAddress);
		
		//System.out.println(list.size());
		
		// 判断该设备是否已经登陆
		// 未登陆
		if(list.size()==0) {
			
			response.sendRedirect("http://localhost:8121/index");
			
		}else { //已登陆
			

			response.sendRedirect("http://localhost:8131/index?usersname="+list.get(0).getUsersName());
			
		}
		
	}
	
	
	
}
