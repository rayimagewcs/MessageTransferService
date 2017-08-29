package com.thinvent.message.async;

import com.thinvent.message.threadpool.ThinventThreadPool;
import com.thinvent.message.threadpool.TransferThread;

public class AsyncMessageGetCallImpl implements IThinventAsyncCall {

	@Override
	public void callback() {
		asyncGetMessage();
	}

	@Override
	public Object callback(Object o) {
		System.out.println("AsyncMessageGetCallImpl callback ... ");
		return null;
	}
	
	public void asyncGetMessage() {
		ThinventThreadPool.execute(new TransferThread());
	}

}
