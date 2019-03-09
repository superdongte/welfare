package com.yi.service;

import java.util.List;

import com.yi.domain.Criteria;
import com.yi.domain.FreplyVO;

public interface FreplyService {
	public void insertFreply(FreplyVO frno);
	public List<FreplyVO> listAllFreply(int fbno);
	public void updateFreply(FreplyVO frno);
	public void deleteFreply(int frno);
	
	/*페이징 처리함*/
	public List<FreplyVO> listPage(Criteria cri, int fbno);
	public int totalCount(int fbno);
	public FreplyVO selectBFrno(int fbno);
}
