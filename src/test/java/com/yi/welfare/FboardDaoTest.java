package com.yi.welfare;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.FboardVO;
import com.yi.persistence.FboardDAO;
import com.yi.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FboardDaoTest {
	
	@Autowired
	private FboardDAO dao;
	
	@Test
	public void Test01insertFboard() {
		FboardVO fboard = new FboardVO();
	/*	fboard.setFbno(2);*/
		fboard.setUserid("test2");
		fboard.setFgroup(true);
		fboard.setFtitle("자유 게이시판테스트");
		fboard.setFcontent("테스트중");
		fboard.setFregdate(new Date());
		fboard.setFviewcnt(0);
		fboard.setFreplycnt(0);
		dao.insertFboard(fboard);
	}
	//@Test 
	public void Test02readFboard() {
		System.out.println(dao.readFboard(2));
	}
	//@Test
	public void Test03listAllFboard() {
		List<FboardVO> list = dao.listAllFboard();
		for(FboardVO fboard : list) {
			System.out.println(fboard);
		}
	}
	//@Test
	public void Test04updateFboard() {
		FboardVO vo = new FboardVO();
		vo.setFbno(2);
		vo.setFtitle("월화아 수모옥옥");
		vo.setFcontent("나는 바꾼당");
		dao.updateFboard(vo);
	}
	//@Test
	public void Test05deleteFboard() {
		dao.deleteFboard(2);
	}
}
