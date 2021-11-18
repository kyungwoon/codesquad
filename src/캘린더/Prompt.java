package 캘린더;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {

		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		int input = 0;
		while (true) {

			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			input = sc.nextInt();
			if (input == -1) {
				break;
			} else if (input > 12) {
				continue;
			}
			cal.printSampleCalendar(input);
			System.out.println();

		}
		System.out.println("Have a nice day!");
		sc.close();
	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
