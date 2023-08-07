import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        // 색종이가 놓이는 평면
		int[][] papers = new int[1001][1001];
		Scanner sc = new Scanner(System.in);
        // n : 색종이 개수
		int n = sc.nextInt();
        //
		int max_row = 0;
		int max_col = 0;
		for(int i = 1; i<=n; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			int third = sc.nextInt();
			int fourth = sc.nextInt();
            // first에 가로 길이(third)만큼 이동 후 도착하는 점
			int row = first + third - 1;
            // second에 세로 길이(fourth)만큼 이동 후 도착하는 점
			int col = second + fourth - 1;

            // 가로 최대 길이 구하기
			if(max_row<row) {
				max_row = row;
			}
            // 세로 최대 길이 구하기
			if(max_col<col) {
				max_col = col;
			}

            // 해당 색종이마다 해당 값(i)으로 덮어씌우기
			for(int j = first ; j<=row; j++) {
				for(int k = second; k<=col ; k++) {
					papers[j][k] = i;
				}
			}
		}

        // 갯수(위에서 바라봤을 때 보이는 색종이 넓이) 세기
		int[] result = new int[n];
		for(int i = 0; i<=max_row;i++) {
			for(int j = 0 ; j<=max_col; j++) {
				if(papers[i][j]!=0) {
					result[papers[i][j]-1] += 1;
				}
			}
		}

        // 출력
		for(int i = 0 ; i<n;i++) {
			System.out.println(result[i]);
		}
	}
}
