package BOJ_11399_ATM;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 스터디 개인문제: ATM

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 수
		int time = 0; // 걸리는 시간

		int[] p = new int[N]; // 각 사람이 ATM을 뽑는데 걸리는 시간을 가진 배열

		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();

		}
//		System.out.println(Arrays.toString(p)); // p 배열 확인

//		Arrays.sort(p);
		sort(p);

		for (int i = 0; i < N; i++) { // 1번 사람은 자기 시간만큼
			for (int j = 0; j <= i; j++) { // 2번 사람은 1번사람+자기자신만큼 .. 늘어나는 시간을 더해주는 것.
				time += p[j];
			}

		}
		System.out.println(time);

	}

	// sort 배열 만들기
	public static int[] sort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}

			}

		}

		return arr;
	}

}
