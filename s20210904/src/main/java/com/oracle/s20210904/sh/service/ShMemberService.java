package com.oracle.s20210904.sh.service;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Member;


public interface ShMemberService {

	 int joinmember(Member member);
   	 int joincom(Company company);

	
	
}
