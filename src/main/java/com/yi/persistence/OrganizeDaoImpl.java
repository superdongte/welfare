package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.OrganizeVO;

@Repository
public class OrganizeDaoImpl implements OrganizeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.OrganizeMapper";
	
	@Override
	public void insertOrganize(OrganizeVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertOrganize", vo);
	}

	@Override
	public List<OrganizeVO> selectAllOranize() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".selectAllOranize");
	}

	@Override
	public void updateOrganize(OrganizeVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateOrganize", vo);
	}

	@Override
	public void deleteOraganize(int ornum) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteOraganize", ornum);
	}

}
