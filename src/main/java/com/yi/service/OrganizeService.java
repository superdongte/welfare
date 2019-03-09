package com.yi.service;

import java.util.List;

import com.yi.domain.OrganizeVO;

public interface OrganizeService {
	public void insertOrganize(OrganizeVO vo);
	public List<OrganizeVO> selectAllOranize();
	public void updateOrganize(OrganizeVO vo);
	public void deleteOraganize(int ornum);
}
