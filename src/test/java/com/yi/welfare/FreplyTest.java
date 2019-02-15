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

import com.yi.domain.FreplyVO;
import com.yi.persistence.FreplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FreplyTest {
	
	@Autowired
	private FreplyDAO dao;
	
	//@Test
	public void Test01insertFreply() {
		FreplyVO vo = new FreplyVO();
		vo.setFbno(1);
		vo.setFrwriter("감비아");
		vo.setFrcontent("한감동맹 든든합니다.");
		vo.setFrregdate(new Date());
		dao.insertFreply(vo);
	}
	//@Test
	public void Test02listAllFreply() {
		List<FreplyVO> list = dao.listAllFreply();
		for(FreplyVO freply : list) {
			System.out.println("reply는"+freply);
		}
	}
	//@Test
	public void Test03updateFreply() {
		FreplyVO vo = new FreplyVO();
		vo.setFrno(2);
		vo.setFrcontent("한감동맹 진짜안든든합니다.");
		dao.updateFreply(vo);
	}
	@Test
	public void Test04deleteFreply() {
		dao.deleteFreply(2);
	}
}
