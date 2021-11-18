package com.oracle.sBootMybatis03.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.sBootMybatis03.model.Member1;

@Repository
public class Member1DaoImpl implements Member1Dao {
	@Autowired
	private SqlSession session;

	@Override
	public int memCount(String id) {
		System.out.println("Member1DaoImpl memCount()");
		int result=0;
		try {
			result=session.selectOne("memCount", id);
		} catch (Exception e) {
			System.out.println("Member1DaoImpl memCount() error : "+e.getMessage());
		}
		return result;
	}

	@Override
	public List<Member1> listMem() {
		System.out.println("Member1DaoImpl memCount()");
		List<Member1> result=null;
		try {
			
		} catch (Exception e) {
			System.out.println("Member1DaoImpl memCount() error : "+e.getMessage());
		}
		return result;
	}

}
