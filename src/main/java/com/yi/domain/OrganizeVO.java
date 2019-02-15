package com.yi.domain;

public class OrganizeVO {
	private int ornum;
	private String orname;
	public int getOrnum() {
		return ornum;
	}
	public void setOrnum(int ornum) {
		this.ornum = ornum;
	}
	public String getOrname() {
		return orname;
	}
	public void setOrname(String orname) {
		this.orname = orname;
	}
	@Override
	public String toString() {
		return "Organize [ornum=" + ornum + ", orname=" + orname + "]";
	}
	
	
}
