package com.yi.persistence;

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
	public void insertSupport(SupportVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertSupport", vo);
	}

}
