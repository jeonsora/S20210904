package com.oracle.s20210904.dj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210904.comm.model.Announce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.dj.service.DjAnnoService;

@Controller
public class DjAnnoWriteController {
	// 데헷 공고 작성 컨트롤러 입니다
	
	@Autowired
	private DjAnnoService das;
	
	@RequestMapping("DjAnnoWrite")
	public String annoWrite(String com_id,Announce anno, Model model) {
		System.out.println("DjAnnoWriteController의 annoWrite 시작되었습니다.");
		
		com_id = "thsl90"; //공고 리스트와 잇기 전에 임시로 객체에 정보 넣기
		//회사 테이블에서 회사정보 가져오기 이것은 메뉴를 뿌려 줄 때 사용한다.
		Company compInfo = das.comInfoList(com_id);
		System.out.println("여기는 컨트롤러 회사정보 가져왔니? 회사명은?->"+compInfo.getCom_id());
		//-----------------------------------------
		//직종과 기술스택 가져오기
		List<Comm> jobTech1 = das.mainCatList1();
		System.out.println("(컨트롤러)리스트 내용물 확인001->"+jobTech1.size());
		List<Comm> jobTech2 = das.mainCatList2();
		System.out.println("(컨트롤러)리스트 내용물 확인001->"+jobTech2.size());
		
		/*
		 * List<Comm> jobTech001 = null; List<Comm> jobTech002 = null;
		 */
		
		
		
		/*
		 * for(Comm comm : jobTech) {
		 * 
		 * if(comm.getMain_cat().contentEquals("001")) {
		 * 
		 * jobTech001.add(comm); } else if(comm.getMain_cat().content){
		 * 
		 * jobTech002.add(comm); }
		 * 
		 * }
		 */
		
		System.out.println("jobTech1.size()->"+jobTech1.size());
		//System.out.println("jobTech002.size()->"+jobTech002.size());
		
		
		model.addAttribute("compInfo", compInfo);
		model.addAttribute("jobTech1", jobTech1);
		model.addAttribute("jobTech2", jobTech2);
		
		return "dj/annoWrite";
	}
}
