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


@Component
@RabbitListener(
		bindings=@QueueBinding(
				value=@Queue(
						value="${mq.config.queue.message.center.sys.delete}",
						autoDelete="true"
				),
				exchange=@Exchange(
						value="${mq.config.exchange.message.center.sys.delete}",
						type=ExchangeTypes.DIRECT
				),
				key="${mq.config.queue.info.routing.key.message.center.sys.delete}"
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
		
		String key=cut[0];
		
		Integer id=Integer.valueOf(cut[1]);
		
		switch(key) {
		
			case "viewpager_frist_viewpager":
				
				this.fristViewPagerRepositoryCrudRepository.delete(id);
				
			break;
			
			case "viewpager_edit":
				
				this.viewPagerRepositoryCrudRepository.delete(id);
				
			break;
			
			
			case "news_horizon":
				
				this.newsHorizonRepositoryCrudRepository.delete(id);
				
			break;
	
			case "news_ability":
				
				this.newsAbilityRepositoryCrudRepository.delete(id);
				
			break;
			
			case "news_social":
				
				this.newsSocialRepositoryCrudRepository.delete(id);
				
			break;
			
			case "news_business":
				
				this.newsBusinessRepositoryCrudRepository.delete(id);
				
			break;
			
			case "news_science":
				
				this.newsScienceRepositoryCrudRepository.delete(id);
				
			break;
			
			
			case "msg_horizon":
				
				this.msgHorizonRepositoryCrudRepository.delete(id);
				
			break;
	
			case "msg_ability":
				
				this.msgAbilityRepositoryCrudRepository.delete(id);
				
			break;
			
			case "msg_social":
				
				this.msgSocialRepositoryCrudRepository.delete(id);
				
			break;
			
			case "msg_business":
				
				this.msgBusinessRepositoryCrudRepository.delete(id);
				
			break;
			
			case "msg_science":
				
				this.msgScienceRepositoryCrudRepository.delete(id);
				
			break;
			
		}
	}
	
}
