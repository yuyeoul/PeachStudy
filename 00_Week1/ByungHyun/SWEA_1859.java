import java.util.Scanner;
 
public class SWEA_1859 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test_case = 0; test_case < t; test_case++) {
            int n = sc.nextInt();
            int[] price = new int[n];
            long max = 0;
            for (int i = 0; i < n; i++) {
                price[i] = sc.nextInt();
            }
            int number = price[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                if (price[i] > number) {
                    number = price[i];
                } else {
                    max += number - price[i];
                }
            }
            System.out.println("#" + (test_case + 1) + " " + max);
        }
        sc.close();
    }
}