package com.yi.domain;

public class VolunteerVO {
	private String vnumber;
	private String vname;
	public String getVnumber() {
		return vnumber;
	}
	public void setVnumber(String vnumber) {
		this.vnumber = vnumber;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	@Override
	public String toString() {
		return "VolunteerVO [vnumber=" + vnumber + ", vname=" + vname + "]";
	}
	
}
