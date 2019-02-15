package com.yi.welfare;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.VolunteerVO;
import com.yi.persistence.VolunteerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VolunterrDaoTest {
	
	@Autowired
	private VolunteerDAO dao;
	
	@Test
	public void Test01insertVol(){
		VolunteerVO vo = new VolunteerVO();
		vo.setVname("반지닦이");
		dao.insertVol(vo);
	}
	@Test
	public void Test02listAllVol() {
		List<VolunteerVO> list = dao.listAllVol();
		for(VolunteerVO vol : list) {
			System.out.println(vol);
		}
	}
	@Test
	public void Test03updateVol() {
		VolunteerVO vo = new VolunteerVO();
		vo.setVnumber(2);
		vo.setVname("반지르 닦아주었다.");
		dao.updateVol(vo);
	}
	@Test
	public void Test04deleteVol() {
		dao.deleteVol(2);
	}
}
