package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.Criteria;
import com.yi.domain.JboardVO;
import com.yi.domain.SearchCriteria;
import com.yi.persistence.JboardDAO;
@Service
public class JboardServiceImpl implements JboardService {
	
	@Autowired
	private JboardDAO dao;
	
	@Override
	public void insertJboard(JboardVO vo) {
		// TODO Auto-generated method stub
		dao.insertJboard(vo);
	}

	@Override
	public List<JboardVO> listAllJboard() {
		// TODO Auto-generated method stub
		return dao.listAllJboard();
	}

	@Override
	public JboardVO readJboard(int jbno) {
		// TODO Auto-generated method stub
		return dao.readJboard(jbno);
	}

	@Override
	public void updateJboard(JboardVO vo) {
		// TODO Auto-generated method stub
		dao.updateJboard(vo);
	}

	@Override
	public void deleteJboard(int jbno) {
		// TODO Auto-generated method stub
		dao.deleteJboard(jbno);
	}

	@Override
	public List<JboardVO> listPage(int page) {
		// TODO Auto-generated method stub
		return dao.listPage(page);
	}

	@Override
	public List<JboardVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}

	@Override
	public List<JboardVO> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.searchTotalCount(cri);
	}

}
