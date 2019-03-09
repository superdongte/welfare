package com.yi.domain;

import java.util.Date;
import java.util.List;

public class SboardVO {
	private int sbno;
	private int vnumber;
	private String vname;
	private String userid;
	private String stitle;
	private String scontent;
	private Date sregdate;
	private int sviewcnt;
	private List<String> files;
	
	public int getSbno() {
		return sbno;
	}
	public void setSbno(int sbno) {
		this.sbno = sbno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
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
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public int getVnumber() {
		return vnumber;
	}
	public void setVnumber(int vnumber) {
		this.vnumber = vnumber;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public List<String> getFiles() {
		return files;
	}
	public void setFiles(List<String> files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "SboardVO [sbno=" + sbno + ", vnumber=" + vnumber + ", vname=" + vname + ", userid=" + userid
				+ ", stitle=" + stitle + ", scontent=" + scontent + ", sregdate=" + sregdate + ", sviewcnt=" + sviewcnt
				+ ", files=" + files + "]";
	}
	
	
	
	
}
