import java.util.Scanner;

public class BOJ_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 계단의 개수

        int[] stair = new int[301]; // 계단의 개수 300이하
        int[] score = new int[301]; // 니까 점수 계산도 301로 하자
        for (int i = 1; i <= N; i++)
            stair[i] = sc.nextInt(); // 각 계단의 점수 입력 받음

        score[1] = stair[1]; // 첫 번째는 무조건 밟아야 함
        score[2] = stair[1] + stair[2]; // 두 번째 계단 밟으면 생기는 점수
        score[3] = Math.max(stair[1], stair[2]) + stair[3]; // 세 번째 계단까지의 최대 점수는 첫 번째와 두 번째 중 큰 값에 세 번째 계단의 점수를 더한 값

        for (int n = 4; n <= N; n++) {
            // n-3을 밟고 n-1번 계단을 밟고 오는 경우, n-2번을 밟고 오는 경우 -> 2가지 (연속 3계단 불가하기 때문)
        	// 마지막은 무조건 밟아야하니까 위 두 가지 중 큰 값 + 현재 계단 값 더하면 됨
        	// 계단의 최대 점수와 n-2 계단의 최대 점수 중 큰 값을 선택하고, n 계단의 점수를 더해서 저장
            score[n] = Math.max(score[n - 3] + stair[n - 1], score[n - 2]) + stair[n];
        }

        System.out.println(score[N]);
    }
}