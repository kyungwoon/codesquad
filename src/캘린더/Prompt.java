package 캘린더;

import java.util.Scanner;

public class Prompt {
	/**
	 * 
	 * @param week 요일명
	 * @return 0~6 (0 == Sunday, 6 == Saturday)
	 */

	public int weekDay(String week) {
		if (week.equals("su")) {
			return 0;
		} else if (week.equals("mo")) {
			return 1;
		} else if (week.equals("tu")) {
			return 2;
		} else if (week.equals("we")) {
			return 3;
		} else if (week.equals("th")) {
			return 4;
		} else if (week.equals("fr")) {
			return 5;
		} else if (week.equals("sa")) {
			return 6;
		} else {
			return 0;
		}
	}

	private final static String PROMPT = "cal> ";

	public void runPrompt() {

		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;
		int year = 0;
		int week = 0;
		while (true) {
			System.out.println("년도를 입력하세요. (-1입력 시 종료)");
			System.out.print(PROMPT);
			year = sc.nextInt();
			if (year == -1) {
				break;
			}
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			month = sc.nextInt();
			System.out.println("요일을 입력하세요.(su,mo,tu,we,th,fr,sa)");
			String strweekday = sc.next();
			week = weekDay(strweekday);
			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}

			cal.printSampleCalendar(year, month, week);
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
