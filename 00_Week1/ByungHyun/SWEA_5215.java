import java.util.Scanner;

public class SWEA_5215 {
	public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test_case = 0; test_case < t; test_case++) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int[][] buger = new int[n + 1][l + 1];
            for (int i = 1; i < n + 1; i++) {
                int t_i = sc.nextInt();
                int k_i = sc.nextInt();
                for (int j = 1; j < l + 1; j++) {
                    if (k_i <= j) {
                        buger[i][j] = Math.max(buger[i - 1][j - k_i] + t_i, buger[i - 1][j]);                       
                    } else {
                        buger[i][j] = buger[i - 1][j];
                    }
                }
            }
            System.out.println("#" + (test_case + 1) + " " + buger[n][l]);
        }
        sc.close();
    }
}
