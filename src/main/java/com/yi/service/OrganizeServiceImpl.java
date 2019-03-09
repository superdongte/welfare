package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.OrganizeVO;
import com.yi.persistence.OrganizeDAO;

@Service
public class OrganizeServiceImpl implements OrganizeService {

	@Autowired
	OrganizeDAO dao;
	
	@Override
	public void insertOrganize(OrganizeVO vo) {
		// TODO Auto-generated method stub
		dao.insertOrganize(vo);
	}

	@Override
	public List<OrganizeVO> selectAllOranize() {
		// TODO Auto-generated method stub
		return dao.selectAllOranize();
	}

	@Override
	public void updateOrganize(OrganizeVO vo) {
		// TODO Auto-generated method stub
		dao.updateOrganize(vo);
	}

	@Override
	public void deleteOraganize(int ornum) {
		// TODO Auto-generated method stub
		dao.deleteOraganize(ornum);
	}

}
