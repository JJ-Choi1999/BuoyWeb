package com.jnc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.utils.MacUtils;

@Controller
public class LoginController {

	@RequestMapping("/{page}")
	public String myController(@PathVariable String page,String exception,
			Model model) throws Exception {
		
		model.addAttribute("exception", exception);
		
		//new Date().getTime()+""
		String str = new MacUtils().getMacList().toString();
		String macAddress = str.replace(",","-");
		model.addAttribute("intoDate", new Date().getTime()+"");
		model.addAttribute("macAddress", macAddress);
		model.addAttribute("exception", exception);
				
		
		return page;
	}

}
