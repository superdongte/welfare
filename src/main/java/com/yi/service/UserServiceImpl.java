package com.yi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;
import com.yi.domain.SupportVO;
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

	@Override
	public UserVO read(String userid, String userpw) {
		// TODO Auto-generated method stub
		return dao.read(userid, userpw);
	}

	@Override
	public List<UserVO> listPage(int page) {
		// TODO Auto-generated method stub
		return dao.listPage(page);
	}

	@Override
	public List<UserVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public List<UserVO> listSearch(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.searchTotalCount(cri);
	}
		
		
}
