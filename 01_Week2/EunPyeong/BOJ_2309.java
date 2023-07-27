package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> peoples = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			peoples.add(sc.nextInt());
			sum += peoples.get(i);
		}
		Collections.sort(peoples);
		int otherSum = sum - 100;
		loof : for (int i = 0; i < peoples.size(); i++) {
			for (int j = i + 1; j < peoples.size(); j++) {
				if (peoples.get(j) + peoples.get(i) == otherSum) {
					peoples.remove(peoples.get(j));
					peoples.remove(peoples.get(i));
					break loof;
				}
			}
		}
		for (int i = 0; i < peoples.size(); i++) {
			System.out.println(peoples.get(i));
		}
	}
}
