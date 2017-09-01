package com.thinvent.message.adapt.impl;

import com.alibaba.fastjson.JSON;
import com.thinvent.library.Constants;
import com.thinvent.library.config.ServiceConfig;
import com.thinvent.library.exception.ThinventBaseException;
import com.thinvent.library.mq.entity.Message;
import com.thinvent.library.util.GetPostUtil;
import com.thinvent.message.adapt.IMessageAdapt;

public class MessageAdaptImpl implements IMessageAdapt {

	private String baseUrl = ServiceConfig.getServiceConfig(Constants.messageTransferBasicService, Constants.apiBasicUrlKey);
	
	@Override
	public void transfer(Message message) throws ThinventBaseException {
		String url = baseUrl + "/message/warning";
		String param = JSON.toJSONString(message.toString());
		GetPostUtil.sendPost(url, param);
//		AsyncGetPostUtil.asyncSendPost(url, param, null);
	}

}
