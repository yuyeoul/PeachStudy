import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] h = new int[9];
		int sum = 0; // 키들의 합
		for (int i = 0; i < h.length; i++) {
			h[i] = sc.nextInt();
			sum += h[i];
		}
		int target = sum - 100; // 구하려는 수
		int[] index = new int[2];
		// 2개의 수를 조합해서 target과 같으면 해당하는 키의 index를 저장
		for (int i = 0; i < h.length - 1; i++) {
			int temp = h[i];
			index[0] = i;
			for (int j = i; j < h.length; j++) {
				if (temp + h[j] == target) {
					index[1] = j;
					break;
				}
			}
			if (index[1] != 0) {
				break;
			}
		}
		int[] result = new int[7];
		int result_i = 0;
		for (int i = 0; i < h.length; i++) {
			// index에 해당하지 않는 값들을 result에 저장
			if (!(i == index[0] || i == index[1])) {
				result[result_i++] = h[i];
			}
		}
		// result를 오름차순으로 정렬
		Arrays.sort(result);
		for (int r : result) {
			System.out.println(r);
		}
		sc.close();
	}
}
