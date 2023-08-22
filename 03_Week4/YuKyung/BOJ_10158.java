import java.util.Scanner;

public class BOJ_10158 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 격자 공간의 가로와 세로 크기 입력 받기
        int W = sc.nextInt();
        int H = sc.nextInt();
        
        // 초기 위치 좌표값 입력 받기
        int q = sc.nextInt(); // q가 열(column)
        int p = sc.nextInt(); // p가 행(row)
        
        int t = sc.nextInt(); // 개미가 움직일 시간 입력 받기
        
        // 개미의 t시간 후 위치 계산
        int x = (q + t) % (2 * W);
        int y = (p + t) % (2 * H);
        
        // 개미의 위치가 경계에 부딪혔을 경우 반사될 방향으로 계산
        x = W - Math.abs(W - x);
        y = H - Math.abs(H - y);
        
        System.out.println(x + " " + y); // t시간 후 개미의 위치 출력
        sc.close(); // 스캐너 닫기
    }
}