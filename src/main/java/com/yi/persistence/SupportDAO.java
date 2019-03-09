package com.yi.persistence;

import java.util.List;

import com.yi.domain.Criteria;
import com.yi.domain.JboardVO;
import com.yi.domain.SearchCriteria;
import com.yi.domain.SupportVO;

public interface SupportDAO {
	public void insertVolunteer(SupportVO vo);
	public void insertMoney(SupportVO vo);
	public List<SupportVO> listSupport();
	public List<SupportVO> SupportVol();
	public List<SupportVO> SupportMoney();
	
	public List<SupportVO> listPage(int page);
	public List<SupportVO> listCriteria(Criteria cri);
	public List<SupportVO> listSearch(Criteria cri);
	public List<SupportVO> listMoney(Criteria cri);
	public int searchTotalCount(SearchCriteria cri);
}
