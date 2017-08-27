package com.thinvent.message.handler.impl;

import org.springframework.stereotype.Service;

import com.thinvent.message.entity.Message;
import com.thinvent.message.handler.IMessageHandler;
import com.thinvent.message.threadpool.ThinventThreadPool;
import com.thinvent.message.threadpool.TransferThread;

@Service
public class MessageHandlerImpl implements IMessageHandler {

	@Override
	public void transfer(Message message) {
//		ThinventThreadPool pool = new ThinventThreadPool();
//		pool.execute(new TransferThread(message));
		ThinventThreadPool.execute(new TransferThread(message));
		
//		Thread t = new Thread(new TransferThread(message));
//		t.start();
	}

}
