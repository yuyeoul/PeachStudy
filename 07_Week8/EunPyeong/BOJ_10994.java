import java.io.IOException;
import java.util.Scanner;

public class BOJ_10994 {
	public static String[][] arr;
	public static int length;
	public static int N;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// N번일 때 배열의 길이
		length = N * 4 - 3;
		// 배열 생성
		arr = new String[length][length];
		// 기본 값으로 공백 넣어주기
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				arr[i][j] = " ";
			}
		}
		
		star(0, length);
		// 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	public static void star(int M, int length) {
		if (length <= M) {
			return;
		}

		for (int i = M; i < length; i++) {
			// 맨 윗줄
			arr[M][i] = "*";
			// 맨 아랫줄
			arr[length - 1][i] = "*";
			// 왼쪽줄 
			arr[i][M] = "*";
			// 오른쪽줄 
			arr[i][length - 1] = "*";
		}

		star(M + 2, length - 2);
	}
}
