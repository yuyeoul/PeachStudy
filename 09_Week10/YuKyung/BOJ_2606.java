import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606 {

    static int comCount, connCount; // comCount: 컴퓨터의 총 수
    static int[][] computers;
    static boolean[] isInfected; // 감염됐니...
    static int infectedCount; // 얼마나 감염된거니...

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 컴퓨터 수와 연결 정보 수 입력
        comCount = sc.nextInt();
        connCount = sc.nextInt();

        // 컴퓨터 간 연결 정보를 저장할 배열 
        computers = new int[comCount + 1][comCount + 1];
        // 감염 여부를 저장할 배열
        isInfected = new boolean[comCount + 1];

        // 연결 정보 입력
        for (int i = 0; i < connCount; i++) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            computers[a1][a2] = computers[a2][a1] = 1; // 연결되었다고 표시
        }

        // 바이러스 퍼지는 함수 호출
        bfs(1);

        // 감염된 컴퓨터 수 출력
        System.out.println(infectedCount);
    }
    
 // BFS -> 바이러스가 퍼지는 함수
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 처음에는 시작 컴퓨터만 감염되어있으니까

        while (!queue.isEmpty()) {
            int currentComputer = queue.poll(); // 현재 감염되었다고 일단 처리
            isInfected[currentComputer] = true;

            // 모든 컴퓨터를 확인, 1에 연결되어 있고 감염되지 않았다면 큐에 추가하고 감염 횟수 증가
            for (int i = 1; i <= comCount; i++) {
                if (!isInfected[i] && computers[currentComputer][i] == 1) {
                    isInfected[i] = true;
                    queue.add(i);
                    infectedCount++;
                }
            }
        }
    }
}