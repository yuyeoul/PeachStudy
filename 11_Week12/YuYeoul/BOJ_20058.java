import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 받아올 변수
	static int N, Q, len;
	// 기본 배열
	static int arr[][];
	// 복제 배열
	
	// 인접해 있는 곳에 얼음이 있는지 탐색할 배열
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	// bfs를 돌릴 때 queue에 넣을 정보
	static class info {
		int r, c;

		public info(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 격자의 크기
		N = sc.nextInt();

		// 마법시행 횟수
		Q = sc.nextInt();
		// 배열의 길이
		len = (int) Math.pow(2, N);
		// 배열 생성 및 채우기
		arr = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 마법 횟수 만큼 반복
		for (int i = 0; i < Q; i++) {
			int duarr[][] = new int[len][len];
			// 배열을 어떤 크기로 잘라서 회전할 지 정해준다
			int L = (int) Math.pow(2, sc.nextInt());
			// for문을 돌려서 복제 배열을 채워준다
			for (int j = 0; j < len; j += L) {
				for (int k = 0; k < len; k += L) {
					for (int a = 0; a < L; a++) {
						for (int b = 0; b < L; b++) {
							duarr[j + a][k + b] = arr[j + L - 1 - b][k + a];
						}
					}
				}
			}
			//기본배열 갱신해주기
			arr=duarr;
			
			//얼음이 녹는건 동시다발적으로 일어나야 하기 때문에 녹았다고 처리해 놓은 게 뒤에 좌표를 탐색할 때 영향을 주면 안됨
			//따라서 배열을 복제해 놓고 처리
			int arr1[][]=new int [len][len];
			
			for (int k = 0; k < len; k++) {
				for (int j = 0; j < len; j++) {
					arr1[k][j]=arr[k][j];
				}
			}
			
			for (int j = 0; j < len; j++) {
				for (int k = 0;	 k < len; k++) {
					int cnt = 0;
					// 탐색해서 0이 아니라면 cnt 증가
					// 이미 얼음이 없다면 continue
				
					if (arr[j][k] == 0) {
						continue;
					}
					//탐색은 원본 배열로 돌려주고 복제한 배열에 결과값 갱신
					for (int s = 0; s < 4; s++) {
						int nr = j + dr[s];
						int nc = k + dc[s];
						if (nr >= 0 && nr < len && nc >= 0 && nc < len) {
							if (arr[nr][nc] > 0) {
								cnt++;
							}
						}
					}
					// cnt가 3보다 작으면 해당칸 1빼주기
					if (cnt < 3) {
						arr1[j][k]--;
					}
				}
			}
			//얼음이 녹은 것을 모두 처리한 후 기본 배열에 복사
			arr=arr1;
		}
		bfs();
	}

	public static void bfs() {
		// 방문처리 할 배열
		boolean visited[][] = new boolean[len][len];
		// 큐 생성
		Queue<info> q = new LinkedList<>();
		//전체 칸 합 변수
		int sum=0;
		// 최대 칸수 변수
		int max = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				//해당 좌표 값 sum에 더해주기
				sum+=arr[i][j];
				// 배열이 0이 아니고 방문 하지 않았다면
				if (arr[i][j] != 0 && !visited[i][j]) {
					// 큐에 추가
					q.add(new info(i, j));
					// 방문 처리
					visited[i][j] = true;
					// 이어진 칸수 셀 변수
					int cnt = 1;
					while (!q.isEmpty()) {
						info to = q.poll();
						
						for (int k = 0; k < 4; k++) {
							// 4방향 탐색해서 범위 안쪽이라면
							int nr = to.r + dr[k];
							int nc = to.c + dc[k];
							if (nr >= 0 && nr < len && nc >= 0 && nc < len) {
								// 탐색지점이 0이아니고 방문하지 않았다면
								if (arr[nr][nc] != 0 && !visited[nr][nc]) {
									// 방문처리하고 큐에넣기
									visited[nr][nc] = true;
									q.add(new info(nr, nc));
									// 이어진 칸이므로 cnt++
									cnt++;
								}
							}
						}
					}
					// cnt와 최대칸수를 비교하여 최대값 갱신
					max = Math.max(max, cnt);
				}
			}
		}
		System.out.println(sum);
		System.out.println(max);
	}

}
