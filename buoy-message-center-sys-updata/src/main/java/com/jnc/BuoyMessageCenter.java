package com.jnc;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jnc.dao.*;
import com.jnc.pojo.*;

@Component
@RabbitListener(
		bindings=@QueueBinding(
				value=@Queue(
						value="${mq.config.queue.message.center.sys.updata}",
						autoDelete="true"
				),
				exchange=@Exchange(
						value="${mq.config.exchange.message.center.sys.updata}",
						type=ExchangeTypes.DIRECT
				),
				key="${mq.config.queue.info.routing.key.message.center.sys.updata}"
		)
)
public class BuoyMessageCenter {
	
	@Autowired
	private FristViewPagerRepositoryCrudRepository fristViewPagerRepositoryCrudRepository;
	
	@Autowired
	private ViewPagerRepositoryCrudRepository viewPagerRepositoryCrudRepository;
	
	
	@Autowired
	private NewsHorizonRepositoryCrudRepository newsHorizonRepositoryCrudRepository;
	
	@Autowired
	private NewsAbilityRepositoryCrudRepository newsAbilityRepositoryCrudRepository;
	
	@Autowired
	private NewsSocialRepositoryCrudRepository newsSocialRepositoryCrudRepository;
	
	@Autowired
	private NewsBusinessRepositoryCrudRepository newsBusinessRepositoryCrudRepository;
	
	@Autowired
	private NewsScienceRepositoryCrudRepository newsScienceRepositoryCrudRepository;
	
	
	@Autowired
	private MsgHorizonRepositoryCrudRepository msgHorizonRepositoryCrudRepository;
	
	@Autowired
	private MsgAbilityRepositoryCrudRepository msgAbilityRepositoryCrudRepository;
	
	@Autowired
	private MsgSocialRepositoryCrudRepository msgSocialRepositoryCrudRepository;
	
	@Autowired
	private MsgBusinessRepositoryCrudRepository msgBusinessRepositoryCrudRepository;
	
	@Autowired
	private MsgScienceRepositoryCrudRepository msgScienceRepositoryCrudRepository;
	
	@RabbitHandler
	public void process(String process){
		
		String[] cut=process.split(",");
		
		String key = cut[0];
		
		String id = cut[1];
		
		String title = cut[2];
		
		String context = cut[3];
		
		String img = cut[4];
		
		String date = cut[5];
		
		switch(key) {
			case "viewpager_frist_viewpager":
				
				JPACrudRepositorySaveFristViewPager(id,title,context,img,date);
				
			break;
			
			case "viewpager_edit":
				
				JPACrudRepositorySaveViewPager(id,title,context,img,date);
				
			break;
			
			
			case "news_horizon":
				
				JPACrudRepositorySaveNewsHorizon(id,title,context,img,date);
				
			break;

			case "news_ability":
				
				JPACrudRepositorySaveNewsAbility(id,title,context,img,date);
				
			break;
			
			case "news_social":
				
				JPACrudRepositorySaveNewsSocial(id,title,context,img,date);
				
			break;
			
			case "news_business":
				
				JPACrudRepositorySaveNewsBusiness(id,title,context,img,date);
				
			break;
			
			case "news_science":
				
				JPACrudRepositorySaveNewsScience(id,title,context,img,date);
				
			break;
			
			
			case "msg_horizon":
				
				JPACrudRepositorySaveMsgHorizon(id,title,context,img,date);
				
			break;

			case "msg_ability":
				
				JPACrudRepositorySaveMsgAbility(id,title,context,img,date);
				
			break;
			
			case "msg_social":
				
				JPACrudRepositorySaveMsgSocial(id,title,context,img,date);
				
			break;
			
			case "msg_business":
				
				JPACrudRepositorySaveMsgBusiness(id,title,context,img,date);
				
			break;
			
			case "msg_science":
				
				JPACrudRepositorySaveMsgScience(id,title,context,img,date);
				
			break;
			
		}
	}
	
