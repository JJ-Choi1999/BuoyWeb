package com.jnc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jnc.dao.*;
import com.jnc.pojo.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BuoyDetailApplication.class)
public class BuoyDetailApplicationTests {

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
	
	
	@Test
	public void contextLoads() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");//设置日期格式
		//new Date().getTime(); 获取时间戳
		String date = df.format(new Date().getTime());// new Date()为获取当前系统时间，也可使用当前时间戳
		String date01=new Date().getTime()+"";
		System.out.println("格式化形式:"+date+"\n时间戳形式:"+date01);
	}
	
	/*
	@Test
	public void queryAbilityOptYesCountTest() {
		
		long date=new Date().getTime()-604800000;
		
		List<BuoyAbility> list = this.buoyAbilityRepositoryQueryAnnotation.queryAbilityOptCount("yes",date+"");
		System.out.println(list.size());
		System.out.println(date);
		
	}*/
	
	@Test
	public void myTest() {
		
		String str = myStrEdit("yes","weekly");
		String str01 = myStrEdit("no","weekly");
		System.out.println(str);
		System.out.println(str01);
	}
	
	@Test
	public void myTest01() {
		 
		System.out.println((double)1/3*100);
	}
	
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
