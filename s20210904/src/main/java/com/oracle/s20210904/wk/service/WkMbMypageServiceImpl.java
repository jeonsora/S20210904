package com.oracle.s20210904.wk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.dao.WkApplyDao;
import com.oracle.s20210904.wk.dao.WkResumeRepository;
import com.oracle.s20210904.wk.model.Applycount;

@Service
@Transactional
public class WkMbMypageServiceImpl implements WkMbMypageService{

	@Autowired
	private WkApplyDao WkApplyDao;
	
	private final WkResumeRepository WkResumeRepository;
	@Autowired
	public WkMbMypageServiceImpl(WkResumeRepository wkResumeRepository) {
		super();
		WkResumeRepository = wkResumeRepository;
	}



	@Override
	public List<Applycount> countApply(String mbid) {
		return WkApplyDao.countApply(mbid);
	}



	@Override
	public List<Resume> resumeList(String mbid) {
		return WkResumeRepository.resumeList(mbid);
	}

	
}
