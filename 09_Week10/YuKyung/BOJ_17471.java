package SWEA_17471;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17471 {
    static int[] people; // 사람 수 저장
    static int[][] graph; // 도시 간 연결관계?
    static int N; // 전체 도시 수
    static List<Integer> A, B; // 두 그룹, 리스트 A와 B
    static int pickCnt; // 선택한 사람 수 cnt
    static int answer = Integer.MAX_VALUE; // 결과값!

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.next());

        A = new ArrayList<>();
        B = new ArrayList<>();

        // 각 사람의 인구 수를 입력 받고 리스트 A에 추가
        people = new int[N+1];
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(sc.next());
            A.add(i);
        }

        // 연결관계 확인하겠어요
        graph = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            int cnt = Integer.parseInt(sc.next());
            for (int c = 0; c < cnt; c++) {
                int vertex = Integer.parseInt(sc.next());

                // 그래프에 연결 관계 표시
                graph[i][vertex] = 1;
                graph[vertex][i] = 1;
            }
        }

        // 선택할 사람 수의 범위를 계산
        int end;
        if (N % 2 == 1) {
            end = (N / 2) + 1;
        } else {
            end = N / 2;
        }

        // 가능한 모든 조합을 시도
        for (pickCnt = 1; pickCnt <= end; pickCnt++) {
            combination(0);
        }

        // 결과값이 최대값인 경우, -1 출력
        answer = (answer == Integer.MAX_VALUE) ? -1 : answer;
        System.out.println(answer);
    }

    // 조합을 찾는 메서드
    private static void combination(int idx) {
        if (B.size() == pickCnt) {
            // A와 B 그룹이 모두 연결되어 있는 경우
            if (BFS(A) && BFS(B)) {
                int people_A = 0;
                for (int i = 0; i < A.size(); i++) {
                    people_A += people[A.get(i)];
                }
                int people_B = 0;
                for (int i = 0; i < B.size(); i++) {
                    people_B += people[B.get(i)];
                }

                // A 그룹과 B 그룹의 인구 차이 계산
                if (people_A - people_B < answer) {
                    answer = Math.abs(people_A - people_B);
                }
            }
            return;
        }

        if (idx >= A.size()) return;

        // B 그룹에 사람 추가
        B.add(A.remove(idx));
        combination(idx);

        // B 그룹에서 사람 제거하고 다음 사람 시도
        A.add(idx, B.remove(B.size() - 1));
        combination(idx + 1);
    }

    // BFS으로 그룹 연결 여부 확인
    private static boolean BFS(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length + 1];

        int v = list.get(0);
        queue.add(v);
        visited[v] = true;

        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            
        	
        	
        	
        }

        // 모든 노드가 방문되었는지 확인
        for (int i = 0; i < list.size(); i++) {
            
        	
        	
        	
        }
        return true;
    }
}