package com.yi.persistence;

import java.util.List;

import com.yi.domain.SupportVO;

public interface SupportDAO {
	public void insertVolunteer(SupportVO vo);
	public void insertMoney(SupportVO vo);
	public List<SupportVO> listSupport();
	public List<SupportVO> SupportVol();
	public List<SupportVO> SupportMoney();
}
