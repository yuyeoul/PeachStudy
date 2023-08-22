package SWEA_4615_재미있는오셀로게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] board;  // 오델로 게임 보드
    static int N;  // 보드의 한 변 길이

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());  // 테스트 케이스의 수
        
        for (int T = 0; T < tc; T++) {  // 각 테스트 케이스에 대한 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  // 보드 한 변의 길이
            int M = Integer.parseInt(st.nextToken());  // 수행할 돌 놓기 횟수

            int blackCnt = 0;  // 흑돌의 개수
            int whiteCnt = 0;  // 백돌의 개수

            board = new int[N][N];  // 오델로 게임 보드 초기화
            board[N / 2 - 1][N / 2 - 1] = 2;  // 초기 돌 배치
            board[N / 2][N / 2 - 1] = 1;
            board[N / 2 - 1][N / 2] = 1;
            board[N / 2][N / 2] = 2;

            for (int i = 0; i < M; i++) {  // 돌을 놓는 횟수만큼 반복
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;  // 돌을 놓을 x 좌표
                int y = Integer.parseInt(st.nextToken()) - 1;  // 돌을 놓을 y 좌표
                int color = Integer.parseInt(st.nextToken());  // 돌의 색깔 (1: 흑, 2: 백)

                board[x][y] = color;  // 돌을 놓음
                othello(x, y, color);  // 오델로 규칙에 따라 돌을 뒤집음
            }

            for (int[] tempArr : board) {  // 게임 보드를 돌며 돌의 개수 세기
                for (int tempVal : tempArr) {
                    if (tempVal == 1) blackCnt++;  // 흑돌 개수 증가
                    else if (tempVal == 2) whiteCnt++;  // 백돌 개수 증가
                }
            }
            System.out.println("#" + (T + 1) + " " + blackCnt + " " + whiteCnt);  // 결과 출력
        }
    }

    public static void othello(int x, int y, int color) {
        for (int ix = -1; ix <= 1; ix++) {  // 주변 돌을 탐색하기 위한 반복문 (x, y)의 주변 8개 방향을 탐색
            for (int iy = -1; iy <= 1; iy++) {
                if (ix == 0 && iy == 0)
                    continue;

                int xx = x + ix;  // 주변 돌의 x 좌표
                int yy = y + iy;  // 주변 돌의 y 좌표

                boolean check = false;  // 주변 돌이 자신의 돌인지 체크하는 변수
                while (xx >= 0 && xx < N && yy >= 0 && yy < N && board[xx][yy] != 0) {  // 보드 내에 있고 돌이 있는 동안 반복
                    if (board[xx][yy] == color) {  // 주변 돌이 자신의 돌인 경우
                        check = true;  // 체크 변수를 true로 설정
                        break;
                    }
                    xx += ix;  // 주변 돌을 탐색하기 위해 좌표 이동
                    yy += iy;
                }

                while (check) {  // 자신의 돌로 둘러쌓인 상대 돌을 뒤집기 위한 반복
                    if (xx == x && yy == y) break;  // 처음 위치로 돌아왔으면 종료
                    board[xx][yy] = color;  // 상대 돌을 자신의 돌로 뒤집음
                    xx -= ix;  // 반대 방향으로 좌표 이동
                    yy -= iy;
                }
            }
        }
    }
}