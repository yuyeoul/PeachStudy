package Boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] arr = str.split("");
		List<String> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(i, arr[i]);
		}
		for (int i = list.size() - 1; i >=0; i--) {
			if (list.get(i).equals("=")) {
				list.set(i , list.get(i - 1) + list.get(i));
				list.remove(i-1);
			} else if (list.get(i).equals("-")) {
				list.set(i , list.get(i - 1) + list.get(i));
				list.remove(i-1);
			} else if (i>0&&list.get(i).equals("j") && (list.get(i - 1).equals("l") || list.get(i - 1).equals("n"))) {
				list.set(i , list.get(i - 1) + list.get(i));
				list.remove(i-1);
			} else if (i>0&&list.get(i).equals("z=") && list.get(i - 1).equals("d")) {
				list.set(i, list.get(i - 1) + list.get(i));
				list.remove(i-1);
			}
		}

		System.out.println(list.size());
	}

}
