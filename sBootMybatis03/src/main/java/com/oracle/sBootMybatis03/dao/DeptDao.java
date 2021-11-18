package com.oracle.sBootMybatis03.dao;

import java.util.List;

import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.DeptVO;

public interface DeptDao {

	List<Dept> deptSelect();

	void insertDept(DeptVO deptVO);
}
