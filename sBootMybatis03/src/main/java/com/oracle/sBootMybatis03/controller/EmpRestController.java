package com.oracle.sBootMybatis03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.SampleVO;
import com.oracle.sBootMybatis03.service.EmpService;

// @RestController = @Controller + @ResponseBody
@RestController
public class EmpRestController {
	@Autowired
	private EmpService es;
	
	
	@RequestMapping("/sample/sendVO2")
	public SampleVO sendVO2(int deptno) {
		System.out.println("EmpRestController sendVO2()");
		SampleVO vo= new SampleVO();
		
		// 원래 서비스갔다 db에서 값 받아야되는데 그냥 생략함
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(deptno);
		return vo;
	}
	
	@RequestMapping("/sendVO3")
	public List<Dept> sendVO3() {
		System.out.println("EmpRestController sendVO3()");
		List<Dept> deptList=es.deptSelect();
		return deptList;
	}
}



















