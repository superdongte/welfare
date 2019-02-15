package com.yi.persistence;

import java.util.List;

import com.yi.domain.OrganizeVO;

public interface OrganizeDAO {
	public void insertOrganize(OrganizeVO vo);
	public List<OrganizeVO> selectAllOranize();
	public void updateOrganize(OrganizeVO vo);
	public void deleteOraganize(int ornum);
}
