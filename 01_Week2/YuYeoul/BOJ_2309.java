package Boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int a = 0;
		int b = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					a = arr[i];
					b = arr[j];
				}
			}
		}
		Arrays.sort(arr);

		for (int i = 0; i < 9; i++) {
			if (arr[i] != a && arr[i] != b) {
				System.out.println(arr[i]);
			}
			
		}

	}

}
