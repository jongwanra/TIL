package greedy.결혼식;

import java.util.*;

class Time implements Comparable<Time> {
	int time;
	char state;
	
	Time(int time, char state) {
		this.time = time;
		this.state = state;
	}
	
	@Override
	public int compareTo(Time t) {
		if (this.time == t.time) {
			return this.state - t.state; // 동일할 경우 'e'가 먼저 나오게 하기 위함.
		}
		return this.time - t.time;
	}
	
}

public class LectureMain {
	
	public static void main(String[] args) {
		LectureMain main = new LectureMain();
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		ArrayList<Time> arr = new ArrayList<>(n * 2);
		
		for (int i = 0; i < n; i++) {
			arr.add(new Time(sc.nextInt(), 's'));
			arr.add(new Time(sc.nextInt(), 'e'));
		}
		
		System.out.println(main.lectureSolution(arr));
	}
	
	private int lectureSolution(ArrayList<Time> arr) {
		Collections.sort(arr);
		int answer = Integer.MIN_VALUE;
		int curCnt = 0;
		for (Time x : arr) {
			if (x.state == 's') {
				curCnt++;
			} else {
				curCnt--;
			}
			answer = Math.max(answer, curCnt);
		}
		return answer;
	}
}
