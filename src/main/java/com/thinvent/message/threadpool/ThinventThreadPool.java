package com.thinvent.message.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.thinvent.library.config.ServiceConfig;

@Component
public class ThinventThreadPool {
	private static ThreadPoolExecutor executor;
	
	@SuppressWarnings("unused")
	public ThinventThreadPool() {
//		int corePoolSize = Integer.parseInt(ServiceConfig.getServiceConfig("message.basic", "threadpool.corePoolsize"));
//		int maximumPoolSize = Integer.parseInt(ServiceConfig.getServiceConfig("message.basic", "threadpool.maximumPoolSize"));
//		long keepAliveTime = Long.parseLong(ServiceConfig.getServiceConfig("message.basic", "threadpool.poolsize"));
//		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(maximumPoolSize);
//		executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue);
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(1);
		executor = new ThreadPoolExecutor(10, 15, 200, TimeUnit.SECONDS, workQueue);
	}
	
	public static void execute(Runnable runnable) {
		try {
			System.out.println("execute: " + executor);
			executor.execute(runnable);
			ThreadFactory factory = executor.getThreadFactory();
			Thread t = factory.newThread(runnable);
			System.out.println("threadId: " + t.getId());
		} catch(Exception e) {
			System.out.println("thread pool execute error" + e);
		}
		
	}
}
