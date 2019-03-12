package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Criteria;
import com.yi.domain.JboardVO;
import com.yi.domain.SearchCriteria;
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

	@Override
	public List<SupportVO> SupportVol() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".SupportVol");
	}

	@Override
	public List<SupportVO> SupportMoney() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".SupportMoney");
	}

	@Override
	public List<SupportVO> listPage(int page) {
		// TODO Auto-generated method stub
		if(page < 0) {
			page = 1;
		}
		page = (page-1) * 10;
		return sqlSession.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<SupportVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listCriteria", cri );
	}

	@Override
	public List<SupportVO> listSearch(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchTotalCount", cri);
	}

	@Override
	public List<SupportVO> listMoney(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listMoney", cri);
	}

	@Override
	public int searchVolTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchVolTotalCount", cri);
	}

}
