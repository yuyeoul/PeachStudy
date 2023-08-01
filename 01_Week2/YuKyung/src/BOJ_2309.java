import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nan = new int[9]; // 난쟁이들 키를 저장할 배열

        // 입력받은 키들 배열에 저장
        for (int i = 0; i < nan.length; i++) {
            nan[i] = sc.nextInt();
        }

        // 난쟁이들 키를 오름차순으로 정렬
        Arrays.sort(nan);

        // 난쟁이 7명의 키 합이 100이 되는지 찾는 메서드
        findSeven(nan, 0, 0, new int[7]);
    }

    // 난쟁이 7명의 키 합이 100이 되는 조합을 찾는 메서드
    public static void findSeven(int[] nan, int start, int count, int[] selected) {
    	
    	
        // 7명의 난쟁이를 선택했을 때
        if (count == 7) {
            int sum = 0;
            for (int height : selected) {
                sum += height;
            }

            // 합이 100이면 결과 출력하고 프로그램 종료
            if (sum == 100) {
                for (int height : selected) {
                    System.out.println(height);
                }
                // 강제 종료 메서드
                System.exit(0);
            }
            return;
        }

        // 7명의 난쟁이를 선택하는 경우
        for (int i = start; i < nan.length; i++) {
            selected[count] = nan[i];
            findSeven(nan, i + 1, count + 1, selected);
        }
    }
}