package greedy.친구인가;

import java.util.*;

public class Main {
	static void printArr(int[] arr, int a, int b) {
		System.out.println("input: " + a + " / " + b);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + ":" + arr[i] + "/ ");
		}
		System.out.println("-----");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		final int n = sc.nextInt();
		final int m = sc.nextInt();
		int[] arr = new int[n + 1];
		
		int groupingNum = 0;
		for (int loop = 0; loop < m; loop++) {
			final int personA = sc.nextInt();
			final int personB = sc.nextInt();
			
			// 동일하게 그룹핑 안되어 있는 경우
			if (arr[personA] == 0 && arr[personB] == 0) {
				groupingNum++;
				arr[personA] = groupingNum;
				arr[personB] = groupingNum;
			}
			
			// A만 그룹핑이 되어있는 경우
			else if (arr[personA] > 0 && arr[personB] == 0) {
				arr[personB] = arr[personA];
			}
			
			// B만 그룹핑이 되어있는 경우
			else if (arr[personA] == 0 && arr[personB] > 0) {
				arr[personA] = arr[personB];
			}
			
			// 둘다 되어 있는데 서로 다른 경우
			else if (arr[personA] != arr[personB]) {
				final int toChange = arr[personA];
				final int prev = arr[personB];
				
				for (int i = 1; i <= n; i++) {
					if (arr[i] == prev) {
						arr[i] = toChange;
					}
				}
			}
			// printArr(arr, personA, personB);
		}
		
		final int a = sc.nextInt();
		final int b = sc.nextInt();
		
		if (arr[a] == 0 && arr[b] == 0) {
			System.out.println("NO");
		} else if (arr[a] == arr[b]) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}
}
