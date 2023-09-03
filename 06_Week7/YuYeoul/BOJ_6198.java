package BOJ_6198_옥상정원꾸미기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//빌딩 개수
		int num = sc.nextInt();
		//빌딩 배열 생성
		int arr[] = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		Stack<Integer> stack=new Stack<>();
		long sum = 0;
		for (int i = 0; i < num; i++) {
			//스택이 비어있지 않고 다음빌딩이 스택의 맨위보다 크거나 같으면 스택에서 값 뽑기 반복
			while(!stack.isEmpty() && stack.peek()<=arr[i]) {
				stack.pop();
			}
			//스택에 빌딩 넣기
			stack.push(arr[i]);
			//기준빌딩은 제외하고 숫자세야하니까 스택사이즈-1
			sum+=stack.size()-1;
		}
		System.out.println(sum);
	}

}
