package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.SboardVO;

@Repository
public class SboardDaoImpl implements SboardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.SboardMapper";
	
	@Override
	public void insertSboard(SboardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace +".insertSboard", vo);
	}

	@Override
	public List<SboardVO> listSboardAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listSboardAll");
	}

	@Override
	public SboardVO readSboard(int sbno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".readSboard", sbno);
	}

	@Override
	public void updateSboard(SboardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateSboard", vo);
	}

	@Override
	public void deleteSboard(int sbno) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteSboard", sbno);
	}

}
