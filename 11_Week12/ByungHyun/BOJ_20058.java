package BOJ_20058_마법사상어와파이어스톰;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int n;
	public static int N;
	public static int q;
	public static int sum;
	public static int count;
	public static int[][] board;
	public static int[][] rotate;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static boolean[][] visited;
	public static int c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		q = sc.nextInt();
		n = (int)Math.pow(2, N);
		
		board = new int[n][n];
		// 데이터 받기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		sum = 0;
		count = 0;
		// 각각의 연산에 대해 보드 수정
		for (int i = 0; i < q; i++) {
			int l = sc.nextInt();
			rotate(l);
			melt();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum+= board[i][j];
			}
		}
		
		System.out.println(sum);
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}
				c = 0;
				dfs(i, j);
				count = Math.max(c, count);
			}
		}
		
		System.out.println(count);
	}
	
	// 구역에 따라 90도 회전하는 메서드
	public static void rotate(int l) {
		rotate = new int[n][n];
		int step = (int)Math.pow(2, l);
		
		for (int i = 0; i < n; i += step) {
			for (int j = 0; j < n; j += step) {
				for (int a = 0; a < step; a++) {
					for (int b = 0; b < step; b++) {
						rotate[i + a][j + b] = board[i + step - 1 - b][j + a];
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = rotate[i][j];
			}
		}
		
	}
	
	public static void melt() {
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] > 0) {
						count++;
					}
				}
				
				if (count < 3) {
					list.add(new int[] {i, j});
				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			int[] point = list.get(i);
			board[point[0]][point[1]]--;
		}
	}
	
	public static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
				visited[nx][ny] = true;
				c++;
				dfs(nx, ny);
			}
		}
	}
}
