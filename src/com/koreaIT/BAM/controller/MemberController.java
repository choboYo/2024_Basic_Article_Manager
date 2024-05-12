package com.koreaIT.BAM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.BAM.dto.Article;
import com.koreaIT.BAM.dto.Member;
import com.koreaIT.BAM.util.Util;

public class MemberController {

	private Scanner sc;
	private List<Member> members;
	private int lastMemberId;

	public MemberController(Scanner sc) {
		this.sc = sc;
		this.members = new ArrayList<>();
		this.lastMemberId = 1;
	}

	public void doJoin() {
		String loginId = null;
		String loginPw = null;
		String loginPwChk = null;
		String name = null;

		while (true) {
			System.out.printf("아이디 : ");
			loginId = sc.nextLine().trim();

			if (loginId.length() == 0) {
				System.out.println("아이디는 필수 입력정보입니다");
				continue;
			}

			if (loginIdDupChk(loginId) == false) {
				System.out.println("[" + loginId + "] 은(는) 이미 사용중인 아이디입니다");
				continue;
			}

			System.out.println("[" + loginId + "] 은(는) 사용가능한 아이디입니다");
			break;
		}

		while (true) {
			System.out.printf("비밀번호 : ");
			loginPw = sc.nextLine().trim();

			if (loginPw.length() == 0) {
				System.out.println("비밀번호는 필수 입력정보입니다");
				continue;
			}

			System.out.printf("비밀번호 확인 : ");
			loginPwChk = sc.nextLine().trim();

			if (loginPw.equals(loginPwChk) == false) {
				System.out.println("비밀번호를 다시 입력해주세요");
				continue;
			}
			break;
		}

		while (true) {
			System.out.printf("이름 : ");
			name = sc.nextLine().trim();

			if (name.length() == 0) {
				System.out.println("이름은 필수 입력정보입니다");
				continue;
			}
			break;
		}

		Member member = new Member(lastMemberId, Util.getDateStr(), loginId, loginPw, name);
		members.add(member);

		System.out.println("[" + loginId + "] 회원님의 가입이 완료되었습니다");
		lastMemberId++;
	}

	public void dologin() {
		while (true) {
			if(MemberController.getLoginedId() != null || MemberController.getLoginedId().length() != 0) {
				System.out.println("로그인 상태입니다.");	
				break;
			}
						
			System.out.printf("아이디 : ");
			String loginedId = sc.nextLine().trim();
			
			if (loginedId.length() == 0) {
				System.out.println("아이디는 필수 입력정보입니다");
				continue;
			} else if(loginedIdChk(loginedId) == false) {
				System.out.println("회원 가입 후 이용해 주세요");
				break;
			}
			
			System.out.printf("비밀번호 : ");
			String loginedPw = sc.nextLine().trim();

			if (loginedPw.length() == 0) {
				System.out.println("비밀번호는 필수 입력정보입니다");
				continue;
			} else if(loginedPwChk(loginedPw) == false) {
				System.out.println("회원 가입 후 이용해 주세요");
				break;
			}

			
		System.out.println(loginedId + "님 로그인 되었습니다.");
		
		
		}
	}

	

	private static String getLoginedId() {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean loginIdDupChk(String loginId) {
		for (Member member : members) {
			if (member.getLoginId().equals(loginId)) {
				return false;
			}
		}
		return true;
	}

	private boolean loginedIdChk(String loginedId) {
		for (Member member : members) {
			if (member.getLoginId() == loginedId) {
				return true;
			}
		}

		return false;
	}
	
	private boolean loginedPwChk(String loginedPw) {
		for (Member member : members) {
			if (member.getLoginPw() == loginedPw) {
				return true;
			}
		}

		return false;
	}
	
	
	
	public void makeTestMemberData() {
		System.out.println("테스트용 회원 데이터를 3개 생성했습니다");

		for (int i = 1; i <= 3; i++) {
			members.add(new Member(lastMemberId++, Util.getDateStr(), "user" + i, "user" + i, "유저" + i));
		}
	}

}