package com.oracle.s20210904.ds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Post;
import com.oracle.s20210904.ds.dao.DsAdminDao;
import com.oracle.s20210904.ds.model.AnnounceCnt;

@Service
public class DsAdminServiceImpl implements DsAdminService {
	@Autowired
	DsAdminDao dsAdminDao;
	
	@Override
	public List<Company> getWaitCompany() {
		List<Company> waitComList = dsAdminDao.getWaitCompany();
		
		return waitComList;
	}
	
	@Override
	public int joinConfirm(String com_id) {
		int result = dsAdminDao.joinConfirm(com_id);
		return result;
	}
	
	@Override
	public List<Post> getQnaList() {
		List<Post> qnaList = dsAdminDao.getQnaList();
		return qnaList;
	}
	
	@Override
	public List<AnnounceCnt> announceCnt() {
		List<AnnounceCnt> annCntList= dsAdminDao.announceCnt();
		return annCntList;
	}
	
}
