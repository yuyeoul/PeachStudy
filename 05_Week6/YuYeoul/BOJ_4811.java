import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(true) {
			int num= sc.nextInt();
			if(num==0) {
				break;
			}
			
			long dp[]=new long[31];
			dp[0]=1;
			//알약 하나일 때 전체->반 알 ==경우의 수 1
			dp[1]=1;
			//알약 두 개일 때
			//전체-> 전체1 반알1 남음----반알 전체 반알 or 전체 반알 반알==경우의 수 2
			dp[2]=2;
			//알약 세 개일 때
			//전체->전체2반알1----(전체 전체)->2 반알+전체 반알 전체 반알->1+반알부터 먹으면 알약 두개일때와 같으므로2
			//따라서 세개일 때는 5
			
			for(int i=3;i<=num;i++) {
				long cnt=0;
				for(int j=0;j<i;j++) {
					cnt+=dp[j]*dp[i-1-j];
				}
				dp[i]=cnt;
			}
			System.out.println(dp[num]);
		}
	}

}
