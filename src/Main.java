import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int indexNumber = 1;
		System.out.println("== 프로그램 시작 ==");

		while (true) {
			// System = 클래스 , in static 변수

			System.out.print("명령어) ");

			String cmd = sc.nextLine().trim();

			if (cmd.equals("종료")) {
				break;
			} else if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();

				System.out.printf("내용 : ");
				String contents = sc.nextLine().trim();

				Article article = new Article(title, contents, indexNumber);
				articles.add(article);

				System.out.printf("%d번 글이 생성 되었습니다.\n", indexNumber);
				indexNumber++;

			} else if (cmd.equals("article list")) {

				if (articles.size() == 0) {
					System.out.println("존재한는 게시글이 없습니다.");

				}
				System.out.println("번호 | 제목 | 내용");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d    | %s    | %s\n", article.indexNumber, article.title, article.contents);
				}
			} else if (cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");

				int id = Integer.parseInt(cmdBits[2]);

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

				System.out.println("번호 : " + foundArticle.indexNumber);
				System.out.println("날짜 : ~~~");
				System.out.println("제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.contents);

			}

			else if (cmd.length() == 0) {
				System.out.println("알맞는 명령어를 적어주세요");
			} else {
				System.out.println("존재하지 않는 명령어 입니다.");

			}

		}

		sc.close();

		System.out.println("== 프로그램 종료==");
	}

}

class Article {

	String title;
	String contents;
	int indexNumber;

	Article(String title, String contents, int indexNumber) {

		this.title = title;
		this.contents = contents;
		this.indexNumber = indexNumber;

	}

}