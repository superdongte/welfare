package com.yi.domain;

import java.util.Date;

public class FboardVO {
	private int fbno;
	private String userid;
	private boolean fgroup;
	private String ftitle;
	private String fcontent;
	private Date fregdate;
	private int fviewcnt;
	private int freplycnt;
	
	public int getFbno() {
		return fbno;
	}
	public void setFbno(int fbno) {
		this.fbno = fbno;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public boolean isFgroup() {
		return fgroup;
	}
	public void setFgroup(boolean fgroup) {
		this.fgroup = fgroup;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public Date getFregdate() {
		return fregdate;
	}
	public void setFregdate(Date fregdate) {
		this.fregdate = fregdate;
	}
	public int getFviewcnt() {
		return fviewcnt;
	}
	public void setFviewcnt(int fviewcnt) {
		this.fviewcnt = fviewcnt;
	}
	public int getFreplycnt() {
		return freplycnt;
	}
	public void setFreplycnt(int freplycnt) {
		this.freplycnt = freplycnt;
	}
	@Override
	public String toString() {
		return "Fboard [fbno=" + fbno + ", userid=" + userid + ", fgroup=" + fgroup + ", ftitle=" + ftitle
				+ ", fcontent=" + fcontent + ", fregdate=" + fregdate + ", fviewcnt=" + fviewcnt + ", freplycnt="
				+ freplycnt + "]";
	}
	
	
	
}
