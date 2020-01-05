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
						value="${mq.config.queue.message.center.sys.insert}",
						autoDelete="true"
				),
				exchange=@Exchange(
						value="${mq.config.exchange.message.center.sys.insert}",
						type=ExchangeTypes.DIRECT
				),
				key="${mq.config.queue.info.routing.key.message.center.sys.insert}"
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
		
		String method=cut[0];
		
		String title=cut[1];
		
		String context=cut[2];
		
		String img=cut[3];
		
		String date=cut[4];
		
		switch(method) {
			case "viewpager_frist_viewpager":
				
				JPACrudRepositorySaveFristViewPager(title,context,img,date);
				
			break;
			
			case "viewpager_edit":
				
				JPACrudRepositorySaveViewPager(title,context,img,date);
				
			break;
			
			
			case "news_horizon":
				
				JPACrudRepositorySaveNewsHorizon(title,context,img,date);
				
			break;

			case "news_ability":
				
				JPACrudRepositorySaveNewsAbility(title,context,img,date);
				
			break;
			
			case "news_social":
				
				JPACrudRepositorySaveNewsSocial(title,context,img,date);
				
			break;
			
			case "news_business":
				
				JPACrudRepositorySaveNewsBusiness(title,context,img,date);
				
			break;
			
			case "news_science":
				
				JPACrudRepositorySaveNewsScience(title,context,img,date);
				
			break;
			
			
			case "msg_horizon":
				
				JPACrudRepositorySaveMsgHorizon(title,context,img,date);
				
			break;

			case "msg_ability":
				
				JPACrudRepositorySaveMsgAbility(title,context,img,date);
				
			break;
			
			case "msg_social":
				
				JPACrudRepositorySaveMsgSocial(title,context,img,date);
				
			break;
			
			case "msg_business":
				
				JPACrudRepositorySaveMsgBusiness(title,context,img,date);
				
			break;
			
			case "msg_science":
				
				JPACrudRepositorySaveMsgScience(title,context,img,date);
				
			break;
			
		}
	}
	
	private void JPACrudRepositorySaveFristViewPager(String title,String context,
			String img,String date) {
		FristViewPager fristViewpager =new FristViewPager();
		fristViewpager.setTitle(title);
		fristViewpager.setContext(context);
		fristViewpager.setImg(img);
		fristViewpager.setDate(date);
		this.fristViewPagerRepositoryCrudRepository.save(fristViewpager);
	}
	private void JPACrudRepositorySaveViewPager(String title,String context,
			String img,String date) {
		ViewPager viewpager =new ViewPager();
		viewpager.setTitle(title);
		viewpager.setContext(context);
		viewpager.setImg(img);
		viewpager.setDate(date);
		this.viewPagerRepositoryCrudRepository.save(viewpager);
	}
	
	private void JPACrudRepositorySaveNewsHorizon(String title,String context,
			String img,String date) {
		NewsHorizon newsHorizon =new NewsHorizon();
		newsHorizon.setTitle(title);
		newsHorizon.setContext(context);
		newsHorizon.setImg(img);
		newsHorizon.setDate(date);
		this.newsHorizonRepositoryCrudRepository.save(newsHorizon);
	}
	private void JPACrudRepositorySaveNewsAbility(String title,String context,
			String img,String date) {
		NewsAbility newsAbility =new NewsAbility();
		newsAbility.setTitle(title);
		newsAbility.setContext(context);
		newsAbility.setImg(img);
		newsAbility.setDate(date);
		this.newsAbilityRepositoryCrudRepository.save(newsAbility);
	}
	private void JPACrudRepositorySaveNewsSocial(String title,String context,
			String img,String date) {
		NewsSocial newsSocial =new NewsSocial();
		newsSocial.setTitle(title);
		newsSocial.setContext(context);
		newsSocial.setImg(img);
		newsSocial.setDate(date);
		this.newsSocialRepositoryCrudRepository.save(newsSocial);
	}
	private void JPACrudRepositorySaveNewsBusiness(String title,String context,
			String img,String date) {
		NewsBusiness newsBusiness =new NewsBusiness();
		newsBusiness.setTitle(title);
		newsBusiness.setContext(context);
		newsBusiness.setImg(img);
		newsBusiness.setDate(date);
		this.newsBusinessRepositoryCrudRepository.save(newsBusiness);
	}
	private void JPACrudRepositorySaveNewsScience(String title,String context,
			String img,String date) {
		NewsScience newsScience =new NewsScience();
		newsScience.setTitle(title);
		newsScience.setContext(context);
		newsScience.setImg(img);
		newsScience.setDate(date);
		this.newsScienceRepositoryCrudRepository.save(newsScience);
	}
	
	private void JPACrudRepositorySaveMsgHorizon(String title,String context,
			String img,String date) {
		MsgHorizon msgHorizon =new MsgHorizon();
		msgHorizon.setTitle(title);
		msgHorizon.setContext(context);
		msgHorizon.setImg(img);
		msgHorizon.setDate(date);
		this.msgHorizonRepositoryCrudRepository.save(msgHorizon);
	}
	private void JPACrudRepositorySaveMsgAbility(String title,String context,
			String img,String date) {
		MsgAbility msgAbility =new MsgAbility();
		msgAbility.setTitle(title);
		msgAbility.setContext(context);
		msgAbility.setImg(img);
		msgAbility.setDate(date);
		this.msgAbilityRepositoryCrudRepository.save(msgAbility);
	}
	private void JPACrudRepositorySaveMsgSocial(String title,String context,
			String img,String date) {
		MsgSocial msgSocial =new MsgSocial();
		msgSocial.setTitle(title);
		msgSocial.setContext(context);
		msgSocial.setImg(img);
		msgSocial.setDate(date);
		this.msgSocialRepositoryCrudRepository.save(msgSocial);
	}
	private void JPACrudRepositorySaveMsgBusiness(String title,String context,
			String img,String date) {
		MsgBusiness msgBusiness =new MsgBusiness();
		msgBusiness.setTitle(title);
		msgBusiness.setContext(context);
		msgBusiness.setImg(img);
		msgBusiness.setDate(date);
		this.msgBusinessRepositoryCrudRepository.save(msgBusiness);
	}
	private void JPACrudRepositorySaveMsgScience(String title,String context,
			String img,String date) {
		MsgScience msgScience =new MsgScience();
		msgScience.setTitle(title);
		msgScience.setContext(context);
		msgScience.setImg(img);
		msgScience.setDate(date);
		this.msgScienceRepositoryCrudRepository.save(msgScience);
	}
}
