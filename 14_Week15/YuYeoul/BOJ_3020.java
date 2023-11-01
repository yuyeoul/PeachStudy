package SWEA_1209_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		//인풋 받기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int H = sc.nextInt();
		//석순 배열
		int suk[] = new int[H + 1];
		//종유석 배열
		int jong[] = new int[H + 1];
		//i가 짝수면 석순, 홀수면 종유석
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			//석순과 종유석 높이의 개수를 카운트하기위해 해당 인덱스 값 계산 
			if (i % 2 == 0) {
				suk[num]++;
			} else {
				jong[num]++;
			}
		}
		//높이에 대한 카운트가 완료되었으면
		//앞 인덱스에 뒤의 값 추가
		//why?=> 예를 들어서 1의 높이가 1개, 2의 높이가 3개, 3의 높이가 2개, 4의 높이가 5개라면 총 장애물은 11개
		//해당 반복문을 돌게되면 1=11,2=10,3=7,4=5가 되고
		//1번째 구간으로 날아간다면 총 11개를 파괴해야하고, 2번째 구간으로 날개되면 10개=>2번째 구간으로 날개 되면 높이가 1인 장애물은 파괴하지 않는다,....
		for (int i = H - 1; i > 0; i--) {
			suk[i] += suk[i + 1];
			jong[i] += jong[i + 1];
		}
		int ans = Integer.MAX_VALUE;
		int cnt = 0;
		//종유석은 거꾸로 생각해야 하니까 높이-구간+1의 값을 가져온다
		for (int i = 1; i <= H; i++) {
			int sum=suk[i]+jong[H-i+1];

			if (sum < ans) {
				ans = sum;
				cnt=1;
			} else if (sum == ans) {
				cnt++;
			}
		}
		System.out.println(ans + " " + cnt);

	}
}
