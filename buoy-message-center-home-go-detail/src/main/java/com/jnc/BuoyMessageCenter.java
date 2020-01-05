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
						value="${mq.config.queue.message.center.home.go.detail}",
						autoDelete="true"
				),
				exchange=@Exchange(
						value="${mq.config.exchange.message.center.home.go.detail}",
						type=ExchangeTypes.DIRECT
				),
				key="${mq.config.queue.info.routing.key.message.center.home.go.detail}"
		)
)
public class BuoyMessageCenter {
	
	@Autowired
	private BuoyHorizonRepositoryCrudRepository buoyHorizonRepositoryCrudRepository;
	
	@Autowired
	private BuoyAbilityRepositoryCrudRepository buoyAbilityRepositoryCrudRepository;
	
	@Autowired
	private BuoySocialRepositoryCrudRepository buoySocialRepositoryCrudRepository;
	
	@Autowired
	private BuoyBusinessRepositoryCrudRepository buoyBusinessRepositoryCrudRepository;
	
	@Autowired
	private BuoyScienceRepositoryCrudRepository buoyScienceRepositoryCrudRepository;
	
	@RabbitHandler
	public void process(String process){
		
		String[] cut=process.split(",");
		
		String method = cut[0];
		
		String usersname = cut[1];
		
		String key = cut[2] + "_" + cut[3];
		
		String title = cut[4];
		
		String date = cut[5];
		
		String option = cut[6];
		
		switch(key) {
			
			case "msg_horizon":
				
				JPACrudRepositorySaveBuoyHorizon(usersname,title,date,option);
				
			break;

			case "msg_ability":
				
				JPACrudRepositorySaveBuoyAbility(usersname,title,date,option);
				
			break;
			
			case "msg_social":
				
				JPACrudRepositorySaveBuoySocial(usersname,title,date,option);
				
			break;
			
			case "msg_business":
				
				JPACrudRepositorySaveBuoyBusiness(usersname,title,date,option);
				
			break;
			
			case "msg_science":
				
				JPACrudRepositorySaveBuoyScience(usersname,title,date,option);
				
			break;
			
		}
	}
	
	private void JPACrudRepositorySaveBuoyHorizon(String usersname,String title,String date,String option) {
		BuoyHorizon buoyHorizon =new BuoyHorizon();
		buoyHorizon.setUsersname(usersname);
		buoyHorizon.setTitle(title);
		buoyHorizon.setDate(date);
		buoyHorizon.setOption(option);
		this.buoyHorizonRepositoryCrudRepository.save(buoyHorizon);
	}
	private void JPACrudRepositorySaveBuoyAbility(String usersname,String title,String date,String option) {
		BuoyAbility buoyAbility =new BuoyAbility();
		buoyAbility.setUsersname(usersname);
		buoyAbility.setTitle(title);
		buoyAbility.setDate(date);
		buoyAbility.setOption(option);
		this.buoyAbilityRepositoryCrudRepository.save(buoyAbility);
	}
	private void JPACrudRepositorySaveBuoySocial(String usersname,String title,String date,String option) {
		BuoySocial buoySocial =new BuoySocial();
		buoySocial.setUsersname(usersname);
		buoySocial.setTitle(title);
		buoySocial.setDate(date);
		buoySocial.setOption(option);
		this.buoySocialRepositoryCrudRepository.save(buoySocial);
	}
	private void JPACrudRepositorySaveBuoyBusiness(String usersname,String title,String date,String option) {
		BuoyBusiness buoyBusiness =new BuoyBusiness();
		buoyBusiness.setUsersname(usersname);
		buoyBusiness.setTitle(title);
		buoyBusiness.setDate(date);
		buoyBusiness.setOption(option);
		this.buoyBusinessRepositoryCrudRepository.save(buoyBusiness);
	}
	private void JPACrudRepositorySaveBuoyScience(String usersname,String title,String date,String option) {
		BuoyScience buoyScience =new BuoyScience();
		buoyScience.setUsersname(usersname);
		buoyScience.setTitle(title);
		buoyScience.setDate(date);
		buoyScience.setOption(option);
		this.buoyScienceRepositoryCrudRepository.save(buoyScience);
	}
}
