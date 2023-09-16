import java.util.Scanner;

public class BOJ_19949 {
	// 실제 정답
	public static int[] answers = new int[10];
	// 내가 찍은 답안
	public static int[] myInput = new int[10];
	// 구해야하는 값(5개 이상 맞는 경우의 수)
	public static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 실제 정답 값 할당하기
		for (int i = 0; i < 10; i++) {
			answers[i] = sc.nextInt();
		}
		
		randomAnswer(0);
		System.out.println(ans);

	}

	// 문제 답안 경우의 수 구하기 매서드
	public static void randomAnswer(int i) {
		// 문제수 10번을 넘어가는 경우 몇개 맞췄는지 검증
		if (i >= 10) {
			int cnt = 0;
			for (int j = 0; j < 10; j++) {
				if (myInput[j] == answers[j]) {
					cnt++;
					// 5개 이상 맞췄다면 return
					if (cnt >= 5) {
						ans++;
						return;
					}
				}
			}
			return;
		}
		// 각 문제별로 경우의 수 다 구해주기
		for (int j = 1; j <= 5; j++) {
			myInput[i] = j;
			// 연속된 3문제의 값이 동일하다면 경우의 수 계산하지 않고 그냥 넘어가기
			if (i >= 2 && myInput[i - 2] == myInput[i - 1] && myInput[i - 1] == myInput[i]) {
				continue;
			}
			randomAnswer(i + 1);
		}
	}
}
