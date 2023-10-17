package BOJ;
import java.util.*;

public class BOJ_14503 {
    static int n, m, r, c, d; // 맵의 크기, 로봇의 초기 위치 및 방향 설정
    static int[][] board; // 맵 정보를 담을 2차원 배열
    static int count = 1; // 청소한 영역 개수, 초기 위치는 항상 청소되어 있음
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서 방향으로 이동하기 위한 x 좌표 변화값
    static int[] dy = {0, 1, 0, -1}; // 북, 동, 남, 서 방향으로 이동하기 위한 y 좌표 변화값

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt(); // 행 개수
        m = scan.nextInt(); // 열 개수
        r = scan.nextInt(); // 초기 행 위치
        c = scan.nextInt(); // 초기 열 위치
        d = scan.nextInt(); // 로봇의 초기 방향

        board = new int[n][m]; // 맵 정보를 저장할 배열
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scan.nextInt(); // 입력
            }
        }

        dfs(r, c, d); // DFS 함수를 통해 청소 ㄱㄱ
        System.out.println(count); // 청소한 영역 개수 출력
    }

    public static void dfs(int x, int y, int dir) {
        board[x][y] = 2; // 현재 위치를 청소했음을 표시 -> 2로 하겠어

        for (int i = 0; i < 4; i++) {
            dir -= 1; // 왼쪽 방향으로 돌면서 탐색 
            if (dir == -1) dir = 3; // dir 0이었으면 3번 방향으로 

            // 이동
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (board[nx][ny] == 0) { // 벽도 아니고 이미 청소한 곳도 아니라면 청소하러 가자
                    count++;
                    dfs(nx, ny, dir);
                    return; // 후진할 때만 이전 길을 되돌아가며 확인할 수 있으므로 return을 통해 더 이상 움직이면 안됨
                }
            }
        }

        // 주변에 더 이상 청소할 공간이 없을 때 for문 나올 수 있음
        int d = (dir + 2) % 4; // 반대 방향으로 후진하기 위한 방향 수정
        int bx = x + dx[d]; // 후진한 x 좌표
        int by = y + dy[d]; // 후진한 y 좌표

        if (bx >= 0 && by >= 0 && bx < n && by < m && board[bx][by] != 1) {
            dfs(bx, by, dir); // 후진할 때 방향을 유지해야 함
        }
    }
}