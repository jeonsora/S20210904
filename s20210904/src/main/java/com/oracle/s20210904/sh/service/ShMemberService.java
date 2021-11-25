package com.oracle.s20210904.sh.service;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.User;

public interface ShMemberService {

	 int joinuser(User user);
   	 int joincom(Company company);

	
	
}
