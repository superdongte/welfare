package com.yi.welfare;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.SupportVO;
import com.yi.persistence.SupportDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupportDaoTest {
	
	@Autowired
	private SupportDAO dao;
	
	//@Test
	public void Test01insertSupport() {
		SupportVO vo = new SupportVO();
		vo.setUserid("test1");
		vo.setVnumber(1);
		vo.setVgroup(true);
		vo.setVtime("우주끝까안지");
		vo.setCarrer("꽤 많이안함");
		vo.setVreason("걍한다");
		dao.insertVolunteer(vo);
	}
	//@Test
	public void Test02insertMoney() {
		SupportVO vo = new SupportVO();
		vo.setUserid("test1");
		vo.setVgroup(false);
		vo.setDgroup("잔반");
		vo.setDmoney(4000);
		vo.setDmode("짬차와 함께");
		dao.insertMoney(vo);
	}
	//@Test
	public void Test03listSupport() {
		List<SupportVO> list = dao.listSupport();
		for(SupportVO support : list) {
			System.out.println(support);
		}
	}
	@Test
	public void Test04SupportVol() {
		List<SupportVO> list = dao.SupportVol();
		for(SupportVO support : list) {
			System.out.println(support);
		}
	}
	//@Test
	public void Test05SupportMoney() {
		List<SupportVO> list = dao.SupportMoney();
		for(SupportVO support : list) {
			System.out.println(support);
		}
	}
}
