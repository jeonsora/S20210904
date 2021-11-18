package com.oracle.sBootMybatis03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.sBootMybatis03.dao.DeptDao;
import com.oracle.sBootMybatis03.dao.EmpDao;
import com.oracle.sBootMybatis03.dao.Member1Dao;
import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.DeptVO;
import com.oracle.sBootMybatis03.model.Emp;
import com.oracle.sBootMybatis03.model.EmpDept;
import com.oracle.sBootMybatis03.model.Member1;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao ed;
	@Autowired
	private DeptDao dd;
	@Autowired
	private Member1Dao md;

	@Override
	public int total() {
		System.out.println("EmpServiceImpl total()");
		int totCnt = ed.total();
		System.out.println("EmpServiceImpl total() totCnt : "+totCnt);
		return totCnt;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		System.out.println("EmpServiceImpl listEmp()");
		List<Emp> empList=null;
		empList=ed.listEmp(emp);
		System.out.println("EmpServiceImpl listEmp() size : "+empList.size());
		return empList;
	}

	@Override
	public Emp detail(int empno) {
		System.out.println("EmpServiceImpl detail()");
		Emp emp=null;
		emp=ed.detail(empno);
		return emp;
	}

	@Override
	public int write(Emp emp) {
		System.out.println("EmpServiceImpl write()");
		int result = ed.write(emp);
		return result;
	}

	@Override
	public int update(Emp emp) {
		System.out.println("EmpServiceImpl update()");
		int kkk=ed.update(emp);
		return kkk;
	}

	@Override
	public int delete(int empno) {
		System.out.println("EmpServiceImpl delete()");
		int result=ed.delete(empno);
		return result;
	}

	@Override
	public List<Emp> listManager() {
		System.out.println("EmpServiceImpl listManager()");
		List<Emp> empList=null;
		empList=ed.listManager();
		return empList;
	}

	@Override
	public List<Dept> deptSelect() {
		System.out.println("EmpServiceImpl deptSelect()");
		List<Dept> deptList=null;
		deptList=dd.deptSelect();
		return deptList;
	}

	@Override
	public List<EmpDept> listEmpDept() {
		System.out.println("EmpServiceImpl listEmpDept()");
		return ed.listEmpDept();
	}

	@Override
	public void insertDept(DeptVO deptVO) {
		System.out.println("EmpServiceImpl insertDept()");
		dd.insertDept(deptVO);
	}

	@Override
	public int memCount(String id) {
		System.out.println("EmpServiceImpl memCount()");
		return md.memCount(id);
	}

	@Override
	public List<EmpDept> listEmp(EmpDept empDept) {
		System.out.println("EmpServiceImpl listEmp()");
		return ed.listEmp(empDept);
	}

	@Override
	public String deptName(int deptno) {
		System.out.println("EmpServiceImpl deptName()");
		return ed.deptName(deptno);
	}

	@Override
	public List<Member1> listMem(Member1 member1) {
		System.out.println("EmpServiceImpl listMem()");
		return md.listMem();
	}

}


















