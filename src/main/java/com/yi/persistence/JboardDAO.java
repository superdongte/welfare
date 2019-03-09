package com.yi.persistence;

import java.util.List;

import com.yi.domain.Criteria;
import com.yi.domain.JboardVO;
import com.yi.domain.SearchCriteria;

public interface JboardDAO {
	public void insertJboard(JboardVO vo);
	public List<JboardVO> listAllJboard();
	public JboardVO readJboard(int jbno);
	public void updateJboard(JboardVO vo);
	public void deleteJboard(int jbno);
	
	public List<JboardVO> listPage(int page);
	public List<JboardVO> listCriteria(Criteria cri);
	
	public int totalCount();
	public List<JboardVO> listSearch(SearchCriteria cri);
	public int searchTotalCount(SearchCriteria cri);
}
