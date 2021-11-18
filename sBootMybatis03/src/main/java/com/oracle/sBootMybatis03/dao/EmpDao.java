package com.oracle.sBootMybatis03.dao;

import java.util.List;

import com.oracle.sBootMybatis03.model.Emp;
import com.oracle.sBootMybatis03.model.EmpDept;

public interface EmpDao {
	int total();

	List<Emp> listEmp(Emp emp);

	Emp detail(int empno);

	int write(Emp emp);

	int update(Emp emp);

	int delete(int empno);

	List<Emp> listManager();

	List<EmpDept> listEmpDept();

	List<EmpDept> listEmp(EmpDept empDept);

	String deptName(int deptno);

}
