package com.oracle.s20210904.sh.dao;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.User;

public interface ShMemberDao {

	int joinuser(User user);
	int joincom(Company company);

}
