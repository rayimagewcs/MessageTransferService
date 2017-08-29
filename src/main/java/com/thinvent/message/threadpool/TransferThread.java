package com.thinvent.message.threadpool;

import com.thinvent.library.exception.ThinventBaseException;
import com.thinvent.library.mq.entity.Message;
import com.thinvent.message.adapt.IMessageAdapt;
import com.thinvent.message.adapt.impl.MessageAdaptImpl;
import com.thinvent.message.transfer.queue.MessageQueue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransferThread implements Runnable {
	private IMessageAdapt messageAdapt = new MessageAdaptImpl();

	@Override
	public void run() {
		MessageQueue messageQueue = new MessageQueue();
		Message message = messageQueue.get();
		try {
			messageAdapt.transfer(message);
		} catch (ThinventBaseException e) {
			log.error("adapt transfer message error: ", message);
		}
	}

}
