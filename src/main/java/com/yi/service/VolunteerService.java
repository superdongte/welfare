package com.yi.service;

import java.util.List;

import com.yi.domain.VolunteerVO;

public interface VolunteerService {
	public void insertVol(VolunteerVO vo);
	public List<VolunteerVO> listAllVol();
	public void updateVol(VolunteerVO vo);
	public void deleteVol(int vnumber);
}
