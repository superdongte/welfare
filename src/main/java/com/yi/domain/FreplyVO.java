package com.yi.domain;

public class FreplyVO {
	private int frno;
	private FboardVO fbno;
	private String frwriter;
	private String frcontent;
	private String frregdate;
	public int getFrno() {
		return frno;
	}
	public void setFrno(int frno) {
		this.frno = frno;
	}
	public FboardVO getFbno() {
		return fbno;
	}
	public void setFbno(FboardVO fbno) {
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
	public String getFrregdate() {
		return frregdate;
	}
	public void setFrregdate(String frregdate) {
		this.frregdate = frregdate;
	}
	@Override
	public String toString() {
		return "Freply [frno=" + frno + ", fbno=" + fbno + ", frwriter=" + frwriter + ", frcontent=" + frcontent
				+ ", frregdate=" + frregdate + "]";
	}
	
	
}
