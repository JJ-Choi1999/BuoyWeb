package com.jnc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.BuoyMessageSender;
import com.jnc.dao.UsersRepositoryQueryAnnotation;
import com.jnc.pojo.Users;





/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class RegisterServerController {
	
	//RabbitMQ 生产者发送器
	@Autowired
	private BuoyMessageSender messageSender;
		
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	@RequestMapping("/RegisterServer")
	public void myController(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		// 用户名
		String usersname = request.getParameter("username");
		// 密码值
		String password = request.getParameter("password");
		// 确认密码值
		String Rpassword = request.getParameter("Rpassword");
		//进入标识
		Boolean into = true;
		//进入时间
		String intoDate = request.getParameter("intoDate");
		//退出标识
		Boolean exit = false;
		//退出时间
		String exitDate = "null";
		//物理地址 
		//设置模块点击退出时清空 
		String macAddress = request.getParameter("macAddress");
				
		
		//连接数据库获得所有用户名
		List<Users> list=
				this.usersRepositoryQueryAnnotation.queryByNameUseSQL(usersname);
		
		// 判断用户名是否已经存在
		// 未存在
		if(list.size()==0) {
			
			// 判断两次密码是否一致
			// 判断两次密码一致
			if(password.equals(Rpassword)) {
				
				try {
					this.messageSender.sendMessage("register_index"+","+usersname+","
							+password+","+into+","+intoDate+","+exit+","+exitDate+","+macAddress);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				response.sendRedirect("http://localhost:8131/index?usersname="+usersname);
				
			}else { // 判断两次密码不一致
				
				response.sendRedirect("http://localhost:8100/register?exception="+"PasswordVerifyException");
				
			}
				
		}else { // 已存在
			
			response.sendRedirect("http://localhost:8100/register?exception="+"UsersnameExistException");
			
		}
		
		
		
	}

}
