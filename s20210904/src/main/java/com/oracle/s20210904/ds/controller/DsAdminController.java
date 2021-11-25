package com.oracle.s20210904.ds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.s20210904.comm.model.Announce;
import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Post;
import com.oracle.s20210904.comm.model.Member;
import com.oracle.s20210904.ds.model.AnnounceCnt;
import com.oracle.s20210904.ds.service.DsAdminService;
import com.oracle.s20210904.ds.service.Paging;

@Controller
public class DsAdminController {
	
	@Autowired
	DsAdminService dsAdminService;
	
	@GetMapping(value="AdminMain")
	public String AdminMain(Model model) {
		// 가입승인 대기중인놈들 가져옵니다
		List<Company> waitComList = dsAdminService.getWaitCompany(); 
		int totCnt = waitComList.size();
		// QnA게시판 목록 가져옵니다.
		List<Post> qnaList = dsAdminService.getQnaList();
		int qtotCnt = qnaList.size();
		// 직종별 공고갯수 가져오기
		List<AnnounceCnt> annCntList= dsAdminService.announceCnt();
		// 공고글 제목 가져오기
		List<Announce> announceList = dsAdminService.getAnnounce();
		int atotCnt = announceList.size();
		
		model.addAttribute("announceList",announceList);
		model.addAttribute("annCntList",annCntList);
		model.addAttribute("waitComList",waitComList);
		model.addAttribute("qnaList",qnaList);
		model.addAttribute("qtotCnt",qtotCnt);
		model.addAttribute("totCnt",totCnt);
		model.addAttribute("atotCnt",atotCnt);
		
		return "ds/AdminMain";
	}
	
	@GetMapping(value="memberMenu")
	public String memberMenu(Model model, String currentPage) {
		List<Member> userList = dsAdminService.getUserList();
		int mtotCnt = userList.size();
		System.out.println("userList.size()->"+userList.size());
		System.out.println("userList.get(0).getUserId()->"+userList.get(0).getUser_id());

		
		model.addAttribute("mtotCnt",mtotCnt);
		model.addAttribute("userList",userList);
		return "ds/memberMenu";
	}
	
	@GetMapping(value="companyMenu")
	public String companyMenu() {
		
		return "ds/companyMenu";
	}
	
	@GetMapping(value="boardMenu")
	public String boardMenu() {
		
		return "ds/boardMenu";
	}
	
	@GetMapping(value="tagMenu")
	public String tagMenu() {
		
		return "ds/tagMenu";
	}
}
