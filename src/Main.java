import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int indexNumber = 0;
		System.out.println("== 프로그램 시작 ==");

		while (true) {
			// System = 클래스 , in static 변수

			System.out.println("명령어)");

			String cmd = sc.nextLine().trim();

			if (cmd.equals("종료")) {
				break;
			} else if (cmd.equals("article list")) {

				System.out.println("게시물이 없습니다.");
			} else if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();

				System.out.printf("내용 : ");
				String contents = sc.nextLine().trim();


				Article article = new Article(title, contents, indexNumber);
				articles.add(article);
				
				indexNumber++;
				System.out.printf("%d번 글이 생성 되었습니다.", indexNumber);

			} else if (cmd.length() == 0) {
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
	int	indexNumber;
	
	Article (String title, String contents, int indexNumber) {
		
		this.title = title;
		this.contents = contents;
		this.indexNumber = indexNumber;
		
	}
	
	
}
