import java.util.Scanner;
import java.util.Stack;

public class BOJ_14713 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 앵무새들의 입력값 받기 위한 스택
		Stack[] words = new Stack[N];
		sc.nextLine();
		// 각 앵무새들의 입력값 스택에 할당
		for (int i = 0; i < N; i++) {
			String[] input = sc.nextLine().split(" ");
			Stack<String> inputStack = new Stack<>();
			for (int j = 0; j < input.length; j++) {
				inputStack.push(input[j]);
			}
			words[i] = inputStack;
		}
		// 받아적은 단어들 스택에 할당
		String[] record = sc.nextLine().split(" ");
		Stack<String> records = new Stack<>();
		for (int i = 0; i < record.length; i++) {
			records.push(record[i]);
		}

		// 받아적은 단어 갯수만큼 순회(뒤에서부터)
		for (int i = records.size() - 1; i >= 0; i--) {
			for (int j = 0; j < words.length; j++) {
				// 앵무새들의 입력값 스택의 값이 다 삭제된 경우 그냥 넘어가기
				if(words[j].isEmpty()) {
					continue;
					// 아직 남아있는 경우 일치한다면 삭제하기
				} else if(words[j].peek().equals(records.peek())) {
					words[j].pop();
					records.pop();
					break;
				}
			}
		}
		// 받아적은 단어의 갯수가 0이 되면 possible 그외 impossible
		if(records.size()==0) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
    }
}