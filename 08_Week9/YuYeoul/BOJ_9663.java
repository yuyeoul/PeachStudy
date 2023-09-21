import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int cnt=0;
	static int arr[];
	public static void main(String[] args) {
		N=sc.nextInt();
		arr=new int [N];
		DFS(0);
		System.out.println(cnt);
	}
	static void DFS(int d) {
		if(d==N) {
			cnt++;
			return ;
		}
		for(int i=0;i<N;i++) {
			arr[d]=i;
			if(search(d)) {
				DFS(d+1);
			}
		}
		
	}
	static boolean search(int c) {
		for(int i=0;i<c;i++) {
			if(arr[c]==arr[i]) {
				return false;
			}else if(c-i==Math.abs(arr[c]-arr[i]) ) {
				return false;
			}
		}
		return true;
	}
}
