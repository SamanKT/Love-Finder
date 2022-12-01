package com.saman.cl.api;

import javax.validation.constraints.NotBlank;

public class FeedbackDTO {

	@NotBlank(message = "should have a value")
	private String name;
	@NotBlank(message = "should have a value")
	private String lastName;
	@NotBlank(message = "should have a value")
	private String body;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
