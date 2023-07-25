package swea;
import java.util.Scanner;

public class SWEA_1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int num = sc.nextInt();

			int arr[] = new int[num];
			for (int j = 0; j < num; j++) {
				arr[j] = sc.nextInt();
			}
			int start = 0;
			int total = 0;
			int sum = 0;
			Long ltotal=Long.valueOf(total);
			Long lsum=Long.valueOf(sum);
			while (true) {
				int max = 0;
				int maxi = 0;
				for (int k = start; k < num; k++) {
					if (max < arr[k]) {
						max = arr[k];
						maxi = k;
					}
				}
				if (maxi != 0&&maxi<num) {
					for (int l = start; l < maxi; l++) {
						lsum = lsum + arr[l];
					}
					ltotal = ltotal + (long)(max * (maxi - start)) - lsum;
					start = maxi + 1;
					max = 0;
					lsum = (long) 0;
				} else if (maxi == 0) {
					start += 1;
				}
				if(start>=num){
					break;
				}
			}
			
			System.out.println("#" + i + " " + ltotal);
		}
	}

}
