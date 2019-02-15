package com.yi.welfare;

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
	
	@Test
	public void Test01insertSupport() {
		SupportVO vo = new SupportVO();
		vo.setUserid("test1");
		vo.setVnumber(1);
		vo.setVgroup(true);
		vo.setVtime("우주끝까안지");
		vo.setCarrer("꽤 많이안함");
		vo.setVreason("걍한다");
		vo.setDgroup(null);
		vo.setDmoney(0);
		vo.setDmode(null);
		dao.insertSupport(vo);
	}
}
