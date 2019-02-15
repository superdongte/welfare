package com.yi.persistence;

import java.util.List;

import com.yi.domain.FreplyVO;

public interface FreplyDAO {
	public void insertFreply(FreplyVO frno);
	public List<FreplyVO> listAllFreply();
	public void updateFreply(FreplyVO frno);
	public void deleteFreply(int frno);
}
