package com.thinvent.message.entity;

import com.thinvent.library.util.UUIDUtil;

public class Message {
	private String uuid;
	private String msg;

	public Message() {
		this.uuid = UUIDUtil.getUuid();
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message [uuid=" + uuid + ", msg=" + msg + "]";
	}

}
