import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//좌표 클래스
	static class info {
		int x, y;

		public info(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	//편의점 변수
	static int n;
	//좌표 저장 리스트
	static List<info> list;

	public static void main(String[] args) {
		// 상근이 집에서 출발, 맥주 20개가 들어있는 한 박스 들고 출발함
		// 50미터마다 한 병씩 마신다
		// 빈 병을 버리고 편의점에서 새로운 맥주를 구매 가능하나 들고 있을 수 있는 최대 맥주는 20병이다

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 편의점의 수
			n = sc.nextInt();
			//좌표들을 저장할 리스트
			list = new ArrayList<>();
			//좌표 저장해주기
			for (int i = 0; i < n + 2; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				list.add(new info(x, y));
			}
			bfs();
		}
	}

	public static void bfs() {
		//큐 생성
		Queue<info> q = new LinkedList<>();
		//방문배열 생성
		boolean visited[] = new boolean[n + 2];
		//인덱스0의 좌표는 상근이 집이므로 방문처리
		visited[0] = true;
		//큐에 상근이 집 좌표 넣고 시작
		q.add(new info(list.get(0).x, list.get(0).y));
		while (!q.isEmpty()) {
			//큐에서 꺼낸 좌표 저장 변수
			info in = q.poll();
			//만약 큐에서 꺼낸 좌표와 맨 마지막 인덱스에 들어가있는 락페스티벌장의 좌표의 거리가 1000보다 작다면 happy출력
			if (Math.abs(in.x - list.get(list.size() - 1).x) + Math.abs(in.y - list.get(list.size() - 1).y) <= 1000) {
				System.out.println("happy");
				return;	
			}
			//상근이 집 다음 좌표 인덱스 1부터 락페스티벌장 좌표 -1인덱스 까지 for문 돌리기
			for (int i = 1; i < list.size()-1 ; i++) {
				//해당 좌표를 방문하지 않았다면
				if (!visited[i]) {
					//큐에서 꺼낸 좌표와 리스트의 좌표 거리가 1000이하라면
					if (Math.abs(in.x - list.get(i).x) + Math.abs(in.y - list.get(i).y) <= 1000) {
						//해당 좌표를 방문처리 하고 큐에 추가한다
						visited[i] = true;
						q.add(new info(list.get(i).x, list.get(i).y));
					}
				}
			}
		}
		System.out.println("sad");
	}

}
