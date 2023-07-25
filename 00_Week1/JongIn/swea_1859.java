package swea;

import java.util.Scanner;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {// 1. 연속된 N일동안 매매가 예측
        // 2. 하루에 최대 1만큼 구입 가능
        // 3. 판매는 언제든지 가능
 
        // 입력: 테스트 케이스의 수(T)
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // ex: T =5 (테스트 5번)
        
        for(int i =1; i <= T; i++) {
            int N = sc.nextInt(); // N = 길이
            int[] Number = new int[N]; // ex: N = 5 (3번 테스트, 5개 매매가)
             
             
            for (int j =0; j < N; j++) {
                Number[j] = sc.nextInt(); // Number 5개 매매가에 대한 배렬 생성 (1, 1, 3, 1, 2 입력)
            }
             
            long sum = 0L;
            int start = 0;
            int max = 0;
            int max_index = 0;
            long total = 0L;
             
            // 최댓값 찾기
            while (true) {
                for (int j=start; j < N; j++) {
                    if (Number[j] > max) {
                        max = Number[j]; // 최댓값 찾기
                        max_index = j; // 최댓값 인덱스 (순서)
                    }
                }
                // i가 0이 아니고 N보다 작을때
                if (max_index != 0 && max_index < N) {
                    for (int j = start; j < max_index; j++) {
                        sum += Number[j];
                    }
                    total += (max_index - start) * max - sum;
                    start = max_index+1;
                    max = 0;
                    sum = 0;
                } else if (max_index == 0) {
                    start += 1;
                }
                if (start >= N) {
                    break;
                }
                 
             
            }
            System.out.println("#" + i + " " + total);
        }
         
    }


}
