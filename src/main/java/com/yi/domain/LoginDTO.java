package com.yi.domain;

public class LoginDTO {
	private String userid;
	private String username;
	private boolean admin;
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
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "LoginDTO [userid=" + userid + ", username=" + username + ", admin=" + admin + "]";
	}
	
	
	
}
