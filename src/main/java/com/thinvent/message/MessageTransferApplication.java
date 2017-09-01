package com.thinvent.message;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thinvent.library.config.InitService;
import com.thinvent.library.config.ServiceConfig;
import com.thinvent.library.mq.entity.Message;
import com.thinvent.library.util.StringUtil;
import com.thinvent.message.config.MessageApplication;
import com.thinvent.message.handler.IMessageHandler;
import com.thinvent.message.handler.impl.MessageHandlerImpl;

@SpringBootApplication
public class MessageTransferApplication {
	public static void main(String[] args) throws IOException {
		InitService.init(null, new MessageApplication().moduleList, StringUtil.getConfigDir(args));
		SpringApplication application = new SpringApplication(MessageTransferApplication.class);
		application.setDefaultProperties(ServiceConfig.loadSpringConfig("message"));
		application.run(args);
//		test();
	}
	
	public static void test() {
		for(;;) {
			IMessageHandler msgHandler = new MessageHandlerImpl();
			Message message = new Message();
			msgHandler.transfer(message);
		}
	}
}
