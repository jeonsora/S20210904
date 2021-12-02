package com.oracle.s20210904.wk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.s20210904.comm.model.Member;
import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.comm.model.ResumeDetail;
import com.oracle.s20210904.wk.dao.WkApplyDao;
import com.oracle.s20210904.wk.dao.WkCommRepository;
import com.oracle.s20210904.wk.dao.WkMemberDao;
import com.oracle.s20210904.wk.dao.WkResumeDao;
import com.oracle.s20210904.wk.dao.WkResumeDetailDao;
import com.oracle.s20210904.wk.dao.WkResumeRepository;
import com.oracle.s20210904.wk.dao.WkScrapDao;
import com.oracle.s20210904.wk.model.WkApply;
import com.oracle.s20210904.wk.model.WkApplyCount;
import com.oracle.s20210904.wk.model.WkCommDto;
import com.oracle.s20210904.wk.model.WkResume;
import com.oracle.s20210904.wk.model.WkResumeDetail;
import com.oracle.s20210904.wk.model.WkScrap;

@Service
@Transactional
public class WkMbMypageServiceImpl implements WkMbMypageService{

	@Autowired
	private WkApplyDao wkApplyDao;
	@Autowired
	private WkResumeDao wkResumeDao;
	@Autowired
	private WkMemberDao wkMemberDao;
	@Autowired
	private WkScrapDao wkScrapDao;
	@Autowired
	private WkResumeDetailDao wkResumeDetailDao;
	
	private final WkResumeRepository wkResumeRepository;
	
	private final WkCommRepository wkCommRepository;
	@Autowired
	public WkMbMypageServiceImpl(WkResumeRepository wkResumeRepository, WkCommRepository wkCommRepository) {
		super();
		this.wkResumeRepository = wkResumeRepository;
		this.wkCommRepository = wkCommRepository;
	}
	
	

	@Override
	public List<WkApplyCount> countApply(String mbid) {
		return wkApplyDao.countApply(mbid);
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
		return wkApplyDao.applyList(mbid);
	}



	@Override
	public Member memberDetail(String mbid) {
		return wkMemberDao.memberDetail(mbid);
	}



	@Override
	public List<WkScrap> scarpList(String mbid) {
		return wkScrapDao.scarpList(mbid);
	}



	@Override
	public int scarpCount(String mbid) {
		return wkScrapDao.scarpCount(mbid);
	}



	@Override
	public int memberUpdate(Member member) {
		return wkMemberDao.memberUpdate(member);
	}



	@Override
	public List<WkCommDto> commList(String main_cat) {
		return wkCommRepository.commList(main_cat);
	}


	@Transactional(rollbackFor = {RuntimeException.class ,Exception.class})
	@Override
	public int resumeWrite(WkResume wkResume, WkResumeDetail wkResumeDetail) {
		wkResume.setRes_sts("001");
		wkResume.setRep_res("0");
		int resume_result=wkResumeDao.resumeWrite(wkResume);
		
		wkResumeDetail.setRes_code(resume_result);
		if(wkResumeDetail.getCar_code_ar() != null) {
			List<ResumeDetail> rdlist=new ArrayList<ResumeDetail>();
			ResumeDetail rd=null;
			for(int a:wkResumeDetail.getCar_code_ar()) {
				rd=new ResumeDetail();
				rd.setCar_code(wkResumeDetail.getCar_code_ar()[a]);
				rd.setCom_name(wkResumeDetail.getCom_name_ar()[a]);
//				rd.setEmp_date(wkResumeDetail.getEmp_date_ar()[a]);
				rd.setEmp_dept(wkResumeDetail.getEmp_dept_ar()[a]);
				rd.setTask(wkResumeDetail.getTask_ar()[a]);
				
				rdlist.add(a, rd);
			}
			wkResumeDetail.setResumeDetailList(rdlist);
			
			System.out.println("WkMbMypageServiceImpl resumeWrite() com_name : "+wkResumeDetail.getResumeDetailList().get(0).getCom_name());
			
			int resume_detail_result=wkResumeDetailDao.resumeDetailWrite(wkResumeDetail);
		}
		
		return resume_result;
	}


	@Transactional(rollbackFor = {RuntimeException.class ,Exception.class})
	@Override
	public int resumeDelete(Resume resume) {
		
		int resume_detail_result=wkResumeDetailDao.resumeDetailDelete(resume);
		System.out.println("WkMbMypageServiceImpl resumeDelete() detail_result : "+resume_detail_result);
		int resume_result=wkResumeDao.resumeDelete(resume);
		System.out.println("WkMbMypageServiceImpl resumeDelete() result : "+resume_result);
		return resume_result;
	}



	@Override
	public Resume resumeSelect(Resume resume) {
		return wkResumeDao.resumeselect(resume);
	}

	
}
