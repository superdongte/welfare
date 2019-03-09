package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.yi.domain.Criteria;
import com.yi.domain.SboardVO;
import com.yi.domain.SearchCriteria;
import com.yi.persistence.SboardDAO;

@Service
public class SboardServiceImpl implements SboardService {
	
	@Autowired
	private SboardDAO dao;
	
	
	@Override
	@Transactional
	public void insertSboard(SboardVO vo) {
		// TODO Auto-generated method stub
		dao.insertSboard(vo);
		List<String> files = vo.getFiles();
		
		if(files == null || files.size() == 0) {
			return;
		}
		for(String spname : files) {
			dao.insertSattach(spname);
		}
	}

	@Override
	public List<SboardVO> listSboardAll() {
		// TODO Auto-generated method stub
		return dao.listSboardAll();
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public SboardVO readSboard(int sbno) {
		// TODO Auto-generated method stub
		SboardVO vo = dao.readSboard(sbno);
		vo.setFiles(dao.getSattach(sbno));
		System.out.println("service sbno는"+ vo);
		return vo;
	}

	@Override
	public void updateSboard(SboardVO vo) {
		// TODO Auto-generated method stub
		dao.updateSboard(vo);
	}

	@Override
	public void deleteSboard(int sbno) {
		// TODO Auto-generated method stub
		dao.delSattach(sbno);
		dao.deleteSboard(sbno);
	}

	@Override
	public List<SboardVO> listPage(int page) {
		// TODO Auto-generated method stub
		return dao.listPage(page);
	}

	@Override
	public List<SboardVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}

	@Override
	public List<SboardVO> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.searchTotalCount(cri);
	}

	@Override
	public void insertSattach(String spname) {
		// TODO Auto-generated method stub
		dao.insertSattach(spname);
	}

	@Override
	public void delSattach(int sbno) {
		// TODO Auto-generated method stub
		dao.delSattach(sbno);
	}

	@Override
	@Transactional
	public void modifyFile(SboardVO vo, String[] delFiles, List<String> addImages) {
		// TODO Auto-generated method stub
		if(delFiles != null) {
		for(String file:delFiles) {
			dao.deleteAttachByFullName(vo.getSbno(), file);
		 }
	  }
		for(String file : addImages) {
			dao.insertSattachBySbno(file, vo.getSbno());
		}
		dao.updateSboard(vo);
	}
}
