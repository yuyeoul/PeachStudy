package algo;

import java.util.Scanner;

public class BOJ_5373 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 위-흰 아래-노랑 앞-빨강 뒤-오랜지 왼-초 오-파

		for (int tc = 1; tc <= n; tc++) {
			String W[][] = { { "w", "w", "w" }, { "w", "w", "w" }, { "w", "w", "w" } };
			String R[][] = { { "r", "r", "r" }, { "r", "r", "r" }, { "r", "r", "r" } };
			String Y[][] = { { "y", "y", "y" }, { "y", "y", "y" }, { "y", "y", "y" } };
			String O[][] = { { "o", "o", "o" }, { "o", "o", "o" }, { "o", "o", "o" } };
			String G[][] = { { "g", "g", "g" }, { "g", "g", "g" }, { "g", "g", "g" } };
			String B[][] = { { "b", "b", "b" }, { "b", "b", "b" }, { "b", "b", "b" } };

			// 위 아래
			// 아래 위
			// 왼쪽 오른쪽
			// 오른쪽 왼쪽

			int r = sc.nextInt();
			for (int i = 0; i < r; i++) {
				String str = sc.next();
				String[][] dupli1 = new String[3][3];
				String[][] dupli2 = new String[3][3];
				String[][] dummy = new String[3][3];
				// 기준 면도 돌아가는 처리 해줘야함
				if (str.equals("U+")) {
					// 위-오렌지 아래-빨강 좌-초 우-파
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = G[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						G[0][a] = R[0][a];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = O[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						O[0][a] = dupli1[0][a];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = B[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						B[0][a] = dupli2[0][a];

					}

					for (int a = 0; a < 3; a++) {
						R[0][a] = dupli1[0][a];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = W[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							W[a][b] = dummy[2 - b][a];
						}
					}

				} else if (str.equals("U-")) {
					// 위-오렌지 아래-빨강 좌-초 우-파
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = B[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						B[0][a] = R[0][a];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = O[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						O[0][a] = dupli1[0][a];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = G[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						G[0][a] = dupli2[0][a];

					}

					for (int a = 0; a < 3; a++) {
						R[0][a] = dupli1[0][a];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = W[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							W[a][b] = dummy[b][2 - a];
						}
					}
				} else if (str.equals("D+")) {
					// 위-빨 아래-오 좌-초 우-파
					// 좌상우하
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = B[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						B[2][a] = R[2][a];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = O[a][b];
						}
					}

					for (int a = 0; a < 3; a++) {
						O[2][a] = dupli1[2][a];

					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = G[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						G[2][a] = dupli2[2][a];

					}

					for (int a = 0; a < 3; a++) {
						R[2][a] = dupli1[2][a];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = Y[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							Y[a][b] = dummy[2 - b][a];
						}
					}
				} else if (str.equals("D-")) {
					// 위-빨 아래-오 좌-초 우-파
					// 우상좌하
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = G[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						G[2][a] = R[2][a];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = O[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						O[2][a] = dupli1[2][a];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = B[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						B[2][a] = dupli2[2][a];

					}

					for (int a = 0; a < 3; a++) {
						R[2][a] = dupli1[2][a];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = Y[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							Y[a][b] = dummy[b][2 - a];
						}
					}
				} else if (str.equals("F+")) {
					// 위-흰 아래-노 좌-초 우-파
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = B[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						B[a][0] = W[2][a];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = Y[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						Y[0][a] = dupli1[2 - a][0];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = G[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						G[a][2] = dupli2[0][a];

					}

					for (int a = 0; a < 3; a++) {
						W[2][2 - a] = dupli1[a][2];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = R[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							R[a][b] = dummy[2 - b][a];
						}
					}
				} else if (str.equals("F-")) {
					// 위-흰 아래-노 좌-초 우-파
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = G[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						G[a][2] = W[2][2 - a];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = Y[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						Y[0][a] = dupli1[a][2];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = B[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						B[a][0] = dupli2[0][2 - a];

					}

					for (int a = 0; a < 3; a++) {
						W[2][a] = dupli1[a][0];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = R[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							R[a][b] = dummy[b][2 - a];
						}
					}
				} else if (str.equals("B+")) {
					// 위-흰 아래-노 좌-파 우-초
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = G[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						G[a][0] = W[0][2 - a];

					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = Y[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						Y[2][a] = dupli1[a][0];
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = B[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						B[a][2] = dupli2[2][2 - a];

					}

					for (int a = 0; a < 3; a++) {
						W[0][a] = dupli1[a][2];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = O[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							O[a][b] = dummy[2 - b][a];
						}
					}
				} else if (str.equals("B-")) {
					// 위-흰 아래-노 좌-파 우-초
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = B[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						B[a][2] = W[0][a];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = Y[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						Y[2][a] = dupli1[2 - a][2];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = G[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						G[a][0] = dupli2[2][a];

					}

					for (int a = 0; a < 3; a++) {
						W[0][a] = dupli1[2 - a][0];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = O[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							O[a][b] = dummy[b][2 - a];
						}
					}
				} else if (str.equals("L+")) {
					// 위-흰 아래-노 좌-오 우-빨
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = Y[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						Y[a][0] = R[a][0];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = O[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						O[a][2] = dupli1[2 - a][0];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = W[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						W[a][0] = dupli2[2 - a][2];

					}

					for (int a = 0; a < 3; a++) {
						R[a][0] = dupli1[a][0];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = G[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							G[a][b] = dummy[2 - b][a];
						}
					}
				} else if (str.equals("L-")) {
					// 위-흰 아래-노 좌-오 우-빨
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = W[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						W[a][0] = R[a][0];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = O[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						O[a][2] = dupli1[2 - a][0];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = Y[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						Y[a][0] = dupli2[2 - a][2];

					}

					for (int a = 0; a < 3; a++) {
						R[a][0] = dupli1[a][0];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = G[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							G[a][b] = dummy[b][2 - a];
						}
					}
				} else if (str.equals("R+")) {
					// 위-흰 아래-노 좌-빨 우-오
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = W[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						W[a][2] = R[a][2];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = O[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						O[a][0] = dupli1[2 - a][2];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = Y[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						Y[a][2] = dupli2[2 - a][0];

					}

					for (int a = 0; a < 3; a++) {
						R[a][2] = dupli1[a][2];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = B[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							B[a][b] = dummy[2 - b][a];
						}
					}
				} else if (str.equals("R-")) {
					// 위-흰 아래-노 좌-빨 우-오
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = Y[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						Y[a][2] = R[a][2];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli2[a][b] = O[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						O[a][0] = dupli1[2 - a][2];

					}

					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dupli1[a][b] = W[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						W[a][2] = dupli2[2 - a][0];

					}
					for (int a = 0; a < 3; a++) {
						R[a][2] = dupli1[a][2];
					}

					// 90도 회전
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							dummy[a][b] = B[a][b];
						}
					}
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							B[a][b] = dummy[b][2 - a];
						}
					}
				}
			}
			for (int q = 0; q < 3; q++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(W[q][j]);
				}
				System.out.println();
//			}
		}

	}

}}
