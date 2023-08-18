import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // N과 K 입력 받기
        int N = in.nextInt();
        int K = in.nextInt();

        // 큐 생성
        Queue<Integer> q = new LinkedList<>();

        // 1부터 N까지 값을 큐에 추가
        for (int i = 1; i <= N; i++) {
            offer(q, i); // 큐에 값을 추가하는 메서드 호출
        }

        // 결과를 저장할 문자열 초기화
        String result = "<";

        // 큐가 비어있지 않은 동안 반복
        while (!isEmpty(q)) {
            // K - 1번째까지의 값을 큐에서 빼내어 다시 큐에 추가
            for (int i = 0; i < K - 1; i++) {
                int value = poll(q); // 큐에서 값을 빼내고
                offer(q, value); // 다시 큐에 추가하는 메서드 호출
            }
            result += poll(q); // K번째 값을 큐에서 빼내어 결과 문자열에 추가

            // 아직 큐에 값이 남아있으면 ", " 추가
            if (!isEmpty(q)) {
                result += ", ";
            }
        }

        result += ">"; // 결과 문자열 완성
        System.out.println(result); // 결과 출력
    }

    // 큐에 값을 추가하는 메서드
    public static void offer(Queue<Integer> q, int value) {
        q.add(value);
    }

    // 큐에서 값을 빼내고 반환하는 메서드
    public static int poll(Queue<Integer> q) {
        return q.poll();
    }

    // 큐가 비어있는지 확인하는 메서드
    public static boolean isEmpty(Queue<Integer> q) {
        return q.isEmpty();
    }
}