package com.oracle.s20210904.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210904.ds.dao.DsAdminDao;

@Service
public class DsAdminServiceImpl implements DsAdminService {
	@Autowired
	DsAdminDao dsAdminDao;
	
}
