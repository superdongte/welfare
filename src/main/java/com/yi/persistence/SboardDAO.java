package com.yi.persistence;

import java.util.List;

import com.yi.domain.Criteria;
import com.yi.domain.SboardVO;
import com.yi.domain.SearchCriteria;

public interface SboardDAO {
	public void insertSboard(SboardVO vo);
	public List<SboardVO> listSboardAll();
	public SboardVO readSboard(int sbno);
	public void updateSboard(SboardVO vo);
	public void deleteSboard(int sbno);
	
	public List<SboardVO> listPage(int page);
	public List<SboardVO> listCriteria(Criteria cri);
	
	public int totalCount();
	public List<SboardVO> listSearch(SearchCriteria cri);
	public int searchTotalCount(SearchCriteria cri);
	
	/*파일업로드 인터페이스*/
	public void insertSattach(String spname);
	public List<String> getSattach(int sbno);
	
	public void delSattach(int sbno);	
	public void deleteAttachByFullName(int sbno, String spname);
	public void insertSattachBySbno(String sname, int sbno);
}
