package BOJ_1158_요세푸스문제;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 전체 인원
		int n = sc.nextInt();
		// k번째 제거
		int k = sc.nextInt();
		
		// 배열에 1 ~ N까지 값들을 넣어준다.
		List<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		System.out.print("<");
		while (queue.size() > 1) {
			Collections.rotate(queue, -(k - 1));
			System.out.print(queue.remove(0) + ", ");
		}
		
		System.out.print(queue.remove(0) + ">");
	}
}
