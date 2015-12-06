package com.saoraozhe.mybatis.entity;

import java.util.List;

public class MessageType {
	
	private int tid;
	private String tname;
	//一对多关系中，一方实体类有一个成员是多方实体对象的集合
	private List<Message> messages;
	
	public MessageType() {
	}

	public MessageType(String tname) {
		this.tname = tname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "Type [tid=" + tid + ", tname=" + tname + "]";
	}
	
}
