package com.oracle.s20210904.sh.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Member;


@Repository
public class ShMemberDaoImpl implements ShMemberDao {

	@Autowired
	private SqlSession session;
	
	//개인 회원가입 
	@Override
	public int joinmember(Member member) {
		int joinmember= 0;
		System.out.println("ShMemberDaoImpl joinmember Start...");
		try {
			 member.setUser_img(""); //이미지는 null값
			System.out.println("ShMemberDaoImpl joinmember.getUser_id()->"+member.getUser_id());
			System.out.println("ShMemberDaoImpl joinmember.getUser_pw()->"+member.getUser_pw());
			joinmember = session.insert("ShJoinMember", member);
		} catch (Exception e) {
			System.out.println("ShMemberDaoImpl joinmember Exception-> "+e.getMessage());
		}
		return joinmember;
	}

	//기업 회원가입
	@Override
	public int joincom(Company company) {
		int joincom = 0;
		System.out.println("ShUserDaoImpl joincom Start...");
		try {
			joincom=session.insert("ShJoinCompany" , company);
		} catch (Exception e) {
			System.out.println("ShUserDaoImpl joincom Exception" + e.getMessage());
		}
		return joincom;
	}
	
	



}
