package com.yi.persistence;

import java.util.List;

import com.yi.domain.FboardVO;

public interface FboardDAO {
	public void insertFboard(FboardVO fbno);
	public FboardVO readFboard(int fbno);
	public List<FboardVO> listAllFboard();
	public void updateFboard(FboardVO fbno);
	public void deleteFboard(int fbno);
}
