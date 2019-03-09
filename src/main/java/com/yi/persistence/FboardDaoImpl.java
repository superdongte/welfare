package com.yi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Criteria;
import com.yi.domain.FboardVO;
import com.yi.domain.SearchCriteria;
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

	@Override
	public List<FboardVO> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public List<FboardVO> listPage(int page) {
		// TODO Auto-generated method stub
		if(page < 0) {
			page = 1;
		}
		page = (page-1) * 10;
		return sqlSession.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<FboardVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".listCriteria", cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".totalCount");
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace +".searchTotalCount", cri);
	}

	@Override
	public void updateReplyCnt(int fbno, int amount) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("fbno", fbno);
		map.put("amount", amount);
		sqlSession.update(namespace + ".updateReplyCnt", map);
	}

}
