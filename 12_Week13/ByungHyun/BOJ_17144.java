package BOJ_17144_미세먼지안녕;

import java.util.Scanner;

public class Main {
	public static int[][] room;
	public static int r;
	public static int c;
	// 공기청정기 위치
	public static int airX;
	public static int airY;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 세로 줄
		r = sc.nextInt();
		// 가로 줄
		c = sc.nextInt();
		// 시간
		int t = sc.nextInt();
		
		// 방의 정보를 담기위한 배열 생성
		room = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				room[i][j] = sc.nextInt();
			}
		}
		
		// 공기 청정기의 위치 값 찾기
		// 맨위줄부터 2칸 이상 떨어져 있다.
		s : for (int i = 2; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (room[i][j] == -1) {
					// 찾으면 멈추기
					airX = i;
					airY = j;
					break s;
				}
			}
		}
		
		// 시간 보내기
		for (int time = 0; time < t; time++) {
			// 미세먼지 확산
			split();
			// 미세먼지 안녕~
			move();
		}
		
		// 결과 저장 공기청정기의 값이 -1이기때문에 초기값을 2로 설정한다.
		int result = 2;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result += room[i][j];
			}
		}
		
		System.out.println(result);
	}
	
	// 미세먼지 분리 시키기
	public static void split() {
		// 분리되서 이동된 미세먼지의 정보를 담기위한 배열 생성
		int[][] temp = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				// 해당 위치의 값이 0보다크다면 : 해당 위치에 먼지가 있다면
				// 해당 위치에서 분리될수있는 위치에 room[i][j] / 5의 값을 temp에 더해준다.
				if (room[i][j] > 0) {
					// 해당 위치에서 이동할 수 있는 좌표의 개수
					int target = room[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						// 이동하는 위치에 대해서 판단.
						if (nx >= 0 && nx < r && ny >= 0 && ny < c && room[nx][ny] >= 0) {
							// 범위를 넘어서는 값이 나오거나 해당 위치가 공기청정기라면 들어가지않는다.
							// temp 배열에 값을 더해주기
							temp[nx][ny] += target;
							room[i][j] -= target;
						}
					}
				}
			}
		}
		
		// room[i][j]에 퍼저나간 미세먼지의 값들을 넣어주기
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				room[i][j] += temp[i][j];
			}
		}
	}
	
	// 미세먼지의 위치를 이동시키는 메서드
	public static void move() {
		// 공기 청정기의 윗부분
		// 첫번째 값을 저장
		int start = room[0][0];
		
		// 공기 청정기 부분을 0으로 만들고 돌리기
		room[airX][airY] = 0;
		room[airX + 1][airY] = 0;
		
		for (int i = 0; i < c - 1; i++) {
			room[0][i] = room[0][i + 1];
		}
		for (int i = 0; i < airX; i++) {
			room[i][c - 1] = room[i + 1][c - 1];
		}
		for (int i = c - 1; i > 0; i--) {
			room[airX][i] = room[airX][i - 1];
		}
		for (int i = airX; i > 0; i--) {
			room[i][0] = room[i - 1][0];
		}
		room[1][0] = start;
		
		
		// 공기 청정기의 아래 부분
		start = room[airX + 1][0];
		for (int i = airX; i < r - 1; i++) {
			room[i][0] = room[i + 1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			room[r - 1][i] = room[r - 1][i + 1];
		}
		for (int i = r - 1; i >= airX + 1; i--) {
			room[i][c - 1] = room[i - 1][c - 1];
		}
		for (int i = c - 1; i > 0; i--) {
			room[airX + 1][i] = room[airX + 1][i - 1];
		}
		room[airX + 1][1] = start;
		
		room[airX][airY] = -1;
		room[airX + 1][airY] = -1;
	}
}
