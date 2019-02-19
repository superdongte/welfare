package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.UserVO;
import com.yi.persistence.UserDAO;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO dao;
	
	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		dao.insertUser(vo);
	}

	@Override
	public UserVO readUser(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> userlistAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dulUserid(UserVO vo) {
		// TODO Auto-generated method stub
		dao.dulUserid(vo);
	}

}
