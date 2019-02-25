package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
