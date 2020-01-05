package com.jnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.dao.UsersRepositoryQueryAnnotation;
import com.jnc.pojo.Users;





/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class SetController {

	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	@RequestMapping("/{page}")
	public String myController(@PathVariable String page,
			String usersname,Model model) {
		
		List<Users> list=
				this.usersRepositoryQueryAnnotation.queryByNameUseSQL(usersname);
		
		String img = "http://192.168.134.213:8401/img/" + list.get(0).getImg(); 
		
		model.addAttribute("usersname", usersname);
		model.addAttribute("img", img);
		
		model.addAttribute("nickname", list.get(0).getNickname());
		model.addAttribute("sex", list.get(0).getSex());
		model.addAttribute("email", list.get(0).getEmail());
		model.addAttribute("phone", list.get(0).getPhone());
		
		return page;
	}

}
