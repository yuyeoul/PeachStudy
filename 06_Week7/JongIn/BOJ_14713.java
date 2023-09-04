package BOJ_14713_앵무새;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 앵무새의 수
		sc.nextLine(); // 개행문자 처리

		// Queue N개 선언
		Queue<String>[] queues = new Queue[N];
		
		for (int i = 0; i < N; i++) {
			queues[i] = new LinkedList<>();
			String[] words = sc.nextLine().split(" "); // 입력받은 문장을 단어로 각 배열로 입력받아주기
			
			for (int j = 0; j < words.length; j++) {
				queues[i].add(words[j]); // 입력받은 단어를 queue에 추가해주기
			}
		}
		
		String L = sc.nextLine(); // 입력받는 문장 L
		String[] tmp = L.split(" "); // tmp에 split으로 문장L을 단어로 나눠서 배열에 저장

		int sum = 0; // 단어의 갯수를 셀 변수
		for (int i = 0; i < N; i++) {
			sum += queues[i].size(); // queue에 들어간 단어의 갯수가
		}

		if (sum != tmp.length) { // 문장으로 말한 단어의 갯수가 다를 경우
			System.out.println("Impossible"); // Impossible
			return;
		}		
		
		// tmp 단어의 갯수만큼 반복을 진행
		for (int i = 0; i < tmp.length; i++) {
			
			for (int j = 0; j < N; j++) { // queue N개 확인
				if (!queues[j].isEmpty() && tmp[i].equals(queues[j].peek())) { // queue가 빈칸 아니고, 단어의 해당 i번째가 queue n개의 j번째의 가장 위에 있는 부분이 같을 경우
					queues[j].remove(); // queue j번째 제거
				}
				
			}
		} // tmp 갯수만큼 반복문 끝
		
		boolean isflag = true; // 판단하는 boolean값
		
		for (int i = 0; i < N; i++) {
			if (queues[i].size() != 0) { // queue에 남은 단어가 하나라도 있으면
				isflag = false; // flag는 false로 변경
				break;
			}
			
		}

		// 결과 출력
		if(isflag) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
		
	} // main
} // class
