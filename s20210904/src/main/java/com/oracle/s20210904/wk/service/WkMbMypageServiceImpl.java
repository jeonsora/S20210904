package com.oracle.s20210904.wk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.dao.WkApplyDao;
import com.oracle.s20210904.wk.dao.WkResumeDao;
import com.oracle.s20210904.wk.dao.WkResumeRepository;
import com.oracle.s20210904.wk.model.WkApply;
import com.oracle.s20210904.wk.model.WkApplyCount;
import com.oracle.s20210904.wk.model.WkResume;

@Service
@Transactional
public class WkMbMypageServiceImpl implements WkMbMypageService{

	@Autowired
	private WkApplyDao WkApplyDao;
	@Autowired
	private WkResumeDao wkResumeDao;
	
	private final WkResumeRepository WkResumeRepository;
	@Autowired
	public WkMbMypageServiceImpl(WkResumeRepository wkResumeRepository) {
		super();
		WkResumeRepository = wkResumeRepository;
	}



	@Override
	public List<WkApplyCount> countApply(String mbid) {
		return WkApplyDao.countApply(mbid);
	}



//	@Override
//	public List<WkResume> resumeList(String mbid) {
//		return WkResumeRepository.resumeList(mbid);
//	}
	
	@Override
	public List<WkResume> resumeList(String mbid) {
		return wkResumeDao.resumeList(mbid);
	}



	@Override
	public List<WkApply> applyList(String mbid) {
		return WkApplyDao.applyList(mbid);
	}

	
}
