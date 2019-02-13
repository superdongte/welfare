package com.yi.domain;

import java.util.Date;

public class Jboard {
	private int jbno;
	private UserVO userid;
	private Organize ornum;
	private String jtitle;
	private String jcontent;
	private Date jregdate;
	public int getJbno() {
		return jbno;
	}
	public void setJbno(int jbno) {
		this.jbno = jbno;
	}
	public UserVO getUserid() {
		return userid;
	}
	public void setUserid(UserVO userid) {
		this.userid = userid;
	}
	public Organize getOrnum() {
		return ornum;
	}
	public void setOrnum(Organize ornum) {
		this.ornum = ornum;
	}
	public String getJtitle() {
		return jtitle;
	}
	public void setJtitle(String jtitle) {
		this.jtitle = jtitle;
	}
	public String getJcontent() {
		return jcontent;
	}
	public void setJcontent(String jcontent) {
		this.jcontent = jcontent;
	}
	public Date getJregdate() {
		return jregdate;
	}
	public void setJregdate(Date jregdate) {
		this.jregdate = jregdate;
	}
	@Override
	public String toString() {
		return "Jboard [jbno=" + jbno + ", userid=" + userid + ", ornum=" + ornum + ", jtitle=" + jtitle + ", jcontent="
				+ jcontent + ", jregdate=" + jregdate + "]";
	}
	
	
}
