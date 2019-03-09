package com.yi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Criteria;
import com.yi.domain.SboardVO;
import com.yi.domain.SearchCriteria;

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

	@Override
	public List<SboardVO> listPage(int page) {
		// TODO Auto-generated method stub
		if(page < 0) {
			page = 1;
		}
		page = (page-1) * 10;
		return sqlSession.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<SboardVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".totalCount");
	}

	@Override
	public List<SboardVO> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchTotalCount", cri);
	}

	@Override
	public void insertSattach(String spname) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertSattach", spname);
	}

	@Override
	public List<String> getSattach(int sbno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getSattach", sbno);
	}

	@Override
	public void delSattach(int sbno) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delSattach", sbno);
	}

	@Override
	public void deleteAttachByFullName(int sbno, String spname) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("sbno", sbno);
		map.put("spname", spname);
		sqlSession.delete(namespace +".deleteAttachByFullName", map);
	}

	@Override
	public void insertSattachBySbno(String spname, int sbno) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("spname", spname);
		map.put("sbno", sbno);
		sqlSession.insert(namespace +".insertSattachBySbno", map);
	}

}
