package com.saoraozhe.mybatis.entity;

public class Message {
	
	private int mid;
	private String content;
	private int tid;
	//多对一关联关系中，多方有一个成员是多方实体对象
	private MessageType type;
	
	public Message() {
	}

	public Message(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public int getMid() {
		return mid;
	}

	@Override
	public String toString() {
		return "Message [id=" + mid + ", content=" + content + "]";
	}
	
}
