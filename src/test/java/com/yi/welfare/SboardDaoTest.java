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

import com.yi.domain.SboardVO;
import com.yi.persistence.SboardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SboardDaoTest {
	
	@Autowired
	private SboardDAO dao;
	
	//@Test
	public void Test01insertSboard() {
		SboardVO vo = new SboardVO();
		vo.setUserid("test1");
		vo.setStitle("살려주세여");
		vo.setScontent("sos에 연락해주세여");
		vo.setSregdate(new Date());
		vo.setSviewcnt(0);
		dao.insertSboard(vo);
	}
	
	@Test
	public void Test02listSboardAll() {
		List<SboardVO> list =dao.listSboardAll();
		
		for(SboardVO sboard : list) {
			System.out.println(sboard);
		}
	}
	@Test
	public void Test03readSboard() {
		System.out.println(dao.readSboard(2));
	}
	//@Test
	public void Test04updateSboard() {
		SboardVO vo = new SboardVO();
		vo.setSbno(2);
		vo.setStitle("악 잡힘");
		vo.setScontent("주인님 채찍질만은..");
		dao.updateSboard(vo);
	}
	@Test
	public void Test05deleteSboard() {
		dao.deleteSboard(2);
	}
}
