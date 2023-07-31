import java.util.Arrays;
import java.util.Scanner;

public class _2309 {
	public static void main(String[] args) {
		// 일곱 난쟁이 문제
		// 난쟁이들의 키의 합 = 100
		// 단 9명 중에서 7명을 찾아서 더해야함
		// 가능한 정답이 여러가지인 경우에는 아무거나 출력
		// 일곱 난쟁이의 키를 오름차순으로 출력. 일곱난쟁이를 찾을 수 없는 경우는 없음.
		
		Scanner sc = new Scanner(System.in);
		int sum = 0; // 초기값 합 0으로 초기화
		
		// 9의 크기를 가진 배열 생성 및, 숫자 입력
		int[] Arr = new int[9]; 
		for (int i=0; i < Arr.length; i++) {
			int N = sc.nextInt();
			Arr[i] = N;
		}
		
		// Sum에 Arr 배열 다 더해주기
		for (int i = 0; i <Arr.length; i++) {
			sum += Arr[i];
		}

		// 배열의 합 = 100 찾기 (Sum에서 2개 빼기)
		for (int i = 0; i < Arr.length - 1; i++) {
			for (int j = i + 1; j < Arr.length; j++) {
				int Num = sum - (Arr[i] + Arr[j]);
				if (Num == 100) {
					Arr[i] = 0;
					Arr[j] = 0;
					break;
				}

			}
			if(Arr[i] == 0) { // 반복하지 않게 0 되면 break;
				break;
			}
			
		}
		Arrays.sort(Arr); // 찾은 배열 오름차순 정렬하기
		
		for (int i = 2; i < Arr.length; i++) {
			System.out.println(Arr[i]);
		}

	}
}