package com.zen.smi.bo;

public class MessagesBO implements java.io.Serializable {

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTextEn() {
		return textEn;
	}

	public void setTextEn(String textEn) {
		this.textEn = textEn;
	}

	private Integer messageId;
	private String name;
	private String type;
	private String code;
	private String textEn;

	public MessagesBO() {
	}

	public MessagesBO(String name, String type, String code, String textEn) {
		this.name = name;
		this.type = type;
		this.code = code;
		this.textEn = textEn;
	}

	

}
