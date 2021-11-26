package com.oracle.s20210904.ds.service;

import java.util.List;

import com.oracle.s20210904.comm.model.Announce;
import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Post;
import com.oracle.s20210904.comm.model.Member;
import com.oracle.s20210904.ds.model.AnnounceCnt;
import com.oracle.s20210904.ds.model.DsComm;


public interface DsAdminService {

	List<Company> getWaitCompany();
	int joinConfirm(String com_id);
	List<Post> getQnaList();
	List<AnnounceCnt> announceCnt();
	List<Announce> getAnnounce();
	List<Member> getUserList(Member member);
	int totCnt();
	int ctotCnt();
	int cctotCnt();
	List<Company> getCompanyList(Company com);
	List<Company> getComConfirmList(Company com);
	Company getCompany(Company com);
	int ttotCnt();
	List<DsComm> getDsCommList(DsComm dsComm);

}
