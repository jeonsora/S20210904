package com.oracle.s20210904.wk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.wk.model.WkApply;
import com.oracle.s20210904.wk.model.WkApplyCount;

@Repository
public class WkApplyDaoImpl implements WkApplyDao{

	private final SqlSession session;
	@Autowired
	public WkApplyDaoImpl(SqlSession session) {
		super();
		this.session = session;
	}

	@Override
	public List<WkApplyCount> countApply(String mbid) {
		System.out.println("WkApplyDaoImpl countApply()");
		List<WkApplyCount> applycount=null;
		try {
			applycount=session.selectList("WkApplyCount", mbid);
			System.out.println("WkApplyDaoImpl countApply() listapply : "+applycount.size());
		} catch (Exception e) {
			System.out.println("WkApplyDaoImpl countApply() error : "+e.getMessage());
		}
		return applycount;
	}

	@Override
	public List<WkApply> applyList(String mbid) {
		System.out.println("WkApplyDaoImpl applyList()");
		List<WkApply> result=null;
		try {
			result=session.selectList("WkApplyList", mbid);
			System.out.println("WkApplyDaoImpl countApply() listapply : "+result.size());
		} catch (Exception e) {
			System.out.println("WkApplyDaoImpl countApply() error : "+e.getMessage());
		}
		return result;
	}
	
	
}
