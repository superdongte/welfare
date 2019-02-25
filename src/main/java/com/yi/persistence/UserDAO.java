package com.yi.persistence;

import java.util.List;

import com.yi.domain.UserVO;

public interface UserDAO {
	public void insertUser(UserVO vo);
	public UserVO readUser(String userid);
	public List<UserVO> userlistAll();
	public void updateUser(UserVO vo);
	public void deleteUser(String userid);
	public UserVO dulUserid(String userid);
}
