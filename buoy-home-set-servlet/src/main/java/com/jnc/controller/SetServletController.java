package com.jnc.controller;

import java.io.File;
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
public class SetServletController {

	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	//Users的JPA增删查改模型
	@Autowired
	private UsersRepositoryCrudRepository usersRepositoryCrudRepository;
	
	@RequestMapping("/SetServlet")
	public void myController(MultipartFile filename,HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		// 用户名
		String usersname = request.getParameter("usersname");
		
		// 用户名
		String nickname = request.getParameter("nickname");
		
		// 用户名
		String sex = request.getParameter("sex");
		
		// 用户名
		String email = request.getParameter("email");
		
		// 用户名
		String phone = request.getParameter("phone");
		
		if(filename.isEmpty()==false&&nickname.isEmpty()==false&&sex.isEmpty()==false&&email.isEmpty()==false&&phone.isEmpty()==false) {
			System.out.println("上传文件名称: "+filename.getOriginalFilename()+"\nusersname="+usersname+"\nnickname="+nickname+"\nsex="+sex+"\nemail="+email+"\nphone="+phone);
			//文件的保存
			filename.transferTo(new File("D:/BuoyWeb/buoy-home-set-servlet/src/main/resources/static/img/"+filename.getOriginalFilename()));
			
			List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseSQL(usersname);
		
			list.get(0).setImg(filename.getOriginalFilename());
			list.get(0).setNickname(nickname);
			list.get(0).setSex(sex);
			list.get(0).setEmail(email);
			list.get(0).setPhone(phone);
			this.usersRepositoryCrudRepository.save(list.get(0));
			
			response.sendRedirect("http://192.168.134.213:8201/set?usersname="+usersname);
			
		}else {
			System.out.println("上传文件名称为空");
			List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseSQL(usersname);
			//防止删除为空
			if(nickname.isEmpty()==false) {
				list.get(0).setNickname(nickname);
			}
			//防止删除为空
			if(sex.isEmpty()==false) {
				list.get(0).setSex(sex);
			}
			//防止删除为空
			if(email.isEmpty()==false) {
				list.get(0).setEmail(email);
			}
			//防止删除为空
			if(phone.isEmpty()==false) {
				list.get(0).setPhone(phone);
			}
			this.usersRepositoryCrudRepository.save(list.get(0));
			
			response.sendRedirect("http://192.168.134.213:8201/set?usersname="+usersname);
		}
		
	}

}
