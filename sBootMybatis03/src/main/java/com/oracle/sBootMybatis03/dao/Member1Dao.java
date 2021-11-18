package com.oracle.sBootMybatis03.dao;

import java.util.List;

import com.oracle.sBootMybatis03.model.Member1;

public interface Member1Dao {
	int memCount(String id);	// Member1의 Count

	List<Member1> listMem();
}
