package com.thinvent.message.handler.impl;

import org.springframework.stereotype.Service;

import com.thinvent.library.mq.entity.Message;
import com.thinvent.message.handler.IMessageHandler;
import com.thinvent.message.threadpool.ThinventThreadPool;
import com.thinvent.message.threadpool.TransferThread;
import com.thinvent.message.transfer.queue.MessageQueue;

@Service
public class MessageHandlerImpl implements IMessageHandler {

	@Override
	public void transfer(Message message) {
		MessageQueue queue = new MessageQueue();
		queue.push(message);
		ThinventThreadPool.execute(new TransferThread());
		System.out.println("transfer ...");
	}

}
