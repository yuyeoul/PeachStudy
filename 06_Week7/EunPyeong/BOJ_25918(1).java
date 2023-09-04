import java.util.Scanner;

public class BOJ_25918(1) {
	// 스택 없이 푼 코드
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
		// ( 괄호 만나면 cnt++ , ) 괄호 만나면 cnt--
		for (int i = 0; i < S.length; i++) {
			if (S[i] == '(') {
				cnt++;
			} else {
				cnt--;
			}
			// cnt의 절대값의 최대값 = 최소 날짜수 
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