package 구구단;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gugudan {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		String [] splitvalue = num.split(",");
		
		int num1 = Integer.parseInt(splitvalue[0]);
		int num2 = Integer.parseInt(splitvalue[1]);
		
		for(int i = 2; i <= num1; i++) {
			for(int j = 1; j <= num2;j++) {
				System.out.println(i + " x " + j + " = " + i*j);
			}
			System.out.println();
		}
	}
}