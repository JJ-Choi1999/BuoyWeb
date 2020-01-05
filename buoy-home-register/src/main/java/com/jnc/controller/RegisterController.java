package com.jnc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.utils.MacUtils;




/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class RegisterController {

	@RequestMapping("/{page}")
	public String myController(HttpServletRequest request,@PathVariable String page,String exception,
			Model model) throws Exception {
		
		//new Date().getTime()+""
		String str = new MacUtils().getMacList().toString();
		String macAddress = str.replace(",","-");
		
		System.out.println(macAddress);
		
		model.addAttribute("intoDate", new Date().getTime()+"");
		model.addAttribute("macAddress", macAddress);
		model.addAttribute("exception", exception);
		
		return page;
	}

}
