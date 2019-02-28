package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.VolunteerVO;
import com.yi.persistence.VolunteerDAO;

@Service
public class VolunteerServiceImpl implements VolunteerService {
	
	@Autowired
	VolunteerDAO dao;
	
	@Override
	public void insertVol(VolunteerVO vo) {
		// TODO Auto-generated method stub
		dao.insertVol(vo);
	}

	@Override
	public List<VolunteerVO> listAllVol() {
		// TODO Auto-generated method stub
		return dao.listAllVol();
	}

	@Override
	public void updateVol(VolunteerVO vo) {
		// TODO Auto-generated method stub
		dao.updateVol(vo);
	}

	@Override
	public void deleteVol(int vnumber) {
		// TODO Auto-generated method stub
		dao.deleteVol(vnumber);
	}

}
