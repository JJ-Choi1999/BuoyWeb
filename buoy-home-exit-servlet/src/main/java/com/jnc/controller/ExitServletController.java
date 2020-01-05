package com.jnc.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jnc.dao.UsersRepositoryCrudRepository;
import com.jnc.dao.UsersRepositoryQueryAnnotation;
import com.jnc.pojo.Users;





/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class ExitServletController {

	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	//Users的JPA增删查改模型
	@Autowired
	private UsersRepositoryCrudRepository usersRepositoryCrudRepository;
	
	@RequestMapping("/ExitServlet")
	public void myController(MultipartFile filename,HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		// 用户名
		String usersname = request.getParameter("usersname");
		
		List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseSQL(usersname);
		
		list.get(0).setExit(true);
		list.get(0).setExitDate(new Date().getTime()+"");
		list.get(0).setInto(false);
		list.get(0).setMacAddress("Entry");
		
		this.usersRepositoryCrudRepository.save(list.get(0));
		
		response.sendRedirect("http://192.168.134.213:8111/login");
		
		
	}

}
