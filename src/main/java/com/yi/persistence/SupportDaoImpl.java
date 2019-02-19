package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.SupportVO;

@Repository
public class SupportDaoImpl implements SupportDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.SupportMapper";
	
	@Override
	public void insertVolunteer(SupportVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertVolunteer", vo);
	}

	@Override
	public void insertMoney(SupportVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertMoney", vo);
	}

	@Override
	public List<SupportVO> listSupport() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".listSupport");
	}

	

}
