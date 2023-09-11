package BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1914 {
    static int n;
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 원판의 개수 입력 받기

        // 하노이 탑을 완성하는 데 드는 횟수 출력
        System.out.println(BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE));

        if (n <= 20) {
            // 원판 개수가 20개 이하인 경우에만 움직임 출력
            hanoiTop_print(1, 2, 3, n);
        }
    }

    // 하노이 탑 움직임을 출력하는 함수
    static void hanoiTop_print(int first, int second, int third, int count) {
        if (count == 1) {
            System.out.println(first + " " + third); // 원판을 이동하는 과정을 출력
            return;
        }
        // 원판 n-1개를 중간 기둥으로 옮기기
        hanoiTop_print(first, third, second, count - 1);
        System.out.println(first + " " + third); // 원판을 이동하는 과정을 출력

        // 중간 기둥에 있는 원판을 목표 기둥으로 옮기기
        hanoiTop_print(second, first, third, count - 1);
    }

    
}