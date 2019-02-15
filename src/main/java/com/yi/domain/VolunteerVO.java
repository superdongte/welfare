package com.yi.domain;

public class VolunteerVO {
	private int vnumber;
	private String vname;
	
	
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
	@Override
	public String toString() {
		return "VolunteerVO [vnumber=" + vnumber + ", vname=" + vname + "]";
	}
	
}
