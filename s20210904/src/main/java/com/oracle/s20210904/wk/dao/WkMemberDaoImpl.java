package com.oracle.s20210904.wk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Member;

@Repository
public class WkMemberDaoImpl implements WkMemberDao{
	private final SqlSession session;
	@Autowired
	public WkMemberDaoImpl(SqlSession session) {
		super();
		this.session = session;
	}
	
	@Override
	public Member memberDetail(String mbid) {
		System.out.println("WkMemberDaoImpl memberdetail()");
		Member result=null;
		String user_id=mbid;
		try {
			result=session.selectOne("memberSelectOne", user_id);
		} catch (Exception e) {
			System.out.println("WkMemberDaoImpl memberdetail() error : "+e.getMessage());
		}
		return result;
	}

	@Override
	public int memberUpdate(Member member) {
		System.out.println("WkMemberDaoImpl memberupdate()");
		int result=0;
		try {
			result=session.update("WkMemberUpdate", member);
		} catch (Exception e) {
			System.out.println("WkMemberDaoImpl memberupdate() error : "+e.getMessage());
			result=0;
		}
		return result;
	}


}
