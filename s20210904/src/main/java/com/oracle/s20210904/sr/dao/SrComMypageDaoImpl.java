package com.oracle.s20210904.sr.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SrComMypageDaoImpl implements SrComMypageDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public int total() {
		int tot=0;
		System.out.println("SrComMypageDaoImpl total Start....");
		try {
			tot=session.selectOne("SrComMyTotal");  //mapper 아이디
		} catch (Exception e) {
			System.out.println("SrComMypageDaoImpl total Excetion=>"+e.getMessage());
		}
		
		return tot;
	}
}
