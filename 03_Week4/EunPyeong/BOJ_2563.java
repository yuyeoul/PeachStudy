import java.util.Scanner;

public class BOJ_2563 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 색종이 갯수
		int N = sc.nextInt();
		// 도화지
		int[][] paper = new int[101][101];
		// 시작하는 x 좌표 지점
		int[] x = new int[N];
		// 시작하는 y 좌표 지점
		int[] y = new int[N];
		// x,y 배열 값 할당
		for (int i = 0; i < N; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		// 색종이가 덮힌 영역에 +1 해주기
		for (int i = 0; i < x.length; i++) {
			for (int j = x[i]; j < x[i] + 10; j++) {
				for (int k = y[i]; k < y[i] + 10; k++) {
					paper[j][k]++;
				}
			}
		}
		// 정답 담을 변수
		int answer = 0;
		// 0이 아닌 곳 숫자 세기
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if (paper[i][j] != 0) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
