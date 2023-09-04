import java.util.Scanner;
import java.util.Stack;

public class BOJ_25918(2) {
	// 스택으로 푼 코드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] S = sc.next().toCharArray();
		// 정답
		int ans = 0;
		// 괄호 정상 유무 및 날짜 수를 구하기 위한 변수
		int cnt = 0;
		// 괄호 갯수가 홀수개면 -1 출력
		if (S.length % 2 != 0) {
			System.out.println(-1);
			return;
		}

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < S.length; i++) {
			// ( 괄호를 만났을 때 cnt++
			if (S[i] == '(') {
				cnt++;
				// 비어있거나 stack의 제일 최근에 들어온 값과 동일할 때 스택에 더해준다
				if (stack.isEmpty() || stack.peek() == '(') {
					stack.add(S[i]);
					// 그 외의 경우 괄호가 짝지어지는 것 = pop처리
				} else if (stack.peek() == ')') {
					stack.pop();
				}
				// ) 괄호를 만났을 때 cnt--
			} else if (S[i] == ')') {
				cnt--;
				// 비어있거나 stack의 제일 최근에 들어온 값과 동일할 때 스택에 더해준다
				if (stack.isEmpty() || stack.peek() == ')') {
					stack.add(S[i]);
					// 그 외의 경우 괄호가 짝지어지는 것 = pop처리
				} else if (stack.peek() == '(') {
					stack.pop();
				}
			}
			// cnt 절대값의 최대값이 최소 일 수.
			if (Math.abs(cnt) > ans) {
				ans = Math.abs(cnt);
			}
		}

		// 괄호가 정상적으로 짝지어 않은 경우 -1 출력
		if (cnt != 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}
}