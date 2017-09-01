package com.thinvent.message.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.thinvent.library.config.ServiceConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ThinventThreadPool {
	private static ThreadPoolExecutor executor;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ThinventThreadPool() {
		int corePoolSize = Integer.parseInt(ServiceConfig.getServiceConfig("message.basic", "threadpool.corePoolsize"));
		int maximumPoolSize = Integer.parseInt(ServiceConfig.getServiceConfig("message.basic", "threadpool.maximumPoolSize"));
		long keepAliveTime = Long.parseLong(ServiceConfig.getServiceConfig("message.basic", "threadpool.keepAliveTime"));
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(maximumPoolSize);
		executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue);
	}
	
	public static void execute(Runnable runnable) {
		try {
			executor.execute(runnable);
		} catch(Exception e) {
			log.error("thread pool execute error: ", e);
		}
		
	}
}
