import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {

    static int T;
    static StringBuffer sb = new StringBuffer(); // 출력 결과를 저장하는 StringBuffer
    static int temp = 1; // 스택에 넣을 숫자
    static boolean err = false; // 에러 여부

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        Stack<Integer> stack = new Stack<>(); // 스택 생성

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();

            for (; temp <= N; temp++) { // 1부터 N까지 스택에 순차적으로 넣음
                stack.push(temp);
                sb.append("+").append("\n"); // 스택에 숫자를 넣을 때마다 '+' 추가
            }

            if (stack.peek() == N) { // 스택의 맨 위에 있는 숫자가 N과 같다면
                stack.pop(); // 스택에서 숫자를 제거하고
                sb.append("-").append("\n"); // '-' 추가
            } else {
                err = true; // 스택의 맨 위에 있는 숫자가 N과 다르다면 에러
            }
        }

        if (err)
            System.out.println("NO"); // 에러가 발생했다면 "NO" 출력
        else
            System.out.println(sb.toString()); // 아니면 결과를 출력
    }
}