package BOJ_13397_구간나누기2;

import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static int n;
	public static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		// 배열 생성
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int start = 0;
		int end = 10000;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (isPossible(mid)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start);
		
	}
	
	public static boolean isPossible(int mid) {
		int count = 1;
		int max = arr[0];
		int min = arr[0];
		for (int i = 1; i < n; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
			
			if (max - min > mid) {
				max = arr[i];
				min = arr[i];
				count++;
			}
		}
		if (count > m) {
			return false;
		}
		return true;
	}
}
