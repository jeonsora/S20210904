package com.oracle.sBootMybatis03.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.DeptVO;

@Repository
public class DeptDaoImpl implements DeptDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Dept> deptSelect() {
		System.out.println("DeptDaoImpl deptSelect()");
		List<Dept> deptList=null;
		try {
			deptList=session.selectList("tkDeptSelectAll");
			System.out.println("DeptDaoImpl deptSelect() deptList.size : "+deptList.size());
		} catch (Exception e) {
			System.out.println("DeptDaoImpl deptSelect() error : "+e.getMessage());
		}
		return deptList;
	}

	@Override
	public void insertDept(DeptVO deptVO) {
		System.out.println("DeptDaoImpl insertDept()");
		session.selectOne("ProcDept", deptVO);
		
	}

}

















