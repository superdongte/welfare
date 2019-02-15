package com.yi.persistence;

import java.util.List;

import com.yi.domain.VolunteerVO;

public interface VolunteerDAO {
	public void insertVol(VolunteerVO vo);
	public List<VolunteerVO> listAllVol();
	public void updateVol(VolunteerVO vo);
	public void deleteVol(int vnumber);
}
