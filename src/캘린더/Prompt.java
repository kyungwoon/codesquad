package 캘린더;

import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록  ");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
//		System.out.println("명령 (1, 2, 3, h, q)");
	}

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
		printMenu();

		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {

			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = sc.next();
			if (cmd.equals("1")) {
				cmdRegister();
			} else if (cmd.equals("2")) {
				cmdSearch();
			} else if (cmd.equals("3")) {
				cmdCal(sc, cal);
			} else if (cmd.equals("h")) {
				printMenu();
			} else if (cmd.equals("q")) {
				System.out.println("Have a nice day!");
				break;
			}

		}
	}

	private void cmdCal(Scanner sc, Calendar c) {
		int month = 0;
		int year = 0;
		System.out.println("년도를 입력하세요.");
		System.out.print(PROMPT);
		year = sc.nextInt();

		System.out.println("월을 입력하세요.");
		System.out.print(PROMPT);
		month = sc.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		c.printSampleCalendar(year, month);
		System.out.println();

	}

	private void cmdSearch() {
		// TODO Auto-generated method stub

	}

	private void cmdRegister() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
