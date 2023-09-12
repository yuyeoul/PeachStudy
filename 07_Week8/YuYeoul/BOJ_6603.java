package BOJ_6603_로또;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			//숫자 몇개인지
			int num= sc.nextInt();
			//0이면 종료
			if(num==0) {
				break;
			}
			//로또 번호 담을 배열
			int sel[]=new int [6];
			//전체 숫자 담을 배열 및 넣기
			int arr[]=new int [num];
			for(int i=0;i<num;i++) {
				arr[i]=sc.nextInt();
			}
			//재귀 호출
			combi(0, 0, num, arr,sel);
			System.out.println();
		}
		

	}
	public static void combi(int in,int idx,int num,int arr[],int sel[]) {
		//기저파트
		//6개 뽑았으면
		if(idx==6) {
			//sel배열에 담긴 6개 숫자 출력
			for (int i = 0; i < 6; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		//재귀파트
		for(int i=in;i<=num-6+idx;i++) {
			sel[idx]=arr[i];
			combi(i+1,idx+1, num, arr,sel);
		}
	}

}
