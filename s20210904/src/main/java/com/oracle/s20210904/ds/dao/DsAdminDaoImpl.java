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
	public List<Member> getUserList() {
		List<Member> userList = session.selectList("userSelectAll");
		return userList;
	}
}
