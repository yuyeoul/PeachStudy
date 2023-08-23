package SWEA_4615_재미있는오셀로게임;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int tc = 1; tc <= num; tc++) {
			// 한 변 길이
			int len = sc.nextInt();
			// 돌 놓는 횟수
			int cnt = sc.nextInt();
			// 오셀로 판 생성
			int map[][] = new int[len][len];
			// 1 흑돌 2 백돌
			// 기본 돌 놓기
			map[(len / 2) - 1][(len / 2) - 1] = 2;
			map[len / 2][len / 2] = 2;
			map[len / 2][(len / 2) - 1] = 1;
			map[(len / 2) - 1][len / 2] = 1;

			// 델타 탐색 배열
			// 상하좌우 좌상 우상 좌하 우하
			int dc[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
			int dr[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
			for (int i = 0; i < cnt; i++) {
				//y좌표
				int r = sc.nextInt() - 1;
				//x좌표
				int c = sc.nextInt() - 1;
				//돌 놓기
				map[c][r] = sc.nextInt();
				//놓은 돌 색 저장
				int ncr = map[c][r];
				//오셀로판 탐색하면서
				for (int j = 0; j < len; j++) {
					for (int k = 0; k < len; k++) {
						//그자리가 놓은 돌과 색이 같으면
						if (map[j][k] == ncr) {
							//델타 탐색 시작
							for (int l = 0; l < 8; l++) {
								int nc = c + dc[l];
								int nr = r + dr[l];
								//오셀로판 범위 안쪽이면
								if (nc >= 0 && nr >= 0 && nc < len && nr < len) {
									int cn = 1;
									//오셀로판이 비어있지 않고 탐색한 돌이 기준 돌과 다른 색일때
									if (map[nc][nr] != 0 && map[c][r] != map[nc][nr]) {
										//해당 방향 쭉 탐색
										while (true) {
											nc += dc[l];
											nr += dr[l];
											cn++;
											//범위 밖으로 벗어나거나 0을 마주친다면 종료
											if (nc < 0 || nr < 0 || nc >= len || nr >= len||map[nc][nr]==0) {
												break;
											}
											//기준 돌과 같은 색이 나오면 해당 범위 돌 반대 색으로 변경해주기
											if (map[nc][nr] == ncr) {
												int nnc = c;
												int nnr = r;
												for (int a = 1; a < cn; a++) {
													nnc += dc[l];
													nnr += dr[l];
													map[nnc][nnr] = ncr;
												}
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			//백 흑 숫자 세기
			int B = 0;
			int W = 0;
			for (int j = 0; j < len; j++) {
				for (int k = 0; k < len; k++) {
					if (map[j][k] == 1) {
						B++;
					} else if (map[j][k] == 2) {
						W++;
					}
				}
			}
			//출력
			System.out.println("#" + tc + " " + B + " " + W);
		}
	}
}
