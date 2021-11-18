package com.oracle.sBootMybatis03.controller;

import java.util.List;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.DeptVO;
import com.oracle.sBootMybatis03.model.Emp;
import com.oracle.sBootMybatis03.model.EmpDept;
import com.oracle.sBootMybatis03.model.Member1;
import com.oracle.sBootMybatis03.service.EmpService;
import com.oracle.sBootMybatis03.service.Paging;

@Controller
public class EmpController {
	private static final Logger log = LoggerFactory.getLogger(EmpController.class);

	@Autowired
	private EmpService es;
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "empList")
	public String emplist(Emp emp, String currentPage, Model model) {
		log.info("start");
		int total = es.total();
		System.out.println("EmpController emplist() total : "+total);
		// Paging
		Paging pg=new Paging(total, currentPage);
		emp.setStart(pg.getStart());
		emp.setEnd(pg.getEnd());
		
//		emp.setEmpno(7369);
		System.out.println("EmpController emplist() emp.empno : "+emp.getEmpno());
		List<Emp> listEmp = es.listEmp(emp);
		System.out.println("EmpController emplist() listEmp.size : "+listEmp.size());
		model.addAttribute("total", total);
		model.addAttribute("listEmp", listEmp);
		model.addAttribute("pg", pg);
		
		return "list";
	}
	
	@GetMapping(value="detail")
	public String detail(int empno, Model model) {
		System.out.println("EmpController detail()");
		Emp emp=es.detail(empno);
		model.addAttribute("emp", emp);
		return "detail";
	}
	
//	@GetMapping(value = "writeForm")
//	@PostMapping(value = "writeForm")
	@RequestMapping(value = "writeForm")
	public String writeForm(Model model) {
		System.out.println("EmpController writeForm()");
		List<Emp> list=es.listManager();
		System.out.println("EmpController writeForm() list.size : "+list.size());
		model.addAttribute("empMngList", list);
		List<Dept> deptList=es.deptSelect();
		model.addAttribute("deptList", deptList);
		return "writeForm";
	}
	
	@PostMapping(value = "writePro")
	public String writePro(Emp emp, Model model) {
		System.out.println("EmpController writeForm() emp.ename : "+emp.getEname());
		int result = es.write(emp);
		String returnstr="";
		if(result>0) {
			returnstr= "redirect:/empList";
		}else {
			String msg="입력 실패 확인해보세요";
			model.addAttribute("msg", msg);
			returnstr= "forward:/writeForm";
		}
		return returnstr;
	}
	
	@GetMapping(value="updateForm")
	public String updateForm(int empno, Model model) {
		System.out.println("EmpController updateForm()");
		Emp emp=es.detail(empno);
		model.addAttribute("emp", emp);
		return "updateForm";
	}
	
