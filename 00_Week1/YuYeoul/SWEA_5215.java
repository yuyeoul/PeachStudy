package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_5215 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int num=sc.nextInt();
			int maxcal=sc.nextInt();
			int[] sco = new int[num+1];
			int[] cal = new int[num+1];
			int[][] dp =new int [num+1][maxcal+1];
			for(int j=1;j<=num;j++) {
				sco[j]=sc.nextInt();
				cal[j]=sc.nextInt();
			}
			for(int k=1;k<dp.length;k++) {
				for(int j=0;j<dp[k].length;j++) {
					if(cal[k]>j) {
						dp[k][j]=dp[k-1][j];
					}else {
						dp[k][j]=Math.max(sco[k]+dp[k-1][j-cal[k]], dp[k-1][j]);
					}
				}
			}
			System.out.println("#"+i+" "+dp[num][maxcal]);
		}
		
		
	}

}
