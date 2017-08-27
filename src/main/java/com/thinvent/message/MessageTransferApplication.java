package com.thinvent.message;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thinvent.message.entity.Message;
import com.thinvent.message.handler.impl.MessageHandlerImpl;
import com.thinvent.message.threadpool.ThinventThreadPool;

@SpringBootApplication
public class MessageTransferApplication {
	public static void main(String[] args) throws IOException {
//		InitService.init(null, new MessageApplication().moduleList, StringUtil.getConfigDir(args));
//		SpringApplication application = new SpringApplication(MessageTransferApplication.class);
//		application.setDefaultProperties(ServiceConfig.loadSpringConfig("message"));
//		application.run(args);
		test();
	}
	
	public static void test() {
		ThinventThreadPool pool = new ThinventThreadPool();
		for(;;) {
			MessageHandlerImpl msgHandler = new MessageHandlerImpl();
			Message message = new Message();
			msgHandler.transfer(message);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
