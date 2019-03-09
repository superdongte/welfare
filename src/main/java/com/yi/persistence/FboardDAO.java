package com.yi.persistence;

import java.util.List;

import com.yi.domain.Criteria;
import com.yi.domain.FboardVO;
import com.yi.domain.SearchCriteria;

public interface FboardDAO {
	public void insertFboard(FboardVO fbno);
	public FboardVO readFboard(int fbno);
	public List<FboardVO> listAllFboard();
	public void updateFboard(FboardVO fbno);
	public void deleteFboard(int fbno);
	
	/*페이징처리*/
	public List<FboardVO> listPage(int page);
	public List<FboardVO> listCriteria(Criteria cri);
	
	public void updateReplyCnt(int fbno, int amount);
	
	/*토탈 카운터세기*/
	public int totalCount();
	public List<FboardVO> listSearch(SearchCriteria cri);
	public int searchTotalCount(SearchCriteria cri);
}
