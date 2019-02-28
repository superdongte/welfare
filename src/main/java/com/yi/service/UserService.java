package com.yi.service;

import java.util.List;

import com.yi.domain.UserVO;

public interface UserService {
	public void insertUser(UserVO vo);
	public UserVO readUser(String userid);
	public List<UserVO> userlistAll();
	public void updateUser(UserVO vo);
	public void deleteUser(String userid);
	public boolean dulUserid(String vo);
	
	//로그인 서비스으
	public UserVO read(String userid, String userpw);
}
