package com.yi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Criteria;
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
	public List<FreplyVO> listAllFreply(int frno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".listAllFreply",frno);
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

	@Override
	public List<FreplyVO> listPage(Criteria cri, int fbno) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("fbno", fbno);
		map.put("cri", cri);
		return sqlSession.selectList(namespace + ".listPage", map);
	}

	@Override
	public int totalCount(int fbno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".totalCount", fbno);
	}

	@Override
	public FreplyVO selectByFrno(int fbno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectByFrno", fbno);
	}

	

}
