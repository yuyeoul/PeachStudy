import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
          int day = sc.nextInt();
            int[] price = new int[day];
            long max = Integer.MIN_VALUE;
            int max_idx = 0;
            long profit = 0L;
            int start = 0;
            // 가격 배열 만들기
            for (int i = 0; i < price.length; i++) {
                price[i] = sc.nextInt();
            }
            // 배열 내 최대값 찾기, 최댓값에서 앞의 숫자 뺀 값 profit에 더하기 
            while (start < price.length) {
                // 배열 내 최대값과 인덱스값 찾기
                for (int i = start; i < price.length; i++) {
                    if (max < price[i]) {
                        max = price[i];
                        max_idx = i;
                    }
                }
                // 이익 볼 수 있는 상황
                if (start < max_idx) {
                    for (int i = start; i < max_idx; i++) {
                        profit += (long)(max - price[i]);
                    }
                    max = Integer.MIN_VALUE;
                    start = max_idx + 1;
                } else if (start == max_idx) {
                    max = Integer.MIN_VALUE;
                    start = max_idx + 1;
                }
            }
            System.out.println("#" + test_case + " " + profit + "");
        }
    }
}