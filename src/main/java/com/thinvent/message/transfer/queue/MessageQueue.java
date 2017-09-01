package com.thinvent.message.transfer.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.thinvent.library.mq.entity.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageQueue {
	private static ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private static Queue<Message> messageQueue = new ConcurrentLinkedQueue<Message>();
	
	public void push(Message message) {
		try {
			lock.writeLock().lock();
			messageQueue.add(message);
		} catch(Exception e) {
			log.error("push message error: ", e);
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	public Message get() {
		Message msg = messageQueue.poll();
		return msg;
	}
}
