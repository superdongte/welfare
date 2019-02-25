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
		return dao.readUser(userid);
	}

	@Override
	public List<UserVO> userlistAll() {
		// TODO Auto-generated method stub
		return dao.userlistAll();
	}

	@Override
	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub
		dao.updateUser(vo);
	}

	@Override
	public void deleteUser(String userid) {
		// TODO Auto-generated method stub
		dao.deleteUser(userid);
	}

	@Override
	public boolean dulUserid(String vo) {
		// TODO Auto-generated method stub
		try {
				UserVO user = dao.dulUserid(vo);
				if(user == null) {
					return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return false;	
	}
		
		
}
