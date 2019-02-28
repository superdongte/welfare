package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.SupportVO;
import com.yi.persistence.SupportDAO;

@Service
public class SupportServiceImpl implements SupportService {
	
	@Autowired
	SupportDAO dao;
	
	@Override
	public void insertVolunteer(SupportVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertMoney(SupportVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SupportVO> SupportVol() {
		// TODO Auto-generated method stub
		return dao.SupportVol();
	}

	@Override
	public List<SupportVO> SupportMoney() {
		// TODO Auto-generated method stub
		return dao.SupportMoney();
	}

}
