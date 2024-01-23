package com.example.RestApi.angular.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class EmailModel {

	@NotNull(message = "Name Must Not Be Null")
	private String name;

	@NotNull(message = "Message Must Not Be Null")
	private String msg;

	@NotNull(message = "Subject Must Not Be Null")
	private String sub;

	@Email
	@NotNull(message = "Email Address Must Not Be Null")
	private String emailaddr;

	@NotNull(message = "Checker Must Not Be Null")
	private String checker;

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getEmailaddr() {
		return emailaddr;
	}

	public void setEmailaddr(String emailaddr) {
		this.emailaddr = emailaddr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public EmailModel(@NotNull(message = "Name Must Not Be Null") String name,
			@NotNull(message = "Message Must Not Be Null") String msg,
			@NotNull(message = "Subject Must Not Be Null") String sub,
			@Email @NotNull(message = "Email Address Must Not Be Null") String emailaddr,
			@NotNull(message = "Checker Must Not Be Null") String checker) {
		super();
		this.name = name;
		this.msg = msg;
		this.sub = sub;
		this.emailaddr = emailaddr;
		this.checker = checker;
	}

}
