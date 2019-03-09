package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.Criteria;
import com.yi.domain.FboardVO;
import com.yi.domain.SearchCriteria;
import com.yi.persistence.FboardDAO;

@Service
public class FboardServiceImpl implements FboardService {
	
	@Autowired
	FboardDAO dao;
	
	@Override
	public void insertFboard(FboardVO fbno) {
		// TODO Auto-generated method stub
		dao.insertFboard(fbno);
	}

	@Override
	public FboardVO readFboard(int fbno) {
		// TODO Auto-generated method stub
		return dao.readFboard(fbno);
	}

	@Override
	public List<FboardVO> listAllFboard() {
		// TODO Auto-generated method stub
		return dao.listAllFboard();
	}

	@Override
	public void updateFboard(FboardVO fbno) {
		// TODO Auto-generated method stub
		dao.updateFboard(fbno);
	}

	@Override
	public void deleteFboard(int fbno) {
		// TODO Auto-generated method stub
		dao.deleteFboard(fbno);
	}

	@Override
	public List<FboardVO> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public List<FboardVO> listPage(int page) {
		// TODO Auto-generated method stub
		return dao.listPage(page);
	}

	@Override
	public List<FboardVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.searchTotalCount(cri);
	}


}
