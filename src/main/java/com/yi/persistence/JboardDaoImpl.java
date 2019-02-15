package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.JboardVO;

@Repository
public class JboardDaoImpl implements JboardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.JboardMapper";
	
	@Override
	public void insertJboard(JboardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertJboard", vo);
	}

	@Override
	public List<JboardVO> listAllJboard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listAllJboard");
	}

	@Override
	public JboardVO readJboard(int jbno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".readJboard", jbno);
	}

	@Override
	public void updateJboard(JboardVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateJboard", vo);
	}

	@Override
	public void deleteJboard(int jbno) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteJboard", jbno);
	}

}
