package com.koreaIT.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.BAM.controller.ArticleController;
import com.koreaIT.BAM.controller.MemberController;
import com.koreaIT.BAM.dto.Article;
import com.koreaIT.BAM.util.Util;

public class App {

	public App() {
		
	}

	public void run() {
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		
		memberController.makeTestMemberData();
		articleController.makeTestArticleData();
		
		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (cmd.equals("member join")) {
				memberController.doJoin();
			} else if (cmd.equals("article write")) {
				articleController.articlewrite(cmd);
			} else if (cmd.startsWith("article list")) {
				articleController.articlelist(cmd);
			} else if (cmd.startsWith("article detail ")) {
				articleController.articledetail(cmd);
			} else if (cmd.startsWith("article modify ")) {
				articleController.articlemodify(cmd);
			} else if (cmd.startsWith("article delete ")) {
				articleController.articledelete(cmd);
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}

		}

		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}

}