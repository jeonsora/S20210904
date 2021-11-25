package com.oracle.s20210904.sh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Member;
import com.oracle.s20210904.sh.dao.ShMemberDao;

@Service
public class ShMemberServiceImpl implements ShMemberService {

	@Autowired
	private ShMemberDao md;

	//개인 회원가입 
	@Override
	public int joinmember(Member member) {
		System.out.println("ShUserServiceImpl joinuser Start...");
		System.out.println("ShUserServiceImpl joinusermember.getUser_id()->"+member.getUser_id());
		System.out.println("ShUserServiceImpl joinusermember.getUser_pw()->"+member.getUser_pw());
		int joinmember = md.joinmember(member);
		//System.out.println("ShUserServiceImpl joinuser.getUser_name() "+);
		
		return joinmember;
	}
	
	//기업 회원가입
	@Override
	public int joincom(Company company) {
		System.out.println("ShUserServiceImpl joincom Start...");
		int joincom = md.joincom(company);
		
		return joincom;
	}
	
	
	
}
