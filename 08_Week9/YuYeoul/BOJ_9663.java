package BOJ_9663_NQueen;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int cnt=0;
	static int arr[];
	public static void main(String[] args) {
		//체스판 생성 후 DFS호출
		N=sc.nextInt();
		arr=new int [N];
		DFS(0);
	}
	//DFS파트
	//백트래킹 파트에서 true받으면 재귀 호출
	static void DFS(int d) {
		if(d==N) {
			for(int i=0;i<N;i++) {
				System.out.println(arr[i]);
			}
		}
		for(int i=0;i<N;i++) {
			arr[d]=i;
			if(search(d)) {
				DFS(d+1);
			}
		}
		
	}
	//백트래킹 파트
	static boolean search(int c) {
		for(int i=0;i<c;i++) {
			//같은 라인에 퀸이 있다면 false
			if(arr[c]==arr[i]) {
				return false;
			//대각선에 퀸이 있다면 false
			}else if(c-i==Math.abs(arr[c]-arr[i]) ) {
				return false;
			}
		}
		return true;
	}
}
