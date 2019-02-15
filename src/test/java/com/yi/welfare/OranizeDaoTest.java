package com.yi.welfare;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.OrganizeVO;
import com.yi.persistence.OrganizeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OranizeDaoTest {
	
	@Autowired
	private OrganizeDAO dao;
	
	//@Test
	public void Test01insertOrganize() {
		OrganizeVO vo = new OrganizeVO();
		vo.setOrname("별볼일 없는 복지관");	
		dao.insertOrganize(vo);
	}
	@Test
	public void Test02selectAllOranize() {
		List<OrganizeVO> list = dao.selectAllOranize();
		for(OrganizeVO org : list) {
			System.out.println(org);
		}
	}
	@Test
	public void Test03updateOrganize() {
		OrganizeVO vo = new OrganizeVO();
		vo.setOrnum(2);
		vo.setOrname("진짜 별볼일 없는 ");
		dao.updateOrganize(vo);
	}
	@Test
	public void Test04deleteOraganize() {
		dao.deleteOraganize(2);
	}
}
