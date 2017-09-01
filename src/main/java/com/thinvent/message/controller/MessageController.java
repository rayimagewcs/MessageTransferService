package com.thinvent.message.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.thinvent.library.exception.ThinventBaseException;
import com.thinvent.library.mq.entity.Message;
import com.thinvent.message.handler.IMessageHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/message")
public class MessageController {
	
	@Autowired
	private IMessageHandler messageHandler;
	
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	public void getMessage(String msg, HttpServletRequest request) throws ThinventBaseException {
		String ip = request.getRemoteAddr();
		Message message = JSONObject.parseObject(msg, Message.class);
		if(message == null || "".equals(message)) {
			log.warn("remote send null message ", ip);
			return;
		}
		messageHandler.transfer(message);
	}
	
	@RequestMapping(value = "/push", method = RequestMethod.POST)
	public void pushMessage(@RequestBody Message message, HttpServletRequest request) throws ThinventBaseException {
		String ip = request.getRemoteAddr();
		// ÏûÏ¢Îª¿Õ¶ªÆú
		if(message != null) {
			log.warn("remote send null message ", ip);
			messageHandler.transfer(message);
			return;
		}
	}
}
