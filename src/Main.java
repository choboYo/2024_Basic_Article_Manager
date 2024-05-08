import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	static List<Article> articles = new ArrayList<>();

	static int indexNumber = 1;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int indexNumber = 1;
		
		System.out.println("== 프로그램 시작 ==");

		makeTestData();

		while (true) {
			// System = 클래스 , in static 변수

			System.out.print("명령어) ");

			String cmd = sc.nextLine().trim();

			if (cmd.equals("종료")) {

				break;
			} else if (cmd.length() == 0) {

				System.out.println("알맞는 명령어를 적어주세요");

			} else if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();

				System.out.printf("내용 : ");
				String contents = sc.nextLine().trim();

				Article article = new Article(title, contents, indexNumber, Util.getDateStr(), 0);
				articles.add(article);

				System.out.printf("%d번 글이 생성 되었습니다.\n", indexNumber);
				indexNumber++;

			} else if (cmd.equals("article list")) {

				if (articles.size() == 0) {
					System.out.println("존재한는 게시글이 없습니다.");

				}
				System.out.println("번호 | 제목  |   날짜           |조회수");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d    | %s   |%s |%d\n", article.indexNumber, article.title, article.regDate,
							article.views);
				}
			} else if (cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");

				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다");
					continue;
				}

				Article foundArticle = null;

				for (Article article : articles) {
					if (article.indexNumber == id) {
						foundArticle = article;
						break;
					}
				}
				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다");
					continue;
				}
				foundArticle.increaseViewCnt();
				System.out.println("번호 : " + foundArticle.indexNumber);
				System.out.println("날짜 : " + foundArticle.regDate);
				System.out.println("제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.contents);
				System.out.println("조회수 : " + foundArticle.views);

			} else if (cmd.startsWith("article modify ")) {
				String[] cmdBits = cmd.split(" ");

				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다");
					continue;
				}

				Article foundArticle = null;

				for (Article article : articles) {
					if (article.indexNumber == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다");
					continue;
				}

				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("수정할 내용 : ");
				String contents = sc.nextLine().trim();

				foundArticle.title = title;
				foundArticle.contents = contents;

				System.out.println(id + "번 게시물이 수정되었습니다");

			} else if (cmd.startsWith("article delete ")) {
				String[] cmdBits = cmd.split(" ");

				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다");
					continue;
				}

				Article foundArticle = null;

				for (Article article : articles) {
					if (article.indexNumber == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다");
					continue;
				}

				articles.remove(foundArticle);

				System.out.println(id + "번 게시물이 삭제되었습니다");

			} else {

				System.out.println("존재하지 않는 명령어 입니다.");

			}

		}

		sc.close();

		System.out.println("== 프로그램 종료==");
	}

	private static void makeTestData() {
		System.out.println("테스트용 게시글 데이터를 5개 생성했습니다");

		for (int i = 1; i <= 5; i++) {
			articles.add(new Article("제목" + i, "내용" + i, indexNumber++, Util.getDateStr(), i * 10));
		}
	}

}

class Article {

	String title;
	String contents;
	String regDate;
	int indexNumber;
	int views;

	Article(String title, String contents, int indexNumber, String regDate, int views) {

		this.title = title;
		this.contents = contents;
		this.indexNumber = indexNumber;
		this.regDate = regDate;
		this.views = views;
	}

	void increaseViewCnt() {
		this.views++;
	}

}