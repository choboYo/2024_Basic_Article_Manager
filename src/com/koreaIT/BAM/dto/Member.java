package com.koreaIT.BAM.dto;

public class Member {
	private int id;
	private String regDate;
	private String loginId;
	private String loginPw;
	private String name;
	private String loginedId;
	private String loginedPw;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getLoginedId() {
		return loginedId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setLoginedId(String loginedId) {
		this.loginedId = loginedId;
	}
	
	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getLoginedPw() {
		return loginedPw;
	}
	
	public void setLoginedPw(String loginedPw) {
		this.loginedPw = loginedPw;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Member(int id, String regDate, String loginId, String loginPw, String name) {
		this.id = id;
		this.regDate = regDate;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.name = name;
	}
}