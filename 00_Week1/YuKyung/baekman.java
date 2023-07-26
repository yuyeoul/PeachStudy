import java.util.Scanner;

public class baekman {
	    public static void main(String args[]) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt(); // 테스트 케이스의 수를 입력받음
	         
	        for(int i = 1; i <= T; i++) {   
	            long start = 0; // 최소 매매가를 저장하는 변수
	            long ans = 0; // 최대 이익을 저장하는 변수
	             
	            int N = sc.nextInt(); // 연속된 N일 동안의 매매가 개수를 입력받음
	            long[] arr = new long[N]; // 매매가를 저장하는 배열

	            for(int j = 0; j < N; j++) {
	                arr[j] = sc.nextInt(); // N일 동안의 매매가를 입력받아 배열에 저장
	            }   
	             
	            for(int j = N - 1; j >= 0; j--) {
	                if (start > arr[j]) {
	                    ans += start - arr[j]; // 현재 매매가보다 이전의 최소 매매가와의 차액을 최대 이익에 더함
	                } else {
	                    start = arr[j]; // 현재 매매가가 최소 매매가보다 크거나 같을 경우 최소 매매가를 현재 매매가로 변경
	                } 
	            }
	             
	            System.out.println("#" + i + " " + ans); // 계산된 최대 이익 출력
	        }
	    }
	

}
