package com.thinvent.message.handler;

import com.thinvent.library.mq.entity.Message;

public interface IMessageHandler {
	public void transfer(Message message);
}
