package BOJ_16938_캠프준비;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int[] pArr;
	static int N,L,R,X;
	static int[] sel;
	static int cnt;
	public static void main(String[] args) {
		//문제 개수
		N=sc.nextInt();
		//문제 난이도 최소
		L=sc.nextInt();
		//문제 난이도 최대
		R=sc.nextInt();
		//가장쉬운문제와 가장 어려운 문제의 난이도 차
		X=sc.nextInt();
		pArr=new int[N];
		for(int i=0;i<N;i++) {
			pArr[i]=sc.nextInt();
		}
		for(int i=2;i<=N;i++) {
			sel = new int[i];
			que(0,0,i);
		}
		System.out.println(cnt);
	}
	//재귀파트
	//문제 개수가 2개이상인 모든 조합을 찾아서 백트래킹
	static void que(int idx,int sidx,int r) {
		if(sidx==r) {
			if(check(sel)) {
				cnt++;
			}
			return;
		}
		for(int i=idx;i<=N-r+sidx;i++) {
			sel[sidx]=pArr[i];
			que(i+1,sidx+1,r);
		}
	}
	//백트래킹 파트
	static boolean check(int sel[]) {
		int sum=0;
		int max =Integer.MIN_VALUE;
		int min =Integer.MAX_VALUE;
		//문제의 조건에 맞지 않으면 false 맞으면 true 리턴
		for(int i=0;i<sel.length;i++) {
			sum+=sel[i];
			if(sel[i]>max) {
				max=sel[i];
			}
			if(sel[i]<min) {
				min=sel[i];
			}
		}
		if(sum<L||sum>R) {
			return false;
		}else if(max-min<X) {
			return false;
		}
		return true;
	}

}
