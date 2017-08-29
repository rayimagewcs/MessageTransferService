package com.thinvent.message.adapt.impl;

import java.util.HashMap;
import java.util.Map;

import com.thinvent.library.Constants;
import com.thinvent.library.config.ServiceConfig;
import com.thinvent.library.exception.ThinventBaseException;
import com.thinvent.library.mq.entity.Message;
import com.thinvent.library.util.GetPostUtil;
import com.thinvent.message.adapt.IMessageAdapt;

public class MessageAdaptImpl implements IMessageAdapt {

	private String baseUrl = ServiceConfig.getServiceConfig("message.basic", Constants.apiBasicUrlKey);
	
	@Override
	public void transfer(Message message) throws ThinventBaseException {
		String url = baseUrl + "/message/warning";
		Map<String, Object> map = new HashMap<>();
		map.put("message", message);
//		GetPostUtil.sendPost(url, map.toString());
	}

}
