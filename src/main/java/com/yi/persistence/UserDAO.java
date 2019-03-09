package com.yi.persistence;

import java.util.List;

import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;
import com.yi.domain.SupportVO;
import com.yi.domain.UserVO;

public interface UserDAO {
	public void insertUser(UserVO vo);
	public UserVO readUser(String userid);
	public List<UserVO> userlistAll();
	public void updateUser(UserVO vo);
	public void deleteUser(String userid);
	public UserVO dulUserid(String userid);
	
	//로그인 서비스으
	public UserVO read(String userid, String userpw);
	
	//페이징 처리
	public List<UserVO> listPage(int page);
	public List<UserVO> listCriteria(Criteria cri);
	public List<UserVO> listSearch(Criteria cri);
	public int searchTotalCount(SearchCriteria cri);
}
