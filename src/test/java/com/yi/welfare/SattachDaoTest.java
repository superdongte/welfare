package com.yi.welfare;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.OrganizeVO;
import com.yi.domain.SboardVO;
import com.yi.persistence.SboardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SattachDaoTest {
	
	@Autowired
	private SboardDAO dao;
	
	@Test
	public void getAttach() {
		List<String> list = dao.getSattach(17);
		for(String bor : list) {
			System.out.println(bor);
		}
	}
}
