package com.thinvent.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.thinvent.library.exception.ThinventBaseException;
import com.thinvent.library.mq.entity.Message;
import com.thinvent.message.handler.IMessageHandler;

@Controller
@RequestMapping(value = "/message")
public class MessageController {
	
	@Autowired
	private IMessageHandler messageHandler;
	
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	public void getMessage(String msg) throws ThinventBaseException {
		Message message = JSONObject.parseObject(msg, Message.class);
		if(message == null) {
			System.out.println("pushMessage message is null");
			return;
		}
		messageHandler.transfer(message);
	}
	
	@RequestMapping(value = "/push", method = RequestMethod.POST)
	public void pushMessage(@RequestBody Message message) throws ThinventBaseException {
		// ÏûÏ¢Îª¿Õ¶ªÆú
		if(message != null) {
			messageHandler.transfer(message);
			return;
		}
	}
}
