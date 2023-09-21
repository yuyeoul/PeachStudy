package BOJ_1987_알파벳;

import java.util.Scanner;

public class Main {
	public static int r;
	public static int c;
	public static char[][] alpha;
	public static boolean[] alphaVisited = new boolean[26];
	public static boolean[][] visited;
	public static int result;
	// 동 서 남 북 방향 백터
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 세로의 수
		r = sc.nextInt();
		// 가로의 수
		c = sc.nextInt();
		 
		// 알파벳을 받기위한 2차원 배열 생성
		alpha = new char[r][c];
		
		// 방문 정보를 저장하는 배열
		visited = new boolean[r][c];
		
		// 배열의 정보 받기
		for (int i = 0; i < r; i++) {
			alpha[i] = sc.next().toCharArray();
		}
		countMove(0, 0, 0);
		
		System.out.println(result);
	}
	
	// 이동할수있는 최대 거리
	public static void countMove(int x, int y, int count) {
		// 해당 위치의 알파벳이 방문을 했다면 이동횟수 리턴
		// 알파벳 - 'A'는 대문자 알파벳의 순서
		if (alphaVisited[alpha[x][y] - 'A']) {
			result = Math.max(result, count);
			return;
		}
		visited[x][y] = true;
		alphaVisited[alpha[x][y] - 'A'] = true;
		// 새로운 위치에 대한 좌표값
		int nx;
		int ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			// 새로운 위치에 대해서 배열안에 있는것만 방문
			if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny]) {
				countMove(nx, ny, count + 1);
			}
		}
		visited[x][y] = false;
		alphaVisited[alpha[x][y] - 'A'] = false;
		result = Math.max(result, count + 1);
	}
}
