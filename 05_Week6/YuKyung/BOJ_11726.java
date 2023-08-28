import java.util.Scanner;

public class BOJ_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n 값 입력 받음
        
        int[] arr = new int[1001]; // 결과 값을 저장할 배열 생성
        arr[1] = 1; // 초기값 설정 (2x1 크기 직사각형을 채우는 방법 1가지)
        arr[2] = 2; // 초기값 설정 (2x2 크기 직사각형을 채우는 방법 2가지)

        for(int i = 3; i <= n; i++) {
            // 3번째는 n=1과 n=2가 합친 경우의 수와 같고
        	// 4번째는 n=2와 n=3이 합친 경우의 수와 같고
        	// 5번째는 n=3과 n=4가 합친 경우의 수와 같고 ...
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }
        
        System.out.println(arr[n]);
    }
}