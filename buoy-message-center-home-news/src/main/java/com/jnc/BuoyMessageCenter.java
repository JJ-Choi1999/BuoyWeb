package com.jnc;

import java.util.List;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jnc.dao.FocusRepositoryCrudRepository;
import com.jnc.dao.FocusRepositoryQueryAnnotation;
import com.jnc.pojo.Focus;

@Component
@RabbitListener(
		bindings=@QueueBinding(
				value=@Queue(
						value="${mq.config.queue.message.center.home.news}",
						autoDelete="true"
				),
				exchange=@Exchange(
						value="${mq.config.exchange.message.center.home.news}",
						type=ExchangeTypes.DIRECT
				),
				key="${mq.config.queue.info.routing.key.message.center.home.news}"
		)
)
public class BuoyMessageCenter {
	
	@Autowired
	private FocusRepositoryQueryAnnotation focusRepositoryQueryAnnotation;
	
	@Autowired
	private FocusRepositoryCrudRepository focusRepositoryCrudRepository;
	
	@RabbitHandler
	public void process(String msg){
		
		String[] cut=msg.split(",");
		
		String method=cut[0];
		
		String usersname=cut[1];
		
		Integer goFocusNum=Integer.valueOf(cut[2]);
		
		List<Focus> list=
				this.focusRepositoryQueryAnnotation.queryByNameUseSQL(usersname);
		
		switch(method) {
			
			
			case "news_focus":
				
				Focus focus = list.get(0);
				focus.setNewsFocusNum(focus.getNewsFocusNum()+1);
				
				this.focusRepositoryCrudRepository.save(focus);
				
				break;
			
		}
	}
	
}
