import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1158 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		// 1에서 N 값까지 할당한 리스트
		List<Integer> originalList = new ArrayList<>();
		// 리스트에 값(1~N) 넣기
		for (int i = 1; i <= N; i++) {
			originalList.add(i);
		}
		System.out.print("<");
		// removeLis의 갯수가 N개가 되기 전까지 반복문 실행
		while (originalList.size() > 0) {
			// K만큼 반복문 실행
			for (int i = 0, idx = 0; i < K; i++) {
				// K번째에는 제거해야할 값이기 때문에 출력하고 원본 리스트에선 값 제거
				if (i == K - 1) {
					if (originalList.size() == 1) {
						System.out.printf("%d", originalList.get(idx));
					} else {

						System.out.printf("%d, ", originalList.get(idx));
					}
					originalList.remove(idx);
					// 이외에는 원본 리스트에 값 추가한 뒤, 앞에서 값 삭제
				} else {
					originalList.add(originalList.get(idx));
					originalList.remove(idx);
				}
			}
		}
		System.out.println(">");
	}
}


