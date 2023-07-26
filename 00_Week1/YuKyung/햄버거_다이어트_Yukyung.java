package first_230725;

import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수를 입력받음

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 재료의 수
            int L = sc.nextInt(); // 제한 칼로리

            int[] taste = new int[N]; // 재료의 맛에 대한 점수를 저장하는 배열
            int[] calorie = new int[N]; // 재료의 칼로리를 저장하는 배열

            for (int i = 0; i < N; i++) {
                taste[i] = sc.nextInt(); // 재료의 맛에 대한 점수를 입력받아 배열에 저장
                calorie[i] = sc.nextInt(); // 재료의 칼로리를 입력받아 배열에 저장
            }

            int maxTaste = getMaxTaste(N, L, taste, calorie); // 최대 맛에 대한 점수 계산
            System.out.println("#" + test_case + " " + maxTaste);
        }
    }

    private static int getMaxTaste(int N, int L, int[] taste, int[] calorie) {
        return dfs(N, L, taste, calorie, 0, 0);
    }

    private static int dfs(int N, int L, int[] taste, int[] calorie, int idx, int totalCalorie) {
        if (idx == N) {
            return 0;
        }

        int maxTaste = 0;
        // 현재 재료를 선택하는 경우
        if (totalCalorie + calorie[idx] <= L) {
            maxTaste = taste[idx] + dfs(N, L, taste, calorie, idx + 1, totalCalorie + calorie[idx]);
        }

        // 현재 재료를 선택하지 않는 경우
        int notChoose = dfs(N, L, taste, calorie, idx + 1, totalCalorie);

        return Math.max(maxTaste, notChoose);
    }
}