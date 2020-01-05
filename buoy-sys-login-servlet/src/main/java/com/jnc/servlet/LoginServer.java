package com.jnc.servlet;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jnc.dao.AdminRepositoryCrudRepository;
import com.jnc.pojo.Administrators;

/**
 * [优化]，对注册失败的捕捉。（未完成）
 * [缺陷检测]，其他机器进入时间是否与服务机同步。（未完成）
 * @author JNC
 *
 */
//注解法配置Servlet的web.xml
@WebServlet(name="LoginServer",urlPatterns="/LoginServer")
public class LoginServer extends HttpServlet {
	
	@Autowired
	private AdminRepositoryCrudRepository adminRepositoryCrudRepository;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException, IOException {
		 
		// doGet获得username值
		String ioUsersname = request.getParameter("usersname");
		// doGet获得password值
		String ioPassword = request.getParameter("password");
		
		System.out.println("用户输入用户名:"+ioUsersname+"\n用户输入密码:"+ioPassword);
		
		Administrators admin = this.adminRepositoryCrudRepository.findOne(1);
		
		String tbUsersname = admin.getUsersname();
		
		String tbPassword = admin.getPassword();
		
		System.out.println("数据表存储的用户名:"+tbUsersname+"\n数据表存储的密码:"+tbPassword);
		
		if(isUsersname(ioUsersname,tbUsersname)&&isPassword(ioPassword,tbPassword)) {
			System.out.println("验证成功,跳转添加轮播图页面");
			response.sendRedirect("http://localhost:8241/insert?method=viewpager&value=frist_viewpager");
		}else if(isUsersname(ioUsersname,tbUsersname)==false){
			System.out.println("用户名输入错误,跳转添加异常页面并于几秒后跳回登陆界面");
			response.sendRedirect("http://localhost:8231/login?exception="+"ioUsersnameException");
		}else if(isPassword(ioPassword,tbPassword)==false){
			System.out.println("密码输入错误,跳转添加异常页面并于几秒后跳回登陆界面");
			response.sendRedirect("http://localhost:8231/login?exception="+"ioPasswordException");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
		
	}
	
	/**
	 * 用户名输入判断方法
	 * @param ioUsersname 用户输入用户名
	 * @param tbUsersname 数据表存储的用户名
	 * @return
	 */
	private Boolean isUsersname(String ioUsersname,String tbUsersname) {
		//假如判断一致返回true，否则返回false
		if(!ioUsersname.equals(tbUsersname)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 密码输入判断方法
	 * @param ioPassword 用户输入密码
	 * @param tbPassword 数据表存储的密码
	 * @return
	 */
	private Boolean isPassword(String ioPassword,String tbPassword) {
		//假如判断一致返回true，否则返回false
		if(!ioPassword.equals(tbPassword)) {
			return false;
		}
		return true;
	}
	
}
