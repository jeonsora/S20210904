package com.oracle.s20210904.wk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.s20210904.comm.model.Member;
import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.comm.model.ResumeDetail;
import com.oracle.s20210904.wk.model.WkApply;
import com.oracle.s20210904.wk.model.WkApplyCount;
import com.oracle.s20210904.wk.model.WkCommDto;
import com.oracle.s20210904.wk.model.WkResume;
import com.oracle.s20210904.wk.model.WkResumeDetail;
import com.oracle.s20210904.wk.model.WkScrap;
import com.oracle.s20210904.wk.service.WkMbMypageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WkMbMypageController {
	
	private final WkMbMypageService ms;
	

	private String checkId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("mbid");
		if(id==null || id.equals("")){              
			return "/wk/wkindex";
		}
//		System.out.println("checkId : "+id);
		return id;
	}
	
	@GetMapping(value = "wkindex")
	public String index() {
		return "/wk/wkindex";
	}
	
	@GetMapping(value = "wkindex2")
	public String index2(HttpServletRequest request, Model model) {
		HttpSession session=request.getSession();
		String memberid=(String) request.getParameter("memberid");
		session.setAttribute("mbid", memberid);
//		System.out.println("index : "+memberid);
		return "redirect:mbMypage";
	}
	
	
	
	
	@RequestMapping(value = "mbMypage")
	public String mbMypage(HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypage()");
//		HttpSession session = request.getSession();
//		String id=
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
//		System.out.println("WkMbMypageController mbMypage() mbid : "+mbid );
		
		List<WkApplyCount> countapply=ms.countApply(mbid);
		model.addAttribute("countapply", countapply);
		
		List<WkResume> resumelist=ms.resumeList(mbid);
		model.addAttribute("resumelist", resumelist);
		
		return "/wk/mbMypage";
	}
	
	@GetMapping(value = "mbMypageApply")
	public String mbMypageApply(HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypageApply()");
		String mbid=checkId(request);
		
		List<WkApplyCount> countapply=ms.countApply(mbid);
		model.addAttribute("countapply", countapply);
		
		List<WkApply> applyList=ms.applyList(mbid);
		model.addAttribute("applyList", applyList);
		
		return "/wk/mbMypageApply";
	}
	
	@RequestMapping(value = "mbMypageResume")
	public String mbMypageResume(HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypageResume()");
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
		
		List<WkResume> resumelist=ms.resumeList(mbid);
		model.addAttribute("resumelist", resumelist);
		
		return "/wk/mbMypageResume";
	}
	
	@RequestMapping(value = "mbMypageResumeWrite")
	public String mbMypageResumeWrite(HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypageResumeWrite()");
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
		
		String main_cat="062";
		List<WkCommDto> commlist=ms.commList(main_cat);
		model.addAttribute("commlist", commlist);
		
		Member memberdetail=ms.memberDetail(mbid);
		model.addAttribute("memberdetail", memberdetail);
		return "/wk/mbMypageResumeWrite"; 
	}
	
	@RequestMapping(value = "mbMypageResumeWritePro", method = RequestMethod.POST)
	public String mbMypageResumeWritePro(WkResumeDetail wkResumeDetail, WkResume wkResume, HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypageResumeWritePro()");
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
		

		
//		String emp_date1=request.getParameter("emp_date1");
//		String emp_date2=request.getParameter("emp_date2");
//		System.out.println("emp_date1 + emp_date2 : "+emp_date1+" "+emp_date2);
		
		int resume_write_result=ms.resumeWrite(wkResume, wkResumeDetail);
		System.out.println("WkMbMypageController mbMypageResumeWritePro() result : "+resume_write_result);
		
		
//		Member memberdetail=ms.memberdetail(mbid);
//		model.addAttribute("memberdetail", memberdetail);
		return "redirect:mbMypageResume"; 
	}
	
	
	
	@RequestMapping(value = "mbMypageResumeUpdate", method = RequestMethod.GET)
	public String mbMypageResumeUpdate(HttpServletRequest request, Model model, int res_code) {
		System.out.println("WkMbMypageController mbMypageResumeUpdate()");
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
		Resume resume=new Resume();
		resume.setUser_id(mbid);
		resume.setRes_code(res_code);
		boolean res_select_msg=false;
		resume=ms.resumeSelect(resume);
		if(resume!=null && !resume.getRes_sts().equals("003")) {
			res_select_msg=true;
			model.addAttribute("resumedetail", resume);
			String main_cat="062";
			List<WkCommDto> commlist=ms.commList(main_cat);
			model.addAttribute("commlist", commlist);
			
			Member memberdetail=ms.memberDetail(mbid);
			model.addAttribute("memberdetail", memberdetail);
			
		}
		model.addAttribute("res_select_msg", res_select_msg);
		return "/wk/mbMypageResumeUpdate"; 
	}
	
	@RequestMapping(value = "mbMypageScrap")
	public String mbMypageScrap(HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypageScrap()");
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
		
		List<WkScrap> scarplist=ms.scarpList(mbid);
		model.addAttribute("scarplist", scarplist);
		
		int scarpcount=ms.scarpCount(mbid);
		model.addAttribute("scarpcount", scarpcount);
		return "/wk/mbMypageScrap"; 
	}
	
	@RequestMapping(value = "mbMypageUpdate")
	public String mbMypageUpdate(HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypageUpdate()");
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
		
		return "/wk/mbMypageUpdate"; 
	}
	
	@PostMapping(value = "mbMypageUpdateForm")
	public String mbMypageUpdateForm(HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypageUpdateForm()");
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
		
		String returnpage=null;
		
		String user_pw=request.getParameter("user_pw");
		Member member=ms.memberDetail(mbid);
		
		if(user_pw.equals(member.getUser_pw())) {
			model.addAttribute("member", member);
			returnpage="/wk/mbMypageUpdateForm";
		}else {
			String msg="잘못된 비밀번호입니다";
			model.addAttribute("msg", msg);
			returnpage="/wk/mbMypageUpdate";
		}
		return returnpage; 
	}
	
	@PostMapping(value = "mbMypageUpdatePro")
	public String mbMypageUpdatePro(Member member, HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypageUpdatePro()");
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
		
		Member member2=member;
		System.out.println("WkMbMypageController mbMypageUpdatePro() member : "+member2.getUser_img());
		
		int mypage_update_result=ms.memberUpdate(member2);
		String mypage_update_msg=null;
		System.out.println("WkMbMypageController mbMypageUpdatePro() mypage_update_result : "+mypage_update_result);
		if(mypage_update_result>=1) {
			mypage_update_msg="마이페이지 수정 완료";
		}else {
			mypage_update_msg="마이페이지 수정 실패";
		}
		model.addAttribute("mypage_update_msg", mypage_update_msg);
		return "forward:mbMypage";
		
	}
	
	
}
