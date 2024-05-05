import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		// List ↑ class 타입 매개변수 = Article 타입의 객체를 저장하는 ArrayList<>();
		// 객체가 인덱스로 관리되며 배열과 다른점은 저장 용량이 초과하게 되면
		// 자동으로 양이 늘어나게 된다.
		Scanner sc = new Scanner(System.in);
		int indexNumber = 0;
		System.out.println("== 프로그램 시작 ==");

		while (true) {
			// System = 클래스 , in static 변수

			System.out.print("명령어) ");

			String cmd = sc.nextLine().trim();

			if (cmd.equals("종료")) {
				break;
			} else if (cmd.equals("article list")) {

				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다.");

				}
				System.out.println("번호 | 제목 | 내용");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i); // List를 통해서 저장되어있는 내용을 Article 객체를 통해서 조립하는 상황
					System.out.printf("%d    | %s    | %s\n", article.indexNumber, article.title, article.contents);
				}

			} else if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();

				System.out.printf("내용 : ");
				String contents = sc.nextLine().trim();

				++indexNumber;
				Article article = new Article(title, contents, indexNumber);
				articles.add(article);

				System.out.printf("%d번 글이 생성 되었습니다.", indexNumber);

			} else if (cmd.length() == 0) {
				System.out.println("알맞는 명령어를 적어주세요");
				// 1이라고만 적을시 lenhth()는 문자열의 길이를 재기 때문에 오류로 판단하는것을 알았다.
			} else if (cmd.equals("article delete")) {
				System.out.println("삭제할 글 번호를 적어 주세요");

				System.out.print("번호 : ");
				String splitNumber = sc.nextLine();
				
				int ArticleNumber = (Integer.parseInt(splitNumber.substring(0, 1)));
						
				if (ArticleNumber > articles.size()) {
					System.out.println("작성된 글이 없습니다.");
					break;
				}else if (ArticleNumber == 0) {
					System.out.println("존재하지 않는 번호입니다.");
				}
				articles.remove((ArticleNumber - 1));
				// 정수 글번호를 어떻게 index로 변환해서 값을 넣어 줄 수 있을까?
				//1) 정수에 -1을 한다. = 0번을 할시 제외시켜야함
			} else if (cmd.equals("test")) {

				for (int i = 1; i < 4; i++) {

					String title = "태스트" + i;
					String contents = "태스트" + i;

					++indexNumber;
					Article article = new Article(title, contents, indexNumber);
					articles.add(article);
				}

			}

			else {
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
