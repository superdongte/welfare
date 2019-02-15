package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.FboardVO;
@Repository
public class FboardDaoImpl implements FboardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.FboardMapper";
	
	@Override
	public void insertFboard(FboardVO fbno) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertFboard", fbno);
	}

	@Override
	public FboardVO readFboard(int fbno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace +".readFboard", fbno);
	}

	@Override
	public List<FboardVO> listAllFboard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listAllFboard");
	}

	@Override
	public void updateFboard(FboardVO fbno) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace +".updateFboard", fbno);
	}

	@Override
	public void deleteFboard(int fbno) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace +".deleteFboard", fbno);
	}

}
