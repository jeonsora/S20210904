package com.oracle.s20210904.ds.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Announce;
import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Post;
import com.oracle.s20210904.comm.model.Member;
import com.oracle.s20210904.ds.model.AnnounceCnt;
import com.oracle.s20210904.ds.model.DsComm;

@Repository
public class DsAdminDaoImpl implements DsAdminDao {
	@Autowired
	SqlSession session;
	
	@Override 
	public List<Company> getWaitCompany() {
		List<Company> waitComList = session.selectList("DsWaitComList");
		return waitComList;
	}
	
	@Override
	public int joinConfirm(String com_id) {
		int result = session.update("DsJoinConfirm",com_id);
		System.out.println("result->"+result);
		
		return result;
	}
	
	@Override
	public List<Post> getQnaList() {
		List<Post> qnaList = session.selectList("DsQnaList");
		return qnaList;
	}
	
	@Override
	public List<AnnounceCnt> announceCnt() {
		List<AnnounceCnt> annCntList= session.selectList("DsAnnounceCnt");
		return annCntList;
	}
	
	@Override
	public List<Announce> getAnnounce() {
		List<Announce> announce = session.selectList("announceSelectAll");
		return announce;
	}
	
	@Override
	public List<Member> getUserList(Member member) {
		List<Member> userList = session.selectList("DsMemberList",member);
		return userList;
	}
	
	@Override
	public int totCnt() {
		int totCnt = session.selectOne("DsTotCnt");
		return totCnt;
	}
	
	@Override
	public int ctotCnt() {
		int ctotCnt = session.selectOne("DscTotCnt");
		return ctotCnt;
	}
	
	@Override
	public int cctotCnt() {
		int cctotCnt = session.selectOne("DsccTotCnt");
		return cctotCnt;
	}
	
	@Override
	public List<Company> getCompanyList(Company com) {
		List<Company> companyList = session.selectList("DsCompanyList",com);
		return companyList;
	}
	
	@Override
	public List<Company> getComConfirmList(Company com) {
		List<Company> comConfirmList = session.selectList("DsComConfirmList",com);
		return comConfirmList;
	}
	
	@Override
	public Company getCompany(Company com) {
		Company company = session.selectOne("companySelectOne",com);
		return company;
	}
	//comm 총 갯수
	@Override
	public int ttotCnt() {
		int ttotCnt = session.selectOne("DsttotCnt");
		return ttotCnt;
	}
	
	@Override
	public List<DsComm> getDsCommList(DsComm dsComm) {
		List<DsComm> dsCommList = session.selectList("DsCommList",dsComm);
		return dsCommList;
	}
}
