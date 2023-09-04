package BOJ_14713_앵무새;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 앵무새의 수
		sc.nextLine(); // 엔터키를 읽어서 버림
		
		Queue<String>[] queues = new LinkedList[N]; // 몇 개 받을거니까!
		String L = "";
		
		
		// N개의 큐 생성
		for(int i = 0; i < N; i++) {
			queues[i] = new LinkedList<>();
			String[] words = sc.nextLine().split(" ");
			for(String word : words) {
				queues[i].offer(word);
			}
 		}
		
		L = sc.nextLine(); // 이해한 문장 L 받아옴
		String[] Ls = L.split(" ");
		
		boolean ans = true;
		
		for(String word : Ls) {
			boolean found = false; // 해당 단얼르 발견했는지 여부 표시
			for (int i = 0; i < N; i++) {
				if(!queues[i].isEmpty() && queues[i].peek().equals(word)) {
					queues[i].poll(); // 해당 단어를 큐에서 제거
					found = true;
					break;
				}
			}
			
			if(!found) {
				ans = false; // 발견되지 않은 단어가 있으면 불가능한 문장
				break;
			}
		}
		
		String answer;
        if (ans) {
            answer = "Possible";
        } else {
            answer = "Impossible";
        }
		
		
		System.out.println(answer);
		
		
	}
}
