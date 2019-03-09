package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Criteria;
import com.yi.domain.JboardVO;
import com.yi.domain.SearchCriteria;

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

	@Override
	public List<JboardVO> listPage(int page) {
		// TODO Auto-generated method stub
		if(page < 0) {
			page = 1;
		}
		page = (page-1) * 10;
		return sqlSession.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<JboardVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".totalCount");
	}

	@Override
	public List<JboardVO> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchTotalCount", cri);
	}

}
