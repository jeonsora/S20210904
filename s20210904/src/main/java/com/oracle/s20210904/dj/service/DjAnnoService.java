package com.oracle.s20210904.dj.service;

import java.util.List;

import com.oracle.s20210904.comm.model.Announce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.comm.model.Company;

public interface DjAnnoService {

	Company comInfoList(String com_id);

	List<Comm> mainCatList1();

	List<Comm> mainCatList2(); // 리스트 1,2는 각각 쿼리용으로 만들었으나 미사용.

	List<Comm> mainCatList();

	void annoWriting(Announce anno);

}
