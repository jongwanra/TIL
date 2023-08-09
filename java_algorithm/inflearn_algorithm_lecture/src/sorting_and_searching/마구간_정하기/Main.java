package sorting_and_searching.마구간_정하기;

import java.util.*;

public class Main {
	public int lectureSolution(int n, int c, int[] arr) {
		int answer = 0;
		Arrays.sort(arr);

		int lt = 1;
		int rt = arr[n - 1];
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (count(arr, mid) >= c) {
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}
		return answer;
	}

	private int count(int[] arr, int dist) {
		int cnt = 1;
		int ep = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - ep >= dist) {
				cnt++;
				ep = arr[i];
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);

		// 마구간 갯수
		int n = sc.nextInt();

		// 말의 갯수
		int c = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		System.out.println(main.mySolutionAfterLecture(n, c, arr));
	}

	private int mySolutionAfterLecture(int n, int c, int[] arr) {
		int answer = Integer.MIN_VALUE;
		// 인접한 두 말의 최대 거리를 찾는 문제
		// 인접한 거리에 대한 최솟값 최댓값을 구하자.
		// 1, 2, 8, 4, 9가 주어졌을 때,  최소 거리: 1, 최대거리: 6
		Arrays.sort(arr);
		// 최소 거리
		int lt = 1;
		// 최대 거리
		int rt = arr[arr.length - 1] - arr[0];

		// 여기서 말의 갯수가 전부 들어가지는지를 확인하는 과정에서 최대 거리를 체크하기
		while (lt <= rt) {
			int mt = (lt + rt) / 2;

			if (isEntryAllHorse(arr, mt, c)) {
				System.out.println("isTrue!");
				answer = mt;
				lt = mt + 1;
			} else {
				rt = mt - 1;
			}
		}
		return answer;
	}

	// 1  2    4    8  9

	private boolean isEntryAllHorse(int[] arr, int distance, int horseCount) {
		System.out.println("distance: " + distance + " horseCount:" + horseCount);
		int cnt = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (cnt == horseCount) {
				return true;
			}
			int p = i + 1;
			while (p < arr.length) {
				int _distance = Math.abs(arr[i] - arr[p]);
				if (distance <= _distance) {
					cnt++;
					i = p;
					break;
				} else {
					p++;
				}
			}
		}
		return false;
	}
}