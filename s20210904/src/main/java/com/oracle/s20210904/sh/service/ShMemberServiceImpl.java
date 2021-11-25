package com.oracle.s20210904.sh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.User;
import com.oracle.s20210904.sh.dao.ShMemberDao;

@Service
public class ShMemberServiceImpl implements ShMemberService {

	@Autowired
	private ShMemberDao ud;

	//개인 회원가입 
	@Override
	public int joinuser(User user) {
		System.out.println("ShUserServiceImpl joinuser Start...");
		int joinuser = ud.joinuser(user);
		//System.out.println("ShUserServiceImpl joinuser.getUser_name() "+);
		
		return joinuser;
	}
	
	//기업 회원가입
	@Override
	public int joincom(Company company) {
		System.out.println("ShUserServiceImpl joincom Start...");
		int joincom = ud.joincom(company);
		
		return joincom;
	}
	
	
	
}
