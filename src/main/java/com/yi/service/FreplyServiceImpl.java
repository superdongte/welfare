package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.yi.domain.Criteria;
import com.yi.domain.FreplyVO;
import com.yi.persistence.FboardDAO;
import com.yi.persistence.FreplyDAO;
@Controller
public class FreplyServiceImpl implements FreplyService {

	@Autowired
	private FreplyDAO dao;
	
	@Autowired
	private FboardDAO fdao;

	@Override
	@Transactional
	public void insertFreply(FreplyVO frno) {
		// TODO Auto-generated method stub
		dao.insertFreply(frno);
		fdao.updateReplyCnt(frno.getFbno(), 1);
	}

	@Override
	public List<FreplyVO> listAllFreply(int fbno) {
		// TODO Auto-generated method stub
		return dao.listAllFreply(fbno);
	}

	@Override
	public void updateFreply(FreplyVO frno) {
		// TODO Auto-generated method stub
		dao.updateFreply(frno);
	}

	@Override
	public void deleteFreply(int frno) {
		// TODO Auto-generated method stub
		FreplyVO vo = dao.selectByFrno(frno);
		dao.deleteFreply(frno);
		fdao.updateReplyCnt(vo.getFbno(), -1);
	}

	@Override
	public List<FreplyVO> listPage(Criteria cri, int fbno) {
		// TODO Auto-generated method stub
		return dao.listPage(cri, fbno);
	}

	@Override
	public int totalCount(int fbno) {
		// TODO Auto-generated method stub
		return dao.totalCount(fbno);
	}

	@Override
	public FreplyVO selectBFrno(int fbno) {
		// TODO Auto-generated method stub
		return dao.selectByFrno(fbno);
	}
	
	
	

}
