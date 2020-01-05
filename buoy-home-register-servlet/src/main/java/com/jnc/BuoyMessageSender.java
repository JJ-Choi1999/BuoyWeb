package com.jnc;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 消息发送者。
 * 可优化:直接储存实体对象序列化
 * @author JNC
 *
 */
@Component
public class BuoyMessageSender {

	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	
	//exchange 交换器名称
	@Value("${mq.config.exchange.message.center.home.register}")
	private String exchange;
	
	//routingkey 路由键
	@Value("${mq.config.queue.info.routing.key.message.center.home.register}")
	private String routingkey;
	
	/**
	 * 发送用户名队列
	 * @param usersname	用户名
	 */
	public void sendMessage(String msg){
		//向消息队列发送消息
		//参数一：交换器名称
		//参数二：路由键
		//参数三：用户名
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, 
				this.routingkey, msg);
	}
	
}
