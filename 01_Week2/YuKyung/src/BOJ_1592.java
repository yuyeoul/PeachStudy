import java.util.Scanner;

public class BOJ_1592 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람 수
        int M = sc.nextInt(); // 공을 받을 횟수
        int L = sc.nextInt(); // 던질 사람으로부터의 거리

        int[] people = new int[N + 1]; // 각 사람이 공을 받은 횟수를 저장할 배열
        int current = 1; // 현재 공을 받고 있는 사람의 위치
        int throwCount = 0; // 공을 던진 횟수

        while (true) {
            people[current]++; // 현재 공을 받고 있는 사람의 횟수 증가
            if (people[current] == M) // 현재 공을 받고 있는 사람이 M번 받았으면 반복 종료
                break;

            // 현재 공을 받고 있는 사람의 횟수가 홀수인 경우 시계 방향으로 L번째 사람에게 공 던짐
            // 현재 공을 받고 있는 사람의 횟수가 짝수인 경우 반시계 방향으로 L번째 사람에게 공 던짐
            if (people[current] % 2 == 1)
                current = (current + L) % N;
            else
                current = (current - L + N) % N;

            throwCount++; // 공을 던진 횟수 증가
        }

        System.out.println(throwCount);
    }
}