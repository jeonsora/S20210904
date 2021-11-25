package com.oracle.s20210904.sh.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.User;

@Repository
public class ShMemberDaoImpl implements ShMemberDao {

	@Autowired
	private SqlSession session;
	
	//개인 회원가입 
	@Override
	public int joinuser(User user) {
		int joinuser= 0;
		System.out.println("ShUserDaoImpl joinuser Start...");
		try {
			joinuser = session.insert("ShJoinUser");
		} catch (Exception e) {
			System.out.println("ShUserDaoImpl joinuser Exception "+e.getMessage());
		}
		return joinuser;
	}

	//기업 회원가입
	@Override
	public int joincom(Company company) {
		int joincom = 0;
		System.out.println("ShUserDaoImpl joincom Start...");
		try {
			joincom=session.insert("ShJoinCom");
		} catch (Exception e) {
			System.out.println("ShUserDaoImpl joincom Exception" + e.getMessage());
		}
		return joincom;
	}
	
	



}
