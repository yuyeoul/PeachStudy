package BOJ;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

// 입국심사
public class BOJ_3079 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int N; // 심사대 개수
        long M; // 입국객 수

        N = scanner.nextInt();
        M = scanner.nextLong();

        long times[] = new long[N]; // 각 심사대에서 걸리는 시간

        for (int i = 0; i < N; i++) {
            times[i] = scanner.nextLong(); // 각 심사대의 시간을 입력
        }

        // last => 끝나는 시간의 최대값.
        long start = 1; // 이진 탐색 시작 범위
        long last = 1000000000000000000L; // 이진 탐색 끝 범위
        long result = last; // 최종 결과값을 저장할 변수

        while (start <= last) {
            // mid로 끝나는 시간 기준으로 각 부분에서 몇 명을 처리할 수 있는가
            long mid = (start + last) / 2;

            if (check(M, mid, times)) {
                last = mid - 1;
                result = Long.min(result, mid);
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }

    public static boolean check(long M, long mid, long times[]) {
        for (int i = 0; i < times.length; i++) {
            M -= mid / times[i];
            // 이거 안해주면 언더플로우 가능
            if (M <= 0) {
                return true;
            }
        }
        return false;
    }
}