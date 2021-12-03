package com.oracle.s20210904.wk.dao;

import java.util.List;

import com.oracle.s20210904.wk.model.WkCommDto;

public interface WkCommRepository {

	List<WkCommDto> commList(String main_cat);

}
