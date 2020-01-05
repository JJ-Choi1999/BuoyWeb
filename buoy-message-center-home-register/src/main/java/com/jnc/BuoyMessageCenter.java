package com.jnc;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jnc.dao.FocusRepositoryCrudRepository;
import com.jnc.dao.UsersRepositoryCrudRepository;
import com.jnc.pojo.Focus;
import com.jnc.pojo.Users;

@Component
@RabbitListener(
		bindings=@QueueBinding(
				value=@Queue(
						value="${mq.config.queue.message.center.home.register}",
						autoDelete="true"
				),
				exchange=@Exchange(
						value="${mq.config.exchange.message.center.home.register}",
						type=ExchangeTypes.DIRECT
				),
				key="${mq.config.queue.info.routing.key.message.center.home.register}"
		)
)
public class BuoyMessageCenter {
	
	//Users的JPA增删查改模型
	@Autowired
	private UsersRepositoryCrudRepository usersRepositoryCrudRepository;
	
	//Users的JPA增删查改模型
	@Autowired
	private FocusRepositoryCrudRepository focusRepositoryCrudRepository;
	
	@RabbitHandler
	public void process(String msg) throws Exception{
		
		String[] cut=msg.split(",");
		
		String method=cut[0];
		
		switch(method) {
			case "register_index":
				
				String usersname = cut[1];
				
				String password = cut[2];
				
				Boolean into = Boolean.valueOf(cut[3]);
				
				String intoDate = cut[4];
				
				Boolean exit = Boolean.valueOf(cut[5]);
				
				String exitDate = cut[6];
				
				String macAddress = cut[7];
				
				//实体类--用户
				Users users = new Users();
				
				users.setUsersName(usersname);
				users.setPassWord(password);
				users.setInto(into);
				users.setIntoDate(intoDate);
				users.setExit(exit);
				users.setExitDate(exitDate);
				users.setMacAddress(macAddress);
				users.setImg("sports-q-c-1600-500-1.jpg");
				users.setNickname(usersname+intoDate);
				users.setSex("未填写");
				users.setPhone("未填写");
				users.setEmail("未填写");
				
				this.usersRepositoryCrudRepository.save(users);
				
				Focus focus =new Focus();
				focus.setUsersName(usersname);
				focus.setGoFocusNum(0);
				focus.setBuoyFocusNum(0);
				focus.setNewsFocusNum(0);
				focus.setAboutFocusNum(0);
				
				this.focusRepositoryCrudRepository.save(focus);
				
				break;
		}
	}
	
	
	
}
