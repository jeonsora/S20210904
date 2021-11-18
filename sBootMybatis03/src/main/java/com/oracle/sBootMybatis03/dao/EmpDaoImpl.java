package com.oracle.sBootMybatis03.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.sBootMybatis03.model.Emp;
import com.oracle.sBootMybatis03.model.EmpDept;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSession session;

	@Override
	public int total() {
		System.out.println("EmpDaoImpl total()");
		int tot=0;
		try {		
//					Mapper				Map Id(Naming Rule)
			tot = session.selectOne("tkEmpTotal");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl total() error : "+e.getMessage());
		}
		return tot;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		System.out.println("EmpDaoImpl listEmp()");
		List<Emp> empList=null;
		try {
//			일반적인 naming rule
//			empList=session.selectList("tkEmpListAll", emp);
//			<> != <= >=이런거일때
			empList=session.selectList("tkEmpListAll2", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp() error : "+e.getMessage());
		}
		return empList;
	}

	@Override
	public Emp detail(int empno) {
		System.out.println("EmpDaoImpl detail() empno : "+empno);
		Emp emp=new Emp();
		try {
			emp=session.selectOne("tkEmpSelOne", empno);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl detail() error : "+e.getMessage());
		}
		return emp;
	}

	@Override
	public int write(Emp emp) {
		System.out.println("EmpDaoImpl write()");
		int result=0;
		try {
			result=session.insert("tkEmpWrite", emp);
			System.out.println("EmpDaoImpl write() success");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl write() error : "+e.getMessage());
		}
		return result;
	}

	@Override
	public int update(Emp emp) {
		System.out.println("EmpDaoImpl update()");
		int kkk=0;
		try {
			kkk=session.update("tkEmpUpdate", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl update() error : "+e.getMessage());
		}
		return kkk;
	}

	@Override
	public int delete(int empno) {
		System.out.println("EmpDaoImpl delete()");
		int result=0;
		try {
			result=session.delete("tkEmpDelete", empno);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl delete() error : "+e.getMessage());
		}
		return result;
	}

	@Override
	public List<Emp> listManager() {
		System.out.println("EmpDaoImpl listManager()");
		List<Emp> empList=null;
		try {
			empList=session.selectList("tkEmpListManager");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listManager() error : "+e.getMessage());
		}
		return empList;
	}

	@Override
	public List<EmpDept> listEmpDept() {
		System.out.println("EmpDaoImpl listEmpDept()");
		List<EmpDept> empDept=null;
		try {
			empDept=session.selectList("TKlistEmpDept");
			System.out.println("EmpDaoImpl listEmpDept() empDept.size : "+empDept.size());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmpDept() error : "+e.getMessage());
		}
		return empDept;
	}

	@Override
	public List<EmpDept> listEmp(EmpDept empDept) {
		System.out.println("EmpDaoImpl listEmp()");
		List<EmpDept> listEmp=null;
		try {
			listEmp=session.selectList("TKlistEmpDept", empDept);
			System.out.println("EmpDaoImpl listEmp() listEmp.size : "+listEmp.size());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp() error : "+e.getMessage());
		}
		return listEmp;
	}

	@Override
	public String deptName(int deptno) {
		System.out.println("EmpDaoImpl deptName()");
		String result=null;
		try {
			result=session.selectOne("TKdeptName", deptno);
			System.out.println("EmpDaoImpl deptName() result : "+result);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl deptName() error : "+e.getMessage());
		}
		return result;
	}

}



















