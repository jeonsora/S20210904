package com.oracle.sBootMybatis03.service;

import java.util.List;

import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.DeptVO;
import com.oracle.sBootMybatis03.model.Emp;
import com.oracle.sBootMybatis03.model.EmpDept;
import com.oracle.sBootMybatis03.model.Member1;

public interface EmpService {
	int total();

	List<Emp> listEmp(Emp emp);

	Emp detail(int empno);

	int write(Emp emp);

	int update(Emp emp);

	int delete(int empno);

	List<Emp> listManager();

	List<Dept> deptSelect();

	List<EmpDept> listEmpDept();

	void insertDept(DeptVO deptVO);

	int memCount(String id);

	List<EmpDept> listEmp(EmpDept empDept);

	String deptName(int deptno);

	List<Member1> listMem(Member1 member1);

}
