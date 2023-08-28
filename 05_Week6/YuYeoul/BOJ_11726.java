import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		//n 받기
		int num=sc.nextInt();
		//나눠줄 값
		int div=10007;
		//dp배열
		//처음에 num+1로 크기 지정해줬으나 dp[2]값을 지정해주기 때문에 num==1이면 arrayout발생
		int dp[]=new int[1001];
		
		//점화식에 따른 dp[1],dp[2]값 미리 채워주기
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=num;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%div;
		}
		System.out.println(dp[num]);
	}

}