	private void JPACrudRepositorySaveFristViewPager(String id,String title,String context,
			String img,String date) {
		/*
		FristViewPager fristViewpager = new FristViewPager();
		fristViewpager.setId(Integer.valueOf(id));
		fristViewpager.setTitle(title);
		fristViewpager.setContext(context);
		fristViewpager.setImg(img);
		fristViewpager.setDate(date);
		*/
		FristViewPager fristViewpager = this.fristViewPagerRepositoryCrudRepository.findOne(Integer.valueOf(id));
		fristViewpager.setTitle(title);
		fristViewpager.setContext(context);
		if(!img.equals("Empty")) {
			fristViewpager.setImg(img);
		}
		fristViewpager.setDate(date);
		
		this.fristViewPagerRepositoryCrudRepository.save(fristViewpager);
	}
	private void JPACrudRepositorySaveViewPager(String id,String title,String context,
			String img,String date) {
		/*
		ViewPager viewpager = new ViewPager();
		viewpager.setId(Integer.valueOf(id));
		viewpager.setTitle(title);
		viewpager.setContext(context);
		viewpager.setImg(img);
		viewpager.setDate(date);
		*/
		ViewPager viewpager = this.viewPagerRepositoryCrudRepository.findOne(Integer.valueOf(id));
		viewpager.setTitle(title);
		viewpager.setContext(context);
		if(!img.equals("Empty")) {
			viewpager.setImg(img);
		}
		viewpager.setDate(date);
		
		this.viewPagerRepositoryCrudRepository.save(viewpager);
	}
	
	private void JPACrudRepositorySaveNewsHorizon(String id,String title,String context,
			String img,String date) {
		/*
		NewsHorizon newsHorizon = new NewsHorizon();
		newsHorizon.setId(Integer.valueOf(id));
		newsHorizon.setTitle(title);
		newsHorizon.setContext(context);
		newsHorizon.setImg(img);
		newsHorizon.setDate(date);
		*/
		NewsHorizon newsHorizon = this.newsHorizonRepositoryCrudRepository.findOne(Integer.valueOf(id));
		newsHorizon.setTitle(title);
		newsHorizon.setContext(context);
		if(!img.equals("Empty")) {
			newsHorizon.setImg(img);
		}
		newsHorizon.setDate(date);
		this.newsHorizonRepositoryCrudRepository.save(newsHorizon);
	}
	private void JPACrudRepositorySaveNewsAbility(String id,String title,String context,
			String img,String date) {
		/*
		NewsAbility newsAbility = new NewsAbility();
		newsAbility.setId(Integer.valueOf(id));
		newsAbility.setTitle(title);
		newsAbility.setContext(context);
		newsAbility.setImg(img);
		newsAbility.setDate(date);
		*/
		NewsAbility newsAbility = this.newsAbilityRepositoryCrudRepository.findOne(Integer.valueOf(id));
		newsAbility.setTitle(title);
		newsAbility.setContext(context);
		if(!img.equals("Empty")) {
			newsAbility.setImg(img);
		}
		newsAbility.setDate(date);
		this.newsAbilityRepositoryCrudRepository.save(newsAbility);
	}
	private void JPACrudRepositorySaveNewsSocial(String id,String title,String context,
			String img,String date) {
		/*
		NewsSocial newsSocial = new NewsSocial();
		newsSocial.setId(Integer.valueOf(id));
		newsSocial.setTitle(title);
		newsSocial.setContext(context);
		newsSocial.setImg(img);
		newsSocial.setDate(date);
		*/
		NewsSocial newsSocial = this.newsSocialRepositoryCrudRepository.findOne(Integer.valueOf(id));
		newsSocial.setTitle(title);
		newsSocial.setContext(context);
		if(!img.equals("Empty")) {
			newsSocial.setImg(img);
		}
		newsSocial.setDate(date);
		this.newsSocialRepositoryCrudRepository.save(newsSocial);
	}
	private void JPACrudRepositorySaveNewsBusiness(String id,String title,String context,
			String img,String date) {
		/*
		NewsBusiness newsBusiness = new NewsBusiness();
		newsBusiness.setId(Integer.valueOf(id));
		newsBusiness.setTitle(title);
		newsBusiness.setContext(context);
		newsBusiness.setImg(img);
		newsBusiness.setDate(date);
		*/
		NewsBusiness newsBusiness = this.newsBusinessRepositoryCrudRepository.findOne(Integer.valueOf(id));
		newsBusiness.setTitle(title);
		newsBusiness.setContext(context);
		if(!img.equals("Empty")) {
			newsBusiness.setImg(img);
		}
		newsBusiness.setDate(date);
		this.newsBusinessRepositoryCrudRepository.save(newsBusiness);
	}
	private void JPACrudRepositorySaveNewsScience(String id,String title,String context,
			String img,String date) {
		/*
		NewsScience newsScience = new NewsScience();
		newsScience.setId(Integer.valueOf(id));
		newsScience.setTitle(title);
		newsScience.setContext(context);
		newsScience.setImg(img);
		newsScience.setDate(date);
		*/
		NewsScience newsScience = this.newsScienceRepositoryCrudRepository.findOne(Integer.valueOf(id));
		newsScience.setTitle(title);
		newsScience.setContext(context);
		if(!img.equals("Empty")) {
			newsScience.setImg(img);
		}
		newsScience.setDate(date);
		this.newsScienceRepositoryCrudRepository.save(newsScience);
	}
	
