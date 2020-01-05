package com.jnc;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jnc.dao.UsersRepositoryCrudRepository;
import com.jnc.pojo.Users;

@Component
@RabbitListener(
		bindings=@QueueBinding(
				value=@Queue(
						value="${mq.config.queue.message.center.home.login}",
						autoDelete="true"
				),
				exchange=@Exchange(
						value="${mq.config.exchange.message.center.home.login}",
						type=ExchangeTypes.DIRECT
				),
				key="${mq.config.queue.info.routing.key.message.center.home.login}"
		)
)
public class BuoyMessageCenter {
	
	//Users的JPA增删查改模型
	@Autowired
	private UsersRepositoryCrudRepository usersRepositoryCrudRepository;
	
	@RabbitHandler
	public void process(String msg){
		
		String[] cut=msg.split(",");
		
		String method=cut[0];
		
		
		switch(method) {
		
			case "login_index":
				
				Integer id = Integer.valueOf(cut[1]);
				Boolean into = Boolean.valueOf(cut[2]);
				String intoDate = cut[3];
				Boolean exit = Boolean.valueOf(cut[4]);
				String macAddress = cut[5];
				
				//实体类--用户
				Users users = this.usersRepositoryCrudRepository.findOne(id);
				users.setInto(into);
				users.setIntoDate(intoDate);
				users.setExit(exit);
				users.setMacAddress(macAddress);
				this.usersRepositoryCrudRepository.save(users);
				
				break;
			
			
		}
	}
	
	
	
}
