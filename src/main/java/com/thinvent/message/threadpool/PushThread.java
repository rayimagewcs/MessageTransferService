package com.thinvent.message.threadpool;

import com.thinvent.library.mq.entity.Message;
import com.thinvent.message.async.IThinventAsyncCall;
import com.thinvent.message.transfer.queue.MessageQueue;

public class PushThread implements Runnable {

	private IThinventAsyncCall asyncCallback;
	
	private Message message;
	
	public PushThread(Message message, IThinventAsyncCall asyncCallback) {
		this.message = message;
		this.asyncCallback = asyncCallback;
	}
	
	@Override
	public void run() {
		MessageQueue queue = new MessageQueue();
		queue.push(message);
		asyncCallback.callback();
		
	}

}
