package BOJ_17413_단어뒤집기2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_17413 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 뒤집을 문자열 받기
		String str = sc.nextLine();
		boolean flag = false; // 괄호 안에 있는 문자인지 아닌지 판별
		Stack<Character> stack = new Stack<>(); // 스택 자료 구조
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				// <가 시작하면 스택에 아무것도 없을때까지 뒤에서부터 뽑아서 출력한다.
				while (!(stack.isEmpty())) {
					System.out.print(stack.pop());
				}
				flag = true; // 괄호 시작이므로 true로 설정
				System.out.print(str.charAt(i)); 
			} else if (str.charAt(i) == '>') {
				flag = false;
				System.out.print(str.charAt(i));
			} else if (flag == true) {
				// 괄호안에 있다면 그냥 출력
				System.out.print(str.charAt(i));
			} else if (str.charAt(i) != ' '){
				// 괄호 안에 있는 문자가 아니면 stack에 쌓음
				stack.push(str.charAt(i));
			} else {
				// 괄호안에 있는 문자도 아니면서 공백이면 stack에 있는 것들을 뒤에서부터 뽑아서 출력
				while (!(stack.isEmpty())) {
					System.out.print(stack.pop());
				}
				// 공백 출력
				System.out.print(str.charAt(i));
			}
		}
		
		// 마지막에 stack에 무엇이 있다면 안에있는 것들을 출력
		while (!(stack.isEmpty())) {
			System.out.print(stack.pop());
		}
	}
}
