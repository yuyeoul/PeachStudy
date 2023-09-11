package BOJ_16719_ZOAC;

import java.util.Scanner;

public class Main {
	public static char[] word;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		word = sc.next().toCharArray();
		visited = new boolean[word.length];
		
		recursive(0);
		
		System.out.println(sb);
	}
	
	public static void recursive(int index) {
		if (index >= word.length) {
			return;
		}
		int min = 1000;
		int minindex = -1;
		for (int i = index; i < word.length; i++) {
			if (!visited[i] && min > word[i]) {
				minindex = i;
				min = word[i];
			}
		}
		if (minindex == -1) {
			return;
		}
		visited[minindex] = true;
		for (int i = 0; i < word.length; i++) {
			if (visited[i]) {
				sb.append(word[i]);
			}
		}
		sb.append("\n");
		recursive(minindex + 1);
		recursive(index);
	}
}
