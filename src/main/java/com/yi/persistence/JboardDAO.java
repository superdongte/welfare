package com.yi.persistence;

import java.util.List;

import com.yi.domain.JboardVO;

public interface JboardDAO {
	public void insertJboard(JboardVO vo);
	public List<JboardVO> listAllJboard();
	public JboardVO readJboard(int jbno);
	public void updateJboard(JboardVO vo);
	public void deleteJboard(int jbno);
}
