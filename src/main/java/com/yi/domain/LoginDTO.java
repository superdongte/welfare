package com.yi.domain;

public class LoginDTO {
	private String userid;
	private String username;
	//관리자인지아닌지
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [userid=" + userid + ", username=" + username + "]";
	}
	
	
}
