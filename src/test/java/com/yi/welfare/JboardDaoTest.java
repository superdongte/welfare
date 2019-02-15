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

import com.yi.domain.JboardVO;
import com.yi.persistence.JboardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JboardDaoTest {
	
	@Autowired
	private JboardDAO dao;
	
	//@Test
	public void Test01insertJboard() {
		JboardVO vo = new JboardVO();
		vo.setUserid("test1");
		vo.setOrnum(1);
		vo.setJtitle("목화밭 노예구함");
		vo.setJcontent("님들 집에 못감 영원히");
		vo.setJregdate(new Date());
		vo.setJviewcnt(0);
		dao.insertJboard(vo);
	}
	@Test
	public void Test02listAllJboard() {
		List<JboardVO> list = dao.listAllJboard();
		for(JboardVO jboard : list) {
			System.out.println(jboard);
		}	
	}
	@Test
	public void Test03readJboard() {
		System.out.println(dao.readJboard(2));
	}
	//@Test
	public void Test04updateJboard() {
		JboardVO vo = new JboardVO();
		vo.setJbno(1);
		vo.setJtitle("염전캐자");
		vo.setJcontent("그대신 월급을 소금으로 주지");
		dao.updateJboard(vo);
	}
	@Test
	public void Test05deleteJboard() {
		dao.deleteJboard(2);
	}
}
