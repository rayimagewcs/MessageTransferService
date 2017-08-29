package com.thinvent.message.adapt;

import com.thinvent.library.exception.ThinventBaseException;
import com.thinvent.library.mq.entity.Message;

public interface IMessageAdapt {
	public void transfer(Message message) throws ThinventBaseException;
}
