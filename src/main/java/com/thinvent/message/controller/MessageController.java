package com.thinvent.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thinvent.library.mq.entity.Message;
import com.thinvent.message.handler.IMessageHandler;

@Controller
@RequestMapping(value = "/message")
public class MessageController {
	
	@Autowired
	private IMessageHandler messageHandler;
	
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	public void pushMessage(@RequestParam("message") Message message) {
//		System.out.println("MessageController pushMessage: " + message);
		messageHandler.transfer(message);
	}
}
