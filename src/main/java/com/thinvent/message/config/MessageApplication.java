package com.thinvent.message.config;

import com.thinvent.library.config.ApplicationConfig;

public class MessageApplication extends ApplicationConfig {
	public MessageApplication() {
		moduleList.add("message.spring");
		moduleList.add("message.logging");
		moduleList.add("message.server");
		moduleList.add("message.basic");
	}
}
