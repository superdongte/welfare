package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.Criteria;
import com.yi.domain.JboardVO;
import com.yi.domain.SearchCriteria;
import com.yi.domain.SupportVO;
import com.yi.persistence.SupportDAO;

@Service
public class SupportServiceImpl implements SupportService {
	
	@Autowired
	SupportDAO dao;
	
	@Override
	public void insertVolunteer(SupportVO vo) {
		// TODO Auto-generated method stub
		dao.insertVolunteer(vo);
	}

	@Override
	public void insertMoney(SupportVO vo) {
		// TODO Auto-generated method stub
		dao.insertMoney(vo);
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

	@Override
	public List<SupportVO> listPage(int page) {
		// TODO Auto-generated method stub
		return dao.listPage(page);
	}

	@Override
	public List<SupportVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public List<SupportVO> listSearch(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.searchTotalCount(cri);
	}

	@Override
	public List<SupportVO> listMoney(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listMoney(cri);
	}

	@Override
	public int searchVolTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.searchVolTotalCount(cri);
	}

}
