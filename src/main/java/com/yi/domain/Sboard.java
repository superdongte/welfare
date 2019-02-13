package com.yi.domain;

import java.util.Date;

public class Sboard {
	private int sbno;
	private UserVO userid;
	private String stitle;
	private String scontext;
	private Date sregdate;
	private int sviewcnt;
	public int getSbno() {
		return sbno;
	}
	public void setSbno(int sbno) {
		this.sbno = sbno;
	}
	public UserVO getUserid() {
		return userid;
	}
	public void setUserid(UserVO userid) {
		this.userid = userid;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getScontext() {
		return scontext;
	}
	public void setScontext(String scontext) {
		this.scontext = scontext;
	}
	public Date getSregdate() {
		return sregdate;
	}
	public void setSregdate(Date sregdate) {
		this.sregdate = sregdate;
	}
	public int getSviewcnt() {
		return sviewcnt;
	}
	public void setSviewcnt(int sviewcnt) {
		this.sviewcnt = sviewcnt;
	}
	@Override
	public String toString() {
		return "Sboard [sbno=" + sbno + ", userid=" + userid + ", stitle=" + stitle + ", scontext=" + scontext
				+ ", sregdate=" + sregdate + ", sviewcnt=" + sviewcnt + "]";
	}
	
	
}
