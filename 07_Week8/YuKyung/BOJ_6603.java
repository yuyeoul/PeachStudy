package BOJ;

import java.util.*;

public class BOJ_6603 {
    public static int[] lotto; // 로또 번호를 저장할 배열
    public static int[] answer; // 조합 결과를 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        while (!input.equals("0")) { // 입력이 0이 아닌 동안 반복
            String[] temp = input.split(" ");
            lotto = new int[temp.length - 1]; // 로또 번호를 저장할 배열 초기화
            answer = new int[temp.length - 1]; // 조합 결과를 저장할 배열 초기화

            int k = Integer.parseInt(temp[0]); // 로또 번호 개수 입력

            for (int i = 1; i < temp.length; i++) {
                lotto[i - 1] = Integer.parseInt(temp[i]); // 로또 번호 입력 받기
            }
            
            dfs(0, 0, k); // 조합 생성 함수 호출
            System.out.println();

            input = sc.nextLine(); // 다음 입력을 받음
        }
    }

    public static void dfs(int idx, int depth, int k) {
        if (depth == 6) { // 6개의 순열이 만들어졌을 때
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < answer.length; i++) {
                if (answer[i] == 0) {
                    break;
                }
                stringBuilder.append(answer[i] + " ");
            }
            System.out.println(stringBuilder.toString().trim()); // 조합 출력
            return;
        }

        for (int i = idx; i < k; i++) {
            answer[depth] = lotto[i]; // 현재 인덱스에 해당하는 번호를 선택함
            dfs(i + 1, depth + 1, k); // 다음 인덱스로 이동하면서 깊이 증가
        }
    }
}