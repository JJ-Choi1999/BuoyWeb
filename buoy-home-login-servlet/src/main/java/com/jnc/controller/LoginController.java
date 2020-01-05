package com.jnc.controller;

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
public class LoginController {

	// RabbitMQ 生产者发送器
	@Autowired
	private BuoyMessageSender messageSender;

	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;

	@RequestMapping("/LoginServer")
	public void myController(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 用户名
		String usersname = request.getParameter("usersname");
		// 密码值
		String password = request.getParameter("password");
		// 进入标识
		Boolean into = true;
		// 进入时间
		String intoDate = request.getParameter("intoDate");
		// 退出标识
		Boolean exit = false;
		// 物理地址
		// 设置模块点击退出时清空
		String macAddress = request.getParameter("macAddress");

		// 连接数据库获得所有用户名
		List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseSQL(usersname);

		// 判断用户名是否已经存在
		// 用户已经存在
		if (list.size() == 1) {

			// 判断用户名和密码是否一致
			// 用户名和密码一致
			if (usersname.equals(list.get(0).getUsersName())&&password.equals(list.get(0).getPassWord())) {

				try {
					this.messageSender.sendMessage("login_index" + "," + list.get(0).getUsersId() + "," + into
							+ "," + intoDate + "," + exit + ","  + macAddress);

				} catch (Exception e) {
					e.printStackTrace();
				}

				response.sendRedirect("http://localhost:8131/index?usersname=" + usersname);

			} else { // 用户名或密码不一致

				response.sendRedirect("http://localhost:8111/login?exception=" + "usersIoException");

			}

		} else if (list.size() == 0){ // 用户未存在

			response.sendRedirect("http://localhost:8111/login?exception=" + "usersEmtryException");

		}

	}

}
