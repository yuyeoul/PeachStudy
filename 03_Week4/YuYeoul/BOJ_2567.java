package BOJ_2567_색종이2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//도화지 생성
		int map[][] =new int [102][102];
		
		//색종이 개수
		int num =sc.nextInt();
		
		for(int tc=1;tc<=num;tc++) {
			//x,y 시작위치
			int x= sc.nextInt()+1;
			int y=sc.nextInt()+1;
			//색종이 숫자로 넓이 채우기
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					map[j][i]=tc;
				}
			}
		}
		//변의 길이 저장할 변수
		int cnt=0;
		//도화지를 돌면서 백지에서 색이 칠해진 곳으로 넘어갈 때 cnt +1해주기
		//가로,세로 순회 한번에
		for(int i=1;i<101;i++) {
			for(int j=1;j<101;j++) {
				if(map[i][j]==0 && map[i][j+1]!=0) {
					cnt++;
				}else if(map[i][j]!=0 && map[i][j+1]==0) {
					cnt++;
				}
				
				if(map[j][i]==0 && map[j+1][i]!=0) {
					cnt++;
				}else if(map[j][i]!=0 && map[j+1][i]==0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
