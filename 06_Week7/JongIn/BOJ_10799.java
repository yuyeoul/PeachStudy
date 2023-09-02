package BOJ_10799_쇠막대기;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Stack<Character> stack = new Stack<>(); // 괄호 넣을 스택

		Scanner sc = new Scanner(System.in);

		String str = sc.next(); // 문자열 입력받기 (괄호 내용)
		int N = str.length(); // 입력받은 문자열의 길이
		int count = 0;

		for (int i = 0; i < N - 1; i++) {

			// 만약 이번에 확인하는 것이 '(' 열린 괄호일 때
			if (str.charAt(i) == '(') {
				// 다음에 오는 것이 닫힌 괄호일 경우 = 레이저
				if (str.charAt(i + 1) == ')') {
					count += stack.size();
//					System.out.println(count); // count 확인중
				}
				// 다음에 오는 것이 닫힌 괄호가 아니라 열린 괄호인 경우에 (나머지 경우) = 쇠막대기
				else if (str.charAt(i + 1) == '(') {
					// 스택에 '('를 넣어서 쇠막대기로 생각할 수 있다.
					stack.push(str.charAt(i));
				}
				// 만약에 이번에 해당하는 경우에 닫힌 괄호라면
			} else { // 레이저가 아닌 닫힌 괄호일 때는 쇠막대기이가 끝나는 상황밖에 없으므로 스택에서 pop.
				// 단, 다음 경우에도 닫힌 괄호가 오는 경우에만 쇠막대기가 끝나는 경우이고, 끝날 때 남은 조각 count를 1개 더해줘야한다.
				if (!stack.isEmpty() && str.charAt(i+1) == ')') {
					stack.pop();
					count += 1;
				}
			}
			
			
		} // 문자열 길이만큼 반복하기 끝

		System.out.println(count);

		// 스택 남았는지 확인
//		for (int i = 0; i < stack.size(); i++) {
//			System.out.println(stack.get(i));
//		}

	} // main
}
