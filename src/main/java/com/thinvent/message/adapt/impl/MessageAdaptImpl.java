package com.thinvent.message.adapt.impl;

import com.thinvent.library.exception.ThinventBaseException;
import com.thinvent.message.adapt.IMessageAdapt;
import com.thinvent.message.entity.Message;

public class MessageAdaptImpl implements IMessageAdapt {

	@Override
	public void transfer(Message message) throws ThinventBaseException {
		System.out.println("message adapt transfer: " + message);
	}

}
