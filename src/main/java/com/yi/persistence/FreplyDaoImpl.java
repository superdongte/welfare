package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.FboardVO;
import com.yi.domain.FreplyVO;

@Repository
public class FreplyDaoImpl implements FreplyDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.FrnoMapper";
	
	@Override
	public void insertFreply(FreplyVO frno) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertFreply", frno);
	}

	@Override
	public List<FreplyVO> listAllFreply() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".listAllFreply");
	}

	@Override
	public void updateFreply(FreplyVO frno) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace +".updateFreply", frno);
	}

	@Override
	public void deleteFreply(int frno) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace +".deleteFreply", frno);
	}

	

}
