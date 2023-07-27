package algorithm;

import java.util.Scanner;

public class BOJ_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int number = 1;
		int i = 2;
		while(number<input) {
			number+= (i-1)*6;
			i++;
		}
		System.out.println(i-1);
	}
}
