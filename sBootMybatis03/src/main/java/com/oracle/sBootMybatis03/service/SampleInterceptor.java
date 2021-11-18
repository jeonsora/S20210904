package com.oracle.sBootMybatis03.service;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SampleInterceptor implements HandlerInterceptor {
	public SampleInterceptor() {
		System.out.println("SampleInterceptor SampleInterceptor()");
	}
	
	//3번
	@Override
	public void postHandle(HttpServletRequest request, 
			 			   HttpServletResponse response,
			 			   Object handler,
			 			   ModelAndView modelAndView) throws Exception {
		System.out.println("SampleInterceptor postHandle()");
		String ID=(String)modelAndView.getModel().get("id");
		int memCnt=(Integer)modelAndView.getModel().get("memCnt");
		System.out.println("SampleInterceptor postHandle() memCnt : "+memCnt);
		if(memCnt<1) {
			request.getSession().setAttribute("ID", ID);
			// User가 존재하지 않으면 User interCepter Page(회원등록)이동
			response.sendRedirect("doMemberWrite");
		}else {	//정상 Login User
			request.getSession().setAttribute("ID", ID);
			// User가 존재하면 User interCepter Page(회원List)이동
			response.sendRedirect("doMemberList");
		}
	}
	
	// 1번
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response,
							 Object handler) {
		System.out.println("SampleInterceptor preHandle()");
		HandlerMethod method=(HandlerMethod) handler;
		Method methodObj=method.getMethod();
		System.out.println("Bean : "+method.getBean());
		System.out.println("Method : "+methodObj);
		
		return true;
	}
}



















