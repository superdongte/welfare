package com.yi.domain;

public class SupportVO {
	private UserVO userid;
	private VolunteerVO vnumber;
	private boolean vgroup;
	private String vtime;
	private String carrer;
	private String vreason;
	private String dgroup;
	private int dmoney;
	private String dmode;
	public UserVO getUserid() {
		return userid;
	}
	public void setUserid(UserVO userid) {
		this.userid = userid;
	}
	public VolunteerVO getVnumber() {
		return vnumber;
	}
	public void setVnumber(VolunteerVO vnumber) {
		this.vnumber = vnumber;
	}
	public boolean isVgroup() {
		return vgroup;
	}
	public void setVgroup(boolean vgroup) {
		this.vgroup = vgroup;
	}
	public String getVtime() {
		return vtime;
	}
	public void setVtime(String vtime) {
		this.vtime = vtime;
	}
	public String getCarrer() {
		return carrer;
	}
	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}
	public String getVreason() {
		return vreason;
	}
	public void setVreason(String vreason) {
		this.vreason = vreason;
	}
	public String getDgroup() {
		return dgroup;
	}
	public void setDgroup(String dgroup) {
		this.dgroup = dgroup;
	}
	public int getDmoney() {
		return dmoney;
	}
	public void setDmoney(int dmoney) {
		this.dmoney = dmoney;
	}
	public String getDmode() {
		return dmode;
	}
	public void setDmode(String dmode) {
		this.dmode = dmode;
	}
	@Override
	public String toString() {
		return "SupportVO [userid=" + userid + ", vnumber=" + vnumber + ", vgroup=" + vgroup + ", vtime=" + vtime
				+ ", carrer=" + carrer + ", vreason=" + vreason + ", dgroup=" + dgroup + ", dmoney=" + dmoney
				+ ", dmode=" + dmode + "]";
	}
	
	
}
