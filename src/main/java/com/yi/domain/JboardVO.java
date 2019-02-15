package com.yi.domain;

import java.util.Date;

public class JboardVO {
	private int jbno;
	private String userid;
	private int ornum;
	private String jtitle;
	private String jcontent;
	private Date jregdate;
	private int jviewcnt;
	public int getJbno() {
		return jbno;
	}
	public void setJbno(int jbno) {
		this.jbno = jbno;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getOrnum() {
		return ornum;
	}
	public void setOrnum(int ornum) {
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
	public int getJviewcnt() {
		return jviewcnt;
	}
	public void setJviewcnt(int jviewcnt) {
		this.jviewcnt = jviewcnt;
	}
	@Override
	public String toString() {
		return "JboardVO [jbno=" + jbno + ", userid=" + userid + ", ornum=" + ornum + ", jtitle=" + jtitle
				+ ", jcontent=" + jcontent + ", jregdate=" + jregdate + ", jviewcnt=" + jviewcnt + "]";
	}
	
	
	
}
