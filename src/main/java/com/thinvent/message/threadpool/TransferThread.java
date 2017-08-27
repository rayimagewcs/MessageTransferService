package com.thinvent.message.threadpool;

import com.thinvent.message.entity.Message;

public class TransferThread implements Runnable {
	private Message message;
	
	public TransferThread(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		// TODO transfer message to service
		try {
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TransferThread: " + this.message);
		
	}

}
