package BOJ_1158_요세푸스문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 인원 수
		int k = sc.nextInt(); // k번째 사람이 계속 빠짐

		ArrayList<Integer> list = new ArrayList<>(); // 입력되는 배열
		ArrayList<Integer> sortList = new ArrayList<>(); // 정렬된 결과값 배열

		for (int i = 1; i <= N; i++) {
			list.add(i); // 사람 인원 수 만큼 리스트 추가해주기
		}
//		System.out.println(list);

		int idx = 0;
		while (list.size() > 0) { // list 크기가 = 0이 되면 더 이상 할 필요 없음.
			// idx = 0, k = 3일 때
			idx = (idx + k - 1) % list.size(); // 다음에 빠질 사람의 인덱스 계산
			sortList.add(list.get(idx)); // 현재 인덱스의 사람을 정렬 리스트에 추가
			list.remove(idx); // 사람을 리스트에서 제거

//            System.out.println(sortList); // 확인용

		}

		System.out.print("<");
		// 하하.. 제출하는 거 몰라서 지피티한테 물어봄
		for (int i = 0; i < sortList.size(); i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(sortList.get(i));
		}
		System.out.print(">");

		// 왜 안되는지 모르겠음..
//        while (list.size() > 0) {
//			for (int j = 0; j < k - 1; j++) { // k가 3인 경우 2번만 뒤로 보내면 됨
//				list.add(list.get(j)); // 1번째, 2번째의 값을 맨 뒤에 추가하고
//				list.remove(j); // 1번째, 2번째 제거하면	
//			}
//			sortList.add(list.get(0)); // 가장 앞에 나와있는 3번째꺼는 sortList에 더해주고
//			list.remove(0); // 다시 삭제해주기
//			System.out.println(sortList);
//		}

	}
}
