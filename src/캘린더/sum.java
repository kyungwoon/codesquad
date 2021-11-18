package 캘린더;

import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		//입력 : 키보드로 두 수의 입력을 받는다.
		//출력 : 화면에 두 수의 합을 출력한다.
		
		System.out.println("두 수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
//		System.out.println("두 수의 합은 " + (num1 + num2) + "입니다.");
		System.out.printf("두 수의 합은 %d입니다.",num1+num2);
		sc.close();
	}
}
