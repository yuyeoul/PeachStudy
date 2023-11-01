package SWEA_1209_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			//A,B인풋 받기
			int A=sc.nextInt();
			int B=sc.nextInt();
			
			int arrA[]=new int[A];
			int arrB[]=new int[B];
			for(int i=0;i<A;i++) {
				arrA[i]=sc.nextInt();
			}
			
			for(int i=0;i<B;i++) {
				arrB[i]=sc.nextInt();
			}
			//이분탐색 위해 정렬
			Arrays.sort(arrA);
			Arrays.sort(arrB);
			//A가 먹을 수 있는 개수
			int cnt=0;
			//A돌면서
			for(int i=0;i<A;i++) {
				//A가 1이면 아무것도 못먹으니까 1보다 클 때
				if(arrA[i]>1) {
					//이분탐색 시작점
					int start=0;
					//이분탐색 끝점
					int end=B-1;
					//중간지점
					int mid=0;
					//시작지점이 끝지점보다 작거나 같아질 때 까지
					while(start<=end) {
						//중간값 갱신
						mid=(start+end)/2;
						//만약 A가 B의 중간지점보다 큰쪽에 위치한다면
						if(arrA[i]>arrB[mid]) {
							//시작지점 갱신
							start=mid+1;
						}else {
							//만약 A가 B의 중간지점보다 작은 쪽에 위치한다면
							//끝 지점 갱신
							end=mid-1;
						}
					}
					cnt+=start;
				}
			}
			System.out.println(cnt);
		}

	}
}
