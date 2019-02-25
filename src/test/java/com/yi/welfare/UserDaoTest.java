package com.yi.welfare;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.UserVO;
import com.yi.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest {
	
	@Autowired
	private UserDAO dao;
	
	//@Test
	public void Test01insertUser() {
		UserVO vo = new UserVO();
		vo.setUserid("test21");
		vo.setUserpw("1234");
		vo.setUsername("김동준");
		vo.setTel("010-2032-1234");
		vo.setBirth("951012");
		vo.setEmail("supemdm@naver.com");
		vo.setAdmin(true);
		dao.insertUser(vo);
	}
	//@Test
	public void Test02readUser() {
		System.out.println(dao.readUser("test21"));
	}
	//@Test
	public void Test03userlistAll() {
		List<UserVO> list = dao.userlistAll();
		for(UserVO user: list) {
			System.out.println(user);
		}
	}
	//@Test
	public void Test04updateUser() {
		UserVO vo = new UserVO();
		vo.setUserid("test21");
		vo.setUserpw("3456");
		vo.setUsername("모달씨");
		vo.setTel("111-1234-1542");
		vo.setEmail("test201@daum.net");
		dao.updateUser(vo);
	}
	//@Test
	public void Test05deleteUser() {
		dao.deleteUser("test21");
	}
	@Test
	public void Test06dulUserid() {
		System.out.println(dao.dulUserid("user00"));
	}
}
