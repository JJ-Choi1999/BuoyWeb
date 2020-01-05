package com.jnc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.dao.*;
import com.jnc.pojo.*;



/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class BuoyDetailController {
	
	//FristViewPager的JPA增删查改模型
	@Autowired
	private FristViewPagerRepositoryQueryAnnotation fristViewPagerRepositoryQueryAnnotation;
	
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	@Autowired
	private BuoyAbilityRepositoryQueryAnnotation buoyAbilityRepositoryQueryAnnotation;
	
	@Autowired
	private BuoyBusinessRepositoryQueryAnnotation buoyBusinessRepositoryQueryAnnotation;
	
	@Autowired
	private BuoyHorizonRepositoryQueryAnnotation buoyHorizonRepositoryQueryAnnotation;
	
	@Autowired
	private BuoyScienceRepositoryQueryAnnotation buoyScienceRepositoryQueryAnnotation;
	
	@Autowired
	private BuoySocialRepositoryQueryAnnotation buoySocialRepositoryQueryAnnotation;
	
	
	@RequestMapping("/{page}")
	public String myController(@PathVariable String page,
			String usersname,String action,Model model) {
		
		FristViewPager fristViewPager = 
				this.fristViewPagerRepositoryQueryAnnotation.queryByFristViewPagerUseSQL();
			
		model.addAttribute("fristViewPagerTitle", fristViewPager.getTitle());
		
		
		List<Users> list=
				this.usersRepositoryQueryAnnotation.queryByNameUseSQL(usersname);
		
		String img = "http://localhost:8401/img/" + list.get(0).getImg(); 
		
		model.addAttribute("nickname", list.get(0).getNickname());
		
		model.addAttribute("usersname", usersname);
		
		model.addAttribute("img", img);
		
		
		String dateCycle = myDateEdit(action);
		String []dateCycleEdit = dateCycle.split(",");
		model.addAttribute("start_cycle", dateCycleEdit[0]);
		model.addAttribute("end_cycle", dateCycleEdit[1]);
		
		String yesCount =  myStrEdit("yes",action);
		String []yesCountEdit = yesCount.split(",");
		
		String noCount =  myStrEdit("no",action);
		String []noCountEdit = noCount.split(",");
		
		Double horizonYesPro = (Double.valueOf(yesCountEdit[2])/(Double.valueOf(yesCountEdit[2])+Double.valueOf(noCountEdit[2])))*100;
		Double horizonNoPro = (Double.valueOf(noCountEdit[2])/(Double.valueOf(yesCountEdit[2])+Double.valueOf(noCountEdit[2])))*100;
		
		Double abilityYesPro = (Double.valueOf(yesCountEdit[0])/(Double.valueOf(yesCountEdit[0])+Double.valueOf(noCountEdit[0])))*100;
		Double abilityNoPro = (Double.valueOf(noCountEdit[0])/(Double.valueOf(yesCountEdit[0])+Double.valueOf(noCountEdit[0])))*100;
		
		Double socialYesPro = (Double.valueOf(yesCountEdit[4])/(Double.valueOf(yesCountEdit[4])+Double.valueOf(noCountEdit[4])))*100;
		Double socialNoPro = (Double.valueOf(noCountEdit[4])/(Double.valueOf(yesCountEdit[4])+Double.valueOf(noCountEdit[4])))*100;
		
		Double businessYesPro = (Double.valueOf(yesCountEdit[1])/(Double.valueOf(yesCountEdit[1])+Double.valueOf(noCountEdit[1])))*100;
		Double businessNoPro = (Double.valueOf(noCountEdit[1])/(Double.valueOf(yesCountEdit[1])+Double.valueOf(noCountEdit[1])))*100;
		
		Double scienceYesPro = (Double.valueOf(yesCountEdit[3])/(Double.valueOf(yesCountEdit[3])+Double.valueOf(noCountEdit[3])))*100;
		Double scienceNoPro = (Double.valueOf(noCountEdit[3])/(Double.valueOf(yesCountEdit[3])+Double.valueOf(noCountEdit[3])))*100;
		
		model.addAttribute("horizon_yes_pro", horizonYesPro+"%");
		model.addAttribute("horizon_no_pro", horizonNoPro+"%");
		
		model.addAttribute("ability_yes_pro", abilityYesPro+"%");
		model.addAttribute("ability_no_pro", abilityNoPro+"%");
		
		model.addAttribute("social_yes_pro", socialYesPro+"%");
		model.addAttribute("social_no_pro", socialNoPro+"%");
		
		model.addAttribute("business_yes_pro", businessYesPro+"%");
		model.addAttribute("business_no_pro", businessNoPro+"%");
		
		model.addAttribute("science_yes_pro", scienceYesPro+"%");
		model.addAttribute("science_no_pro", scienceNoPro+"%");
		
		
		return page;
	}

	
	/**
	 * 周期内选项条目截取方法
	 * @param opt 截取判定符
	 * @param date 截取周期
	 * @return
	 */
	private String myStrEdit(String opt,String date) {
		
		String str = null;
		
		switch(date) {
			
			case "weekly":
				
				long weekly=new Date().getTime()-604800000;
				
				List<BuoyAbility> weeklyList = this.buoyAbilityRepositoryQueryAnnotation.queryAbilityOptCount(opt,weekly+"");
				List<BuoyBusiness> weeklyList01 = this.buoyBusinessRepositoryQueryAnnotation.queryBusinessOptCount(opt,weekly+"");
				List<BuoyHorizon> weeklyList02 = this.buoyHorizonRepositoryQueryAnnotation.queryHorizonOptCount(opt,weekly+"");
				List<BuoyScience> weeklyList03 = this.buoyScienceRepositoryQueryAnnotation.queryScienceOptCount(opt,weekly+"");
				List<BuoySocial> weeklyList04 = this.buoySocialRepositoryQueryAnnotation.querySocialOptCount(opt,weekly+"");
				
				str = weeklyList.size() + "," + weeklyList01.size() + "," + weeklyList02.size() + "," + weeklyList03.size() + "," + weeklyList04.size();
				
				break;
				
			case "monthly":
				
				long monthly=new Date().getTime()-2419200000L;
				
				List<BuoyAbility> monthlyList = this.buoyAbilityRepositoryQueryAnnotation.queryAbilityOptCount(opt,monthly+"");
				List<BuoyBusiness> monthlyList01 = this.buoyBusinessRepositoryQueryAnnotation.queryBusinessOptCount(opt,monthly+"");
				List<BuoyHorizon> monthlyList02 = this.buoyHorizonRepositoryQueryAnnotation.queryHorizonOptCount(opt,monthly+"");
				List<BuoyScience> monthlyList03 = this.buoyScienceRepositoryQueryAnnotation.queryScienceOptCount(opt,monthly+"");
				List<BuoySocial> monthlyList04 = this.buoySocialRepositoryQueryAnnotation.querySocialOptCount(opt,monthly+"");
				
				str = monthlyList.size() + "," + monthlyList01.size() + "," + monthlyList02.size() + "," + monthlyList03.size() + "," + monthlyList04.size();
				
				break;
			
			case "quarterly":
				
				long quarterly=new Date().getTime()-7257600000L;
				
				List<BuoyAbility> quarterlyList = this.buoyAbilityRepositoryQueryAnnotation.queryAbilityOptCount(opt,quarterly+"");
				List<BuoyBusiness> quarterlyList01 = this.buoyBusinessRepositoryQueryAnnotation.queryBusinessOptCount(opt,quarterly+"");
				List<BuoyHorizon> quarterlyList02 = this.buoyHorizonRepositoryQueryAnnotation.queryHorizonOptCount(opt,quarterly+"");
				List<BuoyScience> quarterlyList03 = this.buoyScienceRepositoryQueryAnnotation.queryScienceOptCount(opt,quarterly+"");
				List<BuoySocial> quarterlyList04 = this.buoySocialRepositoryQueryAnnotation.querySocialOptCount(opt,quarterly+"");
				
				str = quarterlyList.size() + "," + quarterlyList01.size() + "," + quarterlyList02.size() + "," + quarterlyList03.size() + "," + quarterlyList04.size();
				
				
				break;
			
			case "semi":
				
				long semi=new Date().getTime()-15768000000L;
				
				List<BuoyAbility> semiList = this.buoyAbilityRepositoryQueryAnnotation.queryAbilityOptCount(opt,semi+"");
				List<BuoyBusiness> semiList01 = this.buoyBusinessRepositoryQueryAnnotation.queryBusinessOptCount(opt,semi+"");
				List<BuoyHorizon> semiList02 = this.buoyHorizonRepositoryQueryAnnotation.queryHorizonOptCount(opt,semi+"");
				List<BuoyScience> semiList03 = this.buoyScienceRepositoryQueryAnnotation.queryScienceOptCount(opt,semi+"");
				List<BuoySocial> semiList04 = this.buoySocialRepositoryQueryAnnotation.querySocialOptCount(opt,semi+"");
				
				str = semiList.size() + "," + semiList01.size() + "," + semiList02.size() + "," + semiList03.size() + "," + semiList04.size();
				
				break;
			
			case "annual":
				
				long annual=new Date().getTime()-31536000000L;
				
				List<BuoyAbility> annualList = this.buoyAbilityRepositoryQueryAnnotation.queryAbilityOptCount(opt,annual+"");
				List<BuoyBusiness> annualList01 = this.buoyBusinessRepositoryQueryAnnotation.queryBusinessOptCount(opt,annual+"");
				List<BuoyHorizon> annualList02 = this.buoyHorizonRepositoryQueryAnnotation.queryHorizonOptCount(opt,annual+"");
				List<BuoyScience> annualList03 = this.buoyScienceRepositoryQueryAnnotation.queryScienceOptCount(opt,annual+"");
				List<BuoySocial> annualList04 = this.buoySocialRepositoryQueryAnnotation.querySocialOptCount(opt,annual+"");
				
				str = annualList.size() + "," + annualList01.size() + "," + annualList02.size() + "," + annualList03.size() + "," + annualList04.size();
				
				
				
				break;
		
		}
		
		return str;
	}
	
	/**
	 * 时间周期截取器
	 * @param date 时间周期
	 * @return
	 */
	private String myDateEdit(String date) {
		
		String str = null;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");
		
		switch(date) {
			
			case "weekly":
				
				long weekly=new Date().getTime()-604800000;
				
				String weeklyStartDate = df.format(weekly);
				
				String weeklyEndDate = df.format(new Date().getTime());
				
				str = weeklyStartDate + "," + weeklyEndDate;
				
				break;
				
			case "monthly":
				
				long monthly=new Date().getTime()-2419200000L;
				
				String monthlyStartDate = df.format(monthly);
				
				String monthlyEndDate = df.format(new Date().getTime());
				
				str = monthlyStartDate + "," + monthlyEndDate;
				
				break;
			
			case "quarterly":
				
				long quarterly=new Date().getTime()-7257600000L;
				
				String quarterlyStartDate = df.format(quarterly);
				
				String quarterlyEndDate = df.format(new Date().getTime());
				
				str = quarterlyStartDate + "," + quarterlyEndDate;
				
				
				
				break;
			
			case "semi":
				
				long semi=new Date().getTime()-15768000000L;
				
				String semiStartDate = df.format(semi);
				
				String semiEndDate = df.format(new Date().getTime());
				
				str = semiStartDate + "," + semiEndDate;
				
				break;
			
			case "annual":
				
				long annual=new Date().getTime()-31536000000L;
				
				String annualStartDate = df.format(annual);
				
				String annualEndDate = df.format(new Date().getTime());
				
				str = annualStartDate + "," + annualEndDate;		
				
				
				break;
		
		}
		
		return str;
	}
	
}