//	@RequestMapping(value = "update", method = RequestMethod.POST)
	@PostMapping(value = "update")
	public String update(Emp emp, Model model) {
		System.out.println("EmpController update()");
		int k = es.update(emp);
		System.out.println("EmpController update() k : "+k);
		model.addAttribute("kkk", k);				// Test Controller간 Data전달
		model.addAttribute("kk3", "Message Test");	// Test Controller간 Data전달
//		return "redirect:/empList";
		return "forward:empList";
	}
	
	@GetMapping(value = "delete")
	public String delete(int empno, Model model) {
		System.out.println("EmpController delete()");
		int result=es.delete(empno);
		String msg="";
		if(result>0) {
			msg="삭제성공";
		}else {
			msg="삭제실패";
		}
		model.addAttribute("msg", msg);
		return "forward:/empList";
	}
	
	@GetMapping(value = "confirm")
	public String confirm(int empno, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("EmpController confirm()");
//		String returnstr="";
		Emp emp=es.detail(empno);
		if(emp!=null) {
			model.addAttribute("msg", "중복된 사번");
		}else {
			model.addAttribute("msg", "사용가능한 사번");
		}
		redirectAttributes.addFlashAttribute("msg", "FlashAttribute test");
		String referer=request.getHeader("Referer");
		System.out.println("referer : "+referer);
		return "redirect:"+referer;
//		return "forward:writeForm";
	}
	
	@GetMapping(value = "listEmpDept")
	public String listEmpDept(Model model) {
		System.out.println("EmpController listEmpDept()");
//		EmpDept empDept=null;
		List<EmpDept> listEmptDept=es.listEmpDept();
		model.addAttribute("listEmpDept", listEmptDept);
		System.out.println("EmpController listEmpDept() listEmptDept.size : "+listEmptDept.size());
		return "listEmpDept";
	}
	
	@RequestMapping(value = "mailTransport")
	public String mailTransport(Model model) {
		System.out.println("EmpController mailTransport()");
		System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
		String tomail="newtest5762@gmail.com";		// 받는사람 이메일
		String setfrom="newtest5762@gmail.com";		// 보내는 사람
		String title = "나야나";						// 제목
		try {
			// Mine 전자우편 Internet 표준 Format
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
																	//true 는 멀티파트 메세지를 사용
			messageHelper.setFrom(setfrom);		// 보내는사람 생략하면 정상작동 안함
			messageHelper.setTo(tomail);		// 받는사람 이메일
			messageHelper.setSubject(title);	// 메일제목은 생략가능
			String tempPassword=(int)(Math.random()*999999)+1+"";
			System.out.println("EmpController mailTransport() tempPassword"+tempPassword);
			messageHelper.setText("임시 비밀번호 : "+tempPassword); // 메일내용
			DataSource dataSource=new FileDataSource("D:\\all\\lecture\\mytable.JPG");
			messageHelper.addAttachment(MimeUtility.encodeText("sendtest.png", "UTF-8","B"), dataSource);
//																					B--> 64바이트로 
//			System.out.println(Arrays.toString(SSLContext.getDefault().getSupportedSSLParameters().getProtocols()));
			
			mailSender.send(message);
			model.addAttribute("check", 1); //정상전달
		} catch (Exception e) {
			System.out.println("EmpController mailTransport() error : "+e.getMessage());
			model.addAttribute("check", 2); //비정상전달
		}
		return "mailResult";
	}
	
	//	Procedure Test 입력화면
	@RequestMapping(value = "writeDeptIn")
	public String writeDeptIn(Model model) {
		System.out.println("EmpController writeDeptIn()");
		return "writeDept3";
	}
	
	@PostMapping(value = "writeDept")
	public String writeDept(DeptVO deptVO, Model model) {
		System.out.println("EmpController writeDept()");
		// DeptVO rDeptVO = es.insertDept(deptVO);	// 일반Service
		es.insertDept(deptVO);	// Procedure Call
		if(deptVO == null) {
			System.out.println("deptVO NULL");
		}else {
			System.out.println("EmpController writeDept() RdeptVO.getOdeptno() : "+deptVO.getOdeptno());
			model.addAttribute("msg", "정상입력");
			model.addAttribute("dept", deptVO);
			
		}
		return "writeDept3";
	}
	
	// interCeptor시작화면
	@RequestMapping(value = "interCeptorForm", method = RequestMethod.GET)
	public String interCeptorForm(Model model) {
		System.out.println("EmpController interCeptorForm()");
		return "interCeptorForm";
	}
	
	//2번?
	//interCeptor 진행 Test
	@RequestMapping(value = "interCeptor1")
	public String interCeptor1(String id, Model model) {
		System.out.println("EmpController interCeptor1()");
		int memCnt=es.memCount(id);
		System.out.println("EmpController interCeptor1() memCnt : "+memCnt);
		// List<EmpDept> listEmp=es.listEmp(empDept);
		// member1의 Count 가져오는 Service수행
		// member.setId("kkk");
		
		model.addAttribute("id", id);
		model.addAttribute("memCnt", memCnt);
		
		return "interCeptor1";
	}
	
	// interCepter 진행
	@RequestMapping(value = "doMemberList")
	public String doMemberList(Model model, HttpServletRequest request) {
		System.out.println("EmpController doMemberList()");
		String ID=(String)request.getSession().getAttribute("ID");
		Member1 member1=null;
		List<Member1> listMem=es.listMem(member1);
		model.addAttribute("ID", ID);
		model.addAttribute("listMem", listMem);
		return "doMemberList";
	}
	
	// interCepter 진행
	@RequestMapping(value = "doMemberWrite", method = RequestMethod.GET)
	public String doMemberWrite(Model model, HttpServletRequest request) {
		System.out.println("EmpController doMemberWrite()");
		String ID=(String)request.getSession().getAttribute("ID");
		model.addAttribute("ID", ID);
		return "doMemberWrite";
	}
	
	
	// Ajax List Test
	@RequestMapping(value = "listEmpAjax2")
	public String listEmpAjax2(Model model) {
		System.out.println("EmpController listEmpAjax2()");
		EmpDept empDept =null;
		List<EmpDept> listEmp = es.listEmp(empDept);
		model.addAttribute("result", "kkk");
		model.addAttribute("listEmp", listEmp);
		return "listEmpAjax2";
	}
	
											// produ~ 구문은 리턴 한글이 가능하게 안하면 아마 ??로 깨질듯
	@RequestMapping(value = "getDeptName", produces = "application/text;charset=UTF-8")
	@ResponseBody	// 나를 호출한 몸통으로, 자바 객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송
	public String getDeptName(int deptno) {
		System.out.println("EmpController getDeptName()");
		String sdeptName = es.deptName(deptno);
		return sdeptName;
	}
	
	

}


























