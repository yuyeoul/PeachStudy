import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2309 {
	// 재귀함수 사용함
	// Step 1. 입력받은 9개의 숫자 중에서 1개부터 9개까지의 숫자를 선택하여 합을 계산해보며 가능한 모든 조합을 찾음
	// Step 2. 재귀 함수를 사용하여 모든 조합을 탐색하고 갯수가 7, 합이 100이 되는 경우만 결과에 포함시킴
	
	public static void main(String[] args) {
		
		// 난쟁이들 키 입력받음
		// System.out.println("난쟁이들의 키는?");
		Scanner sc = new Scanner(System.in);
		
		// 9명이니까 1차원 배열에 저장
		int[] nan = new int[9];
		
		// 목표 sum이 되는 targetSum 을 100으로 저장
		int targetSum = 100;
		
		// 입력받은 키들 배열에 저장
		for (int i = 0; i < nan.length; i++) {
			nan[i] = sc.nextInt();
		}
		
		// 7명의 합이 100이 되는 조합을 찾기 위해 findCombinations 메서드 호출
		// 1) nan 배열에 저장된 키들로 합이 targetSum 인 모든 조합을 찾음
		// 2-1) 'ArrayList<Integer>': 1차원 ArrayList로, 정수 저장함
		//   2-2) 'ArrayList<ArrayList<Integer>>': 2차원 ArrayList로, 1차원 ArrayList들을 저장
		ArrayList<ArrayList<Integer>> combinations = findCombinations(nan, 100, 7);
		
		// 결과 출력
		for (ArrayList<Integer> combination : combinations) {
			// 오름차순으로 정렬(이걸 못하고 있었음)
			Collections.sort(combination);
			for (int num:combination) {
				System.out.println(num); // 한줄에 하나씩
			}
		}
		
    }
	
	// 합이 targetSum이 되는 모든 조합을 찾는 메서드 생성
    public static ArrayList<ArrayList<Integer>> findCombinations(int[] numbers, int targetSum, int count) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentCombination = new ArrayList<>();
        
        // 재귀함수를 호출하여 조합을 찾음
        findCombinationsHelper(numbers, targetSum, count, 0, currentCombination, result);
        return result;
    }
    
    // 재귀적으로 조합을 찾는 메서드
    private static void findCombinationsHelper(int[] numbers, int targetSum, int count, int currentIndex, ArrayList<Integer> currentCombination, ArrayList<ArrayList<Integer>> result) {
   
    	// Base case: count명의 난쟁이들을 선택하여 합이 100이 되면 결과에 추가하고 함수 종료
        if (count == 0 && targetSum == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Recursive case: 현재 인덱스부터 끝까지의 숫자들로 가능한 조합을 찾음
        for (int i = currentIndex; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            // 현재 숫자가 남은 합보다 크면 더 이상 조합이 불가능하므로 스킵
            if (currentNumber <= targetSum) {
                currentCombination.add(currentNumber);
                // 다음 숫자들로 가능한 조합을 찾기 위해 재귀 호출
                findCombinationsHelper(numbers, targetSum - currentNumber, count - 1, i + 1, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1); // Backtracking
            }
        }
    }
}