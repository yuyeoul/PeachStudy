import java.util.Scanner;

public class Main {
    static int n, sum, count = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // 배열의 크기와 목표 합 입력받음
        n = scan.nextInt(); // 배열 크기
        sum = scan.nextInt(); // 목표 합
        arr = new int[n]; // 크기가 n인 배열

        // 배열의 요소 입력 받음
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        // 함수를 호출하여 가능한 부분집합을 찾자
        dfs(0, 0);

        // 목표 합이 0이라면, 빈 집합도 있을 수 있으니 count를 하나 줄여주자
        if (sum == 0) {
            count--;
            System.out.println(count);
        } else {
            // 그렇지 않으면 가능한 부분집합의 개수 출력
            System.out.println(count);
        }
    }

    // dfs ㄱㄱ
    private static void dfs(int start, int i) {
       
        // 배열의 끝까지 탐색한 경우
        if (start == n) {
            // 현재까지의 합이 목표 합과 일치하는지 확인하고 count를 증가
            if (i == sum) {
                count++;
            }
            return;
        }
        
        // 현재 요소를 선택하는 경우
        dfs(start + 1, i + arr[start]);
        // 현재 요소를 선택하지 않는 경우
        dfs(start + 1, i);
  
    }
}