	private void JPACrudRepositorySaveMsgHorizon(String id,String title,String context,
			String img,String date) {
		/*
		MsgHorizon msgHorizon = new MsgHorizon();
		msgHorizon.setId(Integer.valueOf(id));
		msgHorizon.setTitle(title);
		msgHorizon.setContext(context);
		msgHorizon.setImg(img);
		msgHorizon.setDate(date);
		*/
		MsgHorizon msgHorizon = this.msgHorizonRepositoryCrudRepository.findOne(Integer.valueOf(id));
		msgHorizon.setTitle(title);
		msgHorizon.setContext(context);
		if(!img.equals("Empty")) {
			msgHorizon.setImg(img);
		}
		msgHorizon.setDate(date);
		this.msgHorizonRepositoryCrudRepository.save(msgHorizon);
	}
	private void JPACrudRepositorySaveMsgAbility(String id,String title,String context,
			String img,String date) {
		/*
		MsgAbility msgAbility = new MsgAbility();
		msgAbility.setId(Integer.valueOf(id));
		msgAbility.setTitle(title);
		msgAbility.setContext(context);
		msgAbility.setImg(img);
		msgAbility.setDate(date);
		*/
		MsgAbility msgAbility = this.msgAbilityRepositoryCrudRepository.findOne(Integer.valueOf(id));
		msgAbility.setTitle(title);
		msgAbility.setContext(context);
		if(!img.equals("Empty")) {
			msgAbility.setImg(img);
		}
		msgAbility.setDate(date);
		this.msgAbilityRepositoryCrudRepository.save(msgAbility);
	}
	private void JPACrudRepositorySaveMsgSocial(String id,String title,String context,
			String img,String date) {
		/*
		MsgSocial msgSocial = new MsgSocial();
		msgSocial.setId(Integer.valueOf(id));
		msgSocial.setTitle(title);
		msgSocial.setContext(context);
		msgSocial.setImg(img);
		msgSocial.setDate(date);
		*/
		MsgSocial msgSocial = this.msgSocialRepositoryCrudRepository.findOne(Integer.valueOf(id));
		msgSocial.setTitle(title);
		msgSocial.setContext(context);
		if(!img.equals("Empty")) {
			msgSocial.setImg(img);
		}
		msgSocial.setDate(date);
		this.msgSocialRepositoryCrudRepository.save(msgSocial);
	}
	private void JPACrudRepositorySaveMsgBusiness(String id,String title,String context,
			String img,String date) {
		/*
		MsgBusiness msgBusiness = new MsgBusiness();
		msgBusiness.setId(Integer.valueOf(id));
		msgBusiness.setTitle(title);
		msgBusiness.setContext(context);
		msgBusiness.setImg(img);
		msgBusiness.setDate(date);
		*/
		MsgBusiness msgBusiness = this.msgBusinessRepositoryCrudRepository.findOne(Integer.valueOf(id));
		msgBusiness.setTitle(title);
		msgBusiness.setContext(context);
		if(!img.equals("Empty")) {
			msgBusiness.setImg(img);
		}
		msgBusiness.setDate(date);
		this.msgBusinessRepositoryCrudRepository.save(msgBusiness);
	}
	private void JPACrudRepositorySaveMsgScience(String id,String title,String context,
			String img,String date) {
		/*
		MsgScience msgScience = new MsgScience();
		msgScience.setId(Integer.valueOf(id));
		msgScience.setTitle(title);
		msgScience.setContext(context);
		msgScience.setImg(img);
		msgScience.setDate(date);
		*/
		MsgScience msgScience = this.msgScienceRepositoryCrudRepository.findOne(Integer.valueOf(id));
		msgScience.setTitle(title);
		msgScience.setContext(context);
		if(!img.equals("Empty")) {
			msgScience.setImg(img);
		}
		msgScience.setDate(date);
		this.msgScienceRepositoryCrudRepository.save(msgScience);
	}
}
