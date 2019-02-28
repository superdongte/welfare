package com.yi.service;

import java.util.List;

import com.yi.domain.SupportVO;

public interface SupportService {
	public void insertVolunteer(SupportVO vo);
	public void insertMoney(SupportVO vo);
	public List<SupportVO> SupportVol();
	public List<SupportVO> SupportMoney();
}
