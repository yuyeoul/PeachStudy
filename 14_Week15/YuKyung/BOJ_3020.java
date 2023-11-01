package BOJ;

import java.util.Scanner;

public class BOJ_3020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 기둥의 수
        int H = scanner.nextInt(); // 기둥의 높이
        
        int[] odd = new int[H + 1];  // 홀수 인덱스 기둥(아래에서부터)
        int[] even = new int[H + 1]; // 짝수 인덱스 기둥(위에서부터)
        
        for (int c = 1; c <= N; c++) {
            int curr = scanner.nextInt();  // 각 기둥의 높이 입력
            if (c % 2 != 0) {
                // 석순(아래에서), 홀수 기둥
                odd[curr]++;
            } else {
                // 종유석(위에서), 짝수 기둥
                even[curr]++;
            }
        }
        
        for (int i = 1; i <= H; i++) {
            odd[i] = odd[i - 1] + odd[i];    // 홀수 기둥의 누적합 계산
            even[i] = even[i - 1] + even[i]; // 짝수 기둥의 누적합 계산
        }
        
        int result2 = 0;
        int[] list = new int[H + 1];
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= H; i++) {
            list[i] += odd[H] - odd[i - 1];  // 아래에서 i 높이에 있는 석순들의 합
            list[i] += even[H] - even[H - i]; // 위에서 H-i 높이에 있는 종유석들의 합
            min = Math.min(min, list[i]);    // 최소값 갱신
        }
        
        for (int i = 1; i <= H; i++) {
            if (list[i] == min) result2++;  // 최소값과 같은 경우 개수 증가
        }
        
        System.out.println(min + " " + result2);  // 결과 출력
    }
}