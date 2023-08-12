import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//총 인원
		int num = sc.nextInt();
		//한번에 움직일 거리
		int a = sc.nextInt();
		
		//기존 인원을 담을 리스트
		List<Integer> list = new ArrayList<Integer>();
		//제거된 인원을 새로 담을 리스트
		List<Integer> nlist = new ArrayList<Integer>();

		for (int i = 1; i <= num; i++) {
			list.add(i);
		}
		

		while (true) {
			//주어진 인원이 1이고 움직일 거리가 1이라면 끝 
			if(num==1&&a==1) {
				nlist.add(list.get(0));
				break;
			}else {
			//rotate 내장함수를 이용하여 a명 뒤로보내고 맨 앞 사람 nlist에 저장후 제거
			Collections.rotate(list, -(a - 1));
			nlist.add(list.get(0));
			list.remove(0);
			//기존인원이 한명뿐이라면 저장후 끝내기
			if (list.size() == 1) {
				nlist.add(list.get(0));
				break;
			}
		}
		}
		System.out.print("<");
		for (int i = 0; i < nlist.size(); i++) {
			if (i <= nlist.size() - 2) {
				System.out.print(nlist.get(i) + ", ");
			} else {
				System.out.print(nlist.get(i) + ">");
			}

		}
	}
}