package com.yi.persistence;

import java.util.List;

import com.yi.domain.SboardVO;

public interface SboardDAO {
	public void insertSboard(SboardVO vo);
	public List<SboardVO> listSboardAll();
	public SboardVO readSboard(int sbno);
	public void updateSboard(SboardVO vo);
	public void deleteSboard(int sbno);
}
