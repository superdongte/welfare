package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.VolunteerVO;

@Repository
public class VolunterrDaoImpl implements VolunteerDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.VolunteerMapper";

	@Override
	public void insertVol(VolunteerVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertVol", vo);
	}

	@Override
	public List<VolunteerVO> listAllVol() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listAllVol");
	}

	@Override
	public void updateVol(VolunteerVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace +".updateVol", vo);
	}

	@Override
	public void deleteVol(int vnumber) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteVol", vnumber);
	}
	
	

}
