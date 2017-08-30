package com.thinvent.message.transfer.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.stereotype.Component;

import com.thinvent.library.mq.entity.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageQueue {
	private static ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private static Queue<Message> messageQueue = new ConcurrentLinkedQueue<Message>();
	
	private static AtomicInteger i = new AtomicInteger();
	
	public void push(Message message) {
		try {
			lock.writeLock().lock();
			messageQueue.add(message);
//			System.out.println("incrementAndGet size: " + i.incrementAndGet());
		} catch(Exception e) {
			log.error("push message error: ", e);
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	public Message get() {
		Message msg = messageQueue.poll();
		if(msg != null) {
//			System.out.println("incrementAndGet size: " + i.decrementAndGet());
		}
		return msg;
	}
}
