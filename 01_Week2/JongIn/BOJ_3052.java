package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_3052 {
	public static void main(String[] args) {
		// 백준_3052_나머지
		// 문제: 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다.
		// 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
		// 입력: 첫째 줄부터 열번째 줄까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
		// 출력: 첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
		
		
		Scanner sc = new Scanner(System.in);
		
		// 숫자 10개에 대한 배열 생성
		List<Integer> list = new ArrayList<>(10);
		List<Integer> result = new ArrayList<>();
		
		// 42를 나눈 배열 값 생성
		for(int i=0; i < 10; i++) {
			int N = sc.nextInt();
			int Num = N % 42;
			list.add(Num);
		}
		System.out.println(list);
		
		// 중복값 제거
		for (int i = 0; i < list.size(); i++) {
			if (!result.contains(list.get(i))) {
				result.add(list.get(i));
			}
		}
		// 배열 길이 
		System.out.println(result);
		System.out.println(result.size());
		
	}

	
}
