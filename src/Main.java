import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("== 프로그램 시작==");

		while (true) {
			// System = 클래스 , in static 변수

			System.out.println("명령어)");

			String cmd = sc.nextLine();

			if (cmd.equals("종료")) {
				break;
			}
		
		}
		
		sc.close();
		
		System.out.println("== 프로그램 종료==");	
	}

}
