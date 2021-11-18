package com.oracle.sBootMybatis03.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "member2")
@Table(name = "member3")
public class Member {
	@Id
	private Long id;
	private String name;

}
