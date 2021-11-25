package com.oracle.s20210904.sh.dao;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Member;


public interface ShMemberDao {

	int joinmember(Member member);
	int joincom(Company company);

}
