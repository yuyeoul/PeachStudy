package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {
	static int R, C, T;
	static int arr[][];
	static List<Integer> ar;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//가로
		R = sc.nextInt();
		//세로
		C = sc.nextInt();
		//시간
		T = sc.nextInt();
		
		//기본배열
		arr = new int[R][C];
		
		//공기청정기 r위치 넣을 리스트
		ar = new ArrayList<>();
		
		//기본 배열 채움과 동시에 -1이면 공기청정기 위치이므로 리스트에 i추가
		//사실 리스트에 넣을 필요는 없을 거 같다
		//첫 -1값 찾으면 거기에 +1행 해주면되니까?
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == -1) {
					ar.add(i);
				}
			}
		}
		//T초만큼 함수 실행
		for (int t = 0; t < T; t++) {
			dust();
			ac();
		}
		
		//최종 먼지 저장 변수
		int sum = 0;
		// 탐색해서 먼지 저장
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0) {
					sum += arr[i][j];
				}
			}
		}
		//출력
		System.out.println(sum);
	}
	//먼지 확산 메소드
	public static void dust() {
		
		//전체 칸에 있는 먼지가 한번에 확산되게 처리 해야하므로 탐색배열과 먼지확산 배열을 분리
		//탐색은 원본 배열로
		
		//먼지확산 배열
		//기존배열에 반영보다 +될먼지와 -될먼지의 계산값을 저장 후 원본배열에 먼지배열 값들 더해주기
		int[][] duarr = new int[R][C];
		//공기청정기 행값
		int y1 = ar.get(0);
		int y2 = ar.get(1);
		//공기청정기 위치 배열에 입력
		duarr[y1][0] = -1;
		duarr[y2][0] = -1;
		//배열을 돌면서
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				//값이 0보다 크면 먼지가 있는것
				if (arr[i][j] > 0) {
					//먼지의 값
					int num = arr[i][j];
					//먼지/5가 4방향에 퍼질 양
					int div = num / 5;
					//4방향중 몇칸 채워질지 카운트
					int cnt = 0;
					//4방향 탐색해서
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						//범위 안에있고 공기청정기가 위치한 지역이 아니라면
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && arr[nr][nc] != -1) {
							//먼지 확산 배열에 값 추가
							duarr[nr][nc] += div;
							cnt++;
						}
					}
					//기준먼지에서 빠질값 체크
					duarr[i][j] -= div * cnt;
				}
			}
		}
		//먼지배열에 저장된 정보들 원본 배열에 더해주기
		for (int a = 0; a < R; a++) {
			for (int b = 0; b < C; b++) {
				if(arr[a][b]!=-1) {
					arr[a][b] += duarr[a][b];
				}
			}
		}
		//공기청정기 
//		arr[y1][0] = -1;
//		arr[y2][0] = -1;
	}
	
	//공기청정기 작동 메소드
	public static void ac() {
		int duarr[][] = new int[R][C];
		int y1 = ar.get(0);
		int y2 = ar.get(1);
		//먼지배열에 원본배열 복사
		for (int a = 0; a < R; a++) {
			for (int b = 0; b < C; b++) {
				duarr[a][b] = arr[a][b];
			}
		}
		//0번 행부터 공기청정기 1번좌표까지 테두리 반시계방향 회전
		//공기청정기 만나면 먼지 소멸
		for (int i = 0; i <= y1; i++) {
			for (int j = 0; j < C; j++) {
				if (i == 0) {
					if (j + 1 < C) {
						duarr[i][j] = arr[i][j + 1];
					}
				}
				if (i == y1) {
					if (j == 1) {
						duarr[i][j] = 0;
					} else if (j > 1) {
						duarr[i][j] = arr[i][j - 1];
					}

				}
				if (j == 0) {
					if (i - 1 >= 0) {
						if (arr[i][j] != -1) {
							duarr[i][j] = arr[i - 1][j];
						} else {
							duarr[i][j] = -1;
						}
					}
				}
				if (j == C - 1) {
					if (i + 1 <= y1) {
						duarr[i][j] = arr[i + 1][j];
					}
				}

			}
		}
		//공기청정기 2번좌표부터 배열의 맨 마지막 행까지 테두리 시계방향 회전
		//공기청정기 만나면 먼지 소멸
		for (int i = y2; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == y2) {
					if (j == 1) {
						duarr[i][j] = 0;
					} else if (j > 1) {
						duarr[i][j] = arr[i][j - 1];
					}
				}
				if (i == R - 1) {
					if (j + 1 < C) {
						duarr[i][j] = arr[i][j + 1];
					}
				}
				if (j == 0) {
					if (i + 1 < R) {
						if (arr[i][j] != -1) {
							duarr[i][j] = arr[i + 1][j];
						} else {
							duarr[i][j] = -1;
						}
					}
				}
				if (j == C - 1) {
					if (i - 1 > y1) {
						duarr[i][j] = arr[i - 1][j];
					}
				}

			}
		}
		arr = duarr;
	}

}
