import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1525 {
    // 상하좌우
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int map = 0; // 퍼즐의 현재 상태를 숫자 하나로 나타내는 변수
        int[] start = new int[2]; // 빈 칸(0)의 시작 위치

        // 3x3 크기의 퍼즐 상태를 입력받기
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int tmp = sc.nextInt();
                map *= 10; // 각 숫자를 자릿수로 추가
                map += tmp; // 현재 숫자를 더하고

                if (tmp == 0) {
                    // 0(빈 칸)을 9(제일 큰 한자리 숫자(일단..!))로 변경하여 숫자 처리
                    map += 9;
                    start[0] = i; // 빈 칸의 행 위치 저장
                    start[1] = j; // 빈 칸의 열 위치 저장
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { map, start[0], start[1], 0 }); // 초기 상태 큐에 추가

        boolean[] visited = new boolean[1000000000]; // 방문 여부를 저장하는 배열...인데 너때문에 런타임에러인듯...
        visited[map] = true; // 초기 상태 방문 처리

        while (!q.isEmpty()) {
            if (q.peek()[0] == 123456789) {
                // 정답인 경우, 이동 횟수를 출력하고 프로그램 종료
                System.out.println(q.peek()[3]);
                System.exit(0);
            }

            char[] now = ("" + q.peek()[0]).toCharArray();
            int r = q.peek()[1];
            int c = q.peek()[2];
            int cnt = q.peek()[3];
            q.poll();

            for (int k = 0; k < dr.length; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (isRange(nr, nc)) {
                    int next = getNext(now, r * 3 + c, nr * 3 + nc);
                    if (!visited[next]) {
                        visited[next] = true; // 다음 상태 방문 처리
                        q.offer(new int[] { next, nr, nc, cnt + 1 }); // 큐에 다음 상태 추가
                    }
                }
            }
        }
        // 정답을 찾지 못한 경우
        System.out.println(-1);
    }

    // 두 위치를 교환하여 새로운 상태를 만듭니다.
    private static int getNext(char[] now, int i, int j) {
        char tmp = now[i];
        now[i] = now[j];
        now[j] = tmp;
        int ret = 0;
        for (char c : now) {
            ret *= 10;
            ret += c - '0';
        }
        tmp = now[i];
        now[i] = now[j];
        now[j] = tmp;
        return ret;
    }

    // 주어진 행과 열이 퍼즐 범위 내에 있는지 확인합니다.
    private static boolean isRange(int nr, int nc) {
        return 0 <= nr && nr < 3 && 0 <= nc && nc < 3;
    }
}