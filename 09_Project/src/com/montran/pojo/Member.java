package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="member_master")
public class Member {
	@Id
	@Column(name="member_code")
	private String memberCode;
	
	@Column(name="Member_Name")
	private String name;
	
	@Column(name="member_type")
	private String memberType;
	
	@Column(name="No_of_copies")
	private int noOfCopiesIssued;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String memberCode, String name, String memberType, int noOfCopiesIssued) {
		super();
		this.memberCode = memberCode;
		this.name = name;
		this.memberType = memberType;
		this.noOfCopiesIssued = noOfCopiesIssued;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public int getNoOfCopiesIssued() {
		return noOfCopiesIssued;
	}

	public void setNoOfCopiesIssued(int noOfCopiesIssued) {
		this.noOfCopiesIssued = noOfCopiesIssued;
	}

	@Override
	public String toString() {
		return "Member [memberCode=" + memberCode + ", name=" + name + ", memberType=" + memberType
				+ ", noOfCopiesIssued=" + noOfCopiesIssued + "]";
	}

	
	
}
