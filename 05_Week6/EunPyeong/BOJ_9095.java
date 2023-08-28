 
import java.util.Scanner;

public class BOJ_9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력값
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			int[] memo = new int[input + 1];

			System.out.println(getMethods(memo, input));
		}
	}
    // 계산 방법 수 구하는 매서드
	public static int getMethods(int[] arr, int input) {
        // 3이하인 경우 값 할당
		if(input<=2) {
			arr[input]= input;
		} else if(input==3) {
			arr[input] = 4;
		}
		int result = 0;
        // 그 외의 경우 , 배열에 저장된 값이 없으면 
		if (arr[input] == 0) {
            // 매서드를 통해 생성
			arr[input] = getMethods(arr, input - 1) + getMethods(arr, input - 2) + getMethods(arr, input - 3);
			result = arr[input];
            // 있으면
		} else {
            // 배열 값 불러오기
			result = arr[input];
		}
		return result;
	}
}
