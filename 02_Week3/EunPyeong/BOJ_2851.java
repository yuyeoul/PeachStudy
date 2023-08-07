import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 버섯 점수 mushroom 배열에 추가
		int[] mushroom = new int[10];
		for (int i = 0; i < 10; i++) {
			mushroom[i] = sc.nextInt();
		}
		// 결과값 담을 변수 선언
		int sum = 0;
		// sum에 버섯점수 더하기
		for (int i = 0; i < 10; i++) {
			// 해당 반복회차를 더해도 100이하인 경우엔 더하기
			if (sum + mushroom[i] <= 100) {
				sum += mushroom[i];
				if(i==9) {
					System.out.println(sum);
				}
				// 100초과하는 경우
			} else {
				// 100보다 작은 금액과 100의 차이
				int diff = 100 - sum;
				// diff와 (다음 합산 금액 -100) 비교 후 같거나 작은 경우에는 더한 값 출력 , 아닌 경우 이전 sum 출력
				if (sum + mushroom[i] <= 100 + diff) {
					sum += mushroom[i];
					System.out.println(sum);
					break;
				} else {
					System.out.println(sum);
					break;
				}
			}

		}
	}
}
