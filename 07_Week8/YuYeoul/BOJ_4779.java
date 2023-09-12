package BOJ_4779_칸토어집합;

import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			sb=new StringBuilder();
			int num=sc.nextInt();
			//-의 총 길이
			int N=(int) Math.pow(3, num);
			//stringbuilder에 담기
			for(int i=0;i<N;i++) {
				sb.append("-");
			}
			//재귀호출
			dmdkr(0,N);
			//출력
			System.out.println(sb);
		}
	}
	
	public static void dmdkr(int s,int N) {
		//기저파트
		//-가 하나만 있으면 리턴
		if(N==1) {
			return;
		}
		//3등분
		int newN=N/3;
		//시작지점부터 3등분지점까지 공백으로
		for(int i=s+newN;i<s+2*newN;i++) {
			sb.setCharAt(i, ' ');
		}
		
		 
		//앞부분과 뒷부분 분리
		dmdkr(s,newN);
		dmdkr(s+2*newN,newN);
		
		
	}
}
