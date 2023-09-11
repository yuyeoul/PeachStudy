package BOJ_11729_하노이탑이동순서;

import java.util.Scanner;

public class Main {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 원판의 갯수
		int k = (int) Math.pow(2, n) - 1; // 반복횟수
		Hanoi(n, "1", "2", "3");
		System.out.println(k);
		System.out.println(sb);

	} // main

	// 1-> 2
	public static void Hanoi(int n, String start, String sub, String end) {

		// 기저파트
		// 원판의 갯수가 1개가 되면 그대로 옮기면 끝

		if (n == 1) {
			sb.append(start + " " + end + "\n");

		} else {
			// 재귀파트
			// 1번째에 있는 원반을 3번째를 걸쳐 2번째로 옮긴다.
			Hanoi(n - 1, start, end, sub);
			// 1번째에 있는 원반을 3번째로 옮긴다.
			sb.append(start + " " + end + "\n");

			// 2번째에 있는 원반을 1번을 걸쳐 3번째로 옮긴다.
			Hanoi(n - 1, sub, start, end);

		}

	} // Hanoi method

} // class
