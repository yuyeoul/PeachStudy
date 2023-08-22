import java.util.Scanner;

public class BOJ_2563 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력 받을 Scanner 객체 생성
        int paperCount = sc.nextInt(); // 색종이의 수를 입력 받음
        int blackArea = 0; // 검은색 영역의 넓이를 저장할 변수 초기화
        boolean[][] paperCheck = new boolean[101][101]; // 도화지 위의 색종이 영역을 체크할 배열 생성

        // 색종이의 수만큼 반복
        for (int i = 0; i < paperCount; i++) {
            int x = sc.nextInt(); // 색종이의 왼쪽 아래 꼭짓점 x 좌표를 입력 받음
            int y = sc.nextInt(); // 색종이의 왼쪽 아래 꼭짓점 y 좌표를 입력 받음

            // 색종이의 가로 크기는 10, 세로 크기는 10
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (paperCheck[j][k]) { // 이미 색칠된 부분이면 중복이므로 건너뛰기
                        continue;
                    }
                    paperCheck[j][k] = true; // 검은색 색종이로 색칠되었음을 표시
                    blackArea++; // 검은 영역의 넓이를 증가시킴
                }
            }
        }

        System.out.println(blackArea); // 검은 영역의 넓이 출력
        sc.close(); // 입력 닫기
    }
}