package com.yi.domain;

import java.util.Date;

public class FreplyVO {
	private int frno;
	private int fbno;
	private String frwriter;
	private String frcontent;
	private Date frregdate;
	
	public int getFrno() {
		return frno;
	}
	public void setFrno(int frno) {
		this.frno = frno;
	}
	public int getFbno() {
		return fbno;
	}
	public void setFbno(int fbno) {
		this.fbno = fbno;
	}
	public String getFrwriter() {
		return frwriter;
	}
	public void setFrwriter(String frwriter) {
		this.frwriter = frwriter;
	}
	public String getFrcontent() {
		return frcontent;
	}
	public void setFrcontent(String frcontent) {
		this.frcontent = frcontent;
	}
	
	public Date getFrregdate() {
		return frregdate;
	}
	public void setFrregdate(Date frregdate) {
		this.frregdate = frregdate;
	}
	@Override
	public String toString() {
		return "FreplyVO [frno=" + frno + ", fbno=" + fbno + ", frwriter=" + frwriter + ", frcontent=" + frcontent
				+ ", frregdate=" + frregdate + "]";
	}
	
	
	
}
