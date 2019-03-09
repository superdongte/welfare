package com.yi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;
import com.yi.domain.SupportVO;
import com.yi.domain.UserVO;
@Repository
public class UserDaoImpl implements UserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.UserMapper";
	
	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertUser", vo); 
	}

	@Override
	public UserVO readUser(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace +".readUser", userid);
	}

	@Override
	public List<UserVO> userlistAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".userlistAll");
	}

	@Override
	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateUser", vo);
	}

	@Override
	public void deleteUser(String userid) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteUser", userid);
	}

	@Override
	public UserVO dulUserid(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".dulUserid", userid);
	}

	@Override
	public UserVO read(String userid, String userpw) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		return sqlSession.selectOne(namespace + ".read", map);
	}

	@Override
	public List<UserVO> listPage(int page) {
		// TODO Auto-generated method stub
		if(page < 0) {
			page = 1;
		}
		page = (page-1) * 10;
		return sqlSession.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<UserVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public List<UserVO> listSearch(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchTotalCount", cri);
	}

}
