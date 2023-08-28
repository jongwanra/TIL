package greedy.회의실_배정;

import java.util.*;

class Time implements Comparable<Time> {
	int start, end;
	
	Time(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	// end 시간을 가지고 오름차순을 수행
	public int compareTo(Time o) {
		if (end == o.end) {
			return this.start - o.start;
		}
		return end - o.end;
	}
	
	@Override
	public String toString() {
		return "start: " + start + " end: " + end;
	}
}

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		final int n = sc.nextInt();
		ArrayList<Time> arr = new ArrayList<>(n);
		
		for (int i = 0; i < n; i++) {
			arr.add(new Time(sc.nextInt(), sc.nextInt()));
		}
		System.out.println(main.mySolution(arr, n));
	}
	
	private int mySolution(ArrayList<Time> arr, final int n) {
		Collections.sort(arr); // end값을 기준으로 오름차순
		
		// for (Time x : arr) {
		// 	System.out.println(x);
		// }
		int answer = 1;
		int curEnd = arr.get(0).end;
		for (int i = 1; i < n; i++) {
			if (arr.get(i).start >= curEnd) {
				answer++;
				curEnd = arr.get(i).end;
			}
		}
		
		return answer;
	}
}
