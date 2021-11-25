package com.oracle.s20210904.comm.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
	
	private int currentPage = 1;
	private int rowPage = 5;
	private int pageBlock = 5;
	private int start;
	private int end;
	private int startPage;
	private int endPage;
	private int total;
	private int totalPage;
	
	public Paging(int total, String currentPage1) {
		this.total = total;
		if(currentPage1 == null) {
			this.currentPage = 1;
		} else {
			this.currentPage = Integer.parseInt(currentPage1);
		}
		
		start = (currentPage -1)*rowPage +1; // 시작시 1
		end = start + rowPage -1; // 5
		totalPage = (int) Math.ceil((double)total / rowPage); // 2
		startPage = currentPage - (currentPage - 1) % pageBlock; // 1
		endPage = startPage + pageBlock -1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
				
	}

}
