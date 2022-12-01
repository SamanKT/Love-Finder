package com.saman.cl.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoveCalculatorDTO {

	
	@NotBlank(message = "* the field can not be blank")
	@Size(max = 15, min = 3, message = "{size.invalid}")  // using properties file
	private String userName;
	
	@NotBlank(message = "* the field can not be blank")
	@Size(max = 15, min = 3, message = "* chars interval between 3 and 15")
	private String crushName;
	
	@AssertTrue(message = "* you have to agree to continue")
	private boolean confirm;
	
	private String result;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	public boolean isConfirm() {
		return confirm;
	}
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
}
