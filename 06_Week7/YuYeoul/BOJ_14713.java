package BOJ_14713_앵무새;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//앵무새 몇 마리인지
		int pa = sc.nextInt();
		//개행문자 처리
		sc.nextLine();
		//받아적은 문장 저장할 큐 생성
		Queue<String> ans = new LinkedList<>();
		//앵무새들이 말하는 문장을 담은 큐를 담을 리스트 생성
		List<Queue<String>> list = new LinkedList<>();
		//앵무새들의 문장을 큐에담고 그걸 다시 리스트에 담기
		for (int i = 0; i < pa; i++) {
			Queue<String> que = new LinkedList<>();
			String str[] = sc.nextLine().split(" ");
			for (int j = 0; j < str.length; j++) {
				que.add(str[j]);
			}
			list.add(i, que);
		}
		//받아적은 문장 ans에 저장
		String ansstr[] = sc.nextLine().split(" ");
		for (int i = 0; i < ansstr.length; i++) {
			ans.add(ansstr[i]);
		}
		//옳게 받아 적었는지 판별 할 변수
		boolean tf = false;
		//받아적은 문장의 길이와 앵무새들이 말하는 문장의 개수가 다르다면 impossible 출력하기
		int size=ans.size();
		int sum=0;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i).size();
		}
		if(size!=sum) {
			System.out.println("Impossible");
		}else {
		//아니라면 앵무새들의 문장 맨 앞과 ans의 맨앞을 비교해서 같으면 제거
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < pa; j++) {
					if (list.get(j).size()!=0 && list.get(j).peek().equals(ans.peek())) {
						tf = true;
						list.get(j).remove();
						ans.remove();
						break;
					}else {
						tf=false;
					}
				}
				//false라면 impossible
				if (tf == false) {
					System.out.println("Impossible");
					break;
				}
				//ans의 size가 0이 될 때 까지 반복되면 possible
				if (ans.size() == 0) {
					System.out.println("Possible");
					break;
				}

			}
		}
		

	}

}
