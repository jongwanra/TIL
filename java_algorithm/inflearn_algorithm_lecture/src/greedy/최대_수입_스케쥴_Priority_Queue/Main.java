package greedy.최대_수입_스케쥴_Priority_Queue;

import java.util.*;

class Lecture implements Comparable<Lecture> {
	int fee;
	int end;
	
	Lecture(int fee, int end) {
		this.fee = fee;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "{ fee: " + fee + " end: " + end + "}";
	}
	
	@Override
	public int compareTo(Lecture l) {
		// if (this.end == l.end) {
		// 	return l.fee - this.fee;
		// }
		// return l.end - this.end;
		return l.end - this.end;
	}
}

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		int maxDay = Integer.MIN_VALUE;
		final int n = sc.nextInt();
		ArrayList<Lecture> arr = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			int fee = sc.nextInt();
			int d = sc.nextInt();
			arr.add(new Lecture(fee, d));
			if (maxDay < d) {
				maxDay = d;
			}
		}
		System.out.println(main.mySolution(arr, maxDay));
	}
	
	// runtime error..!
	// priority queue에서 꺼낼 때 null check를 해주지 않아서 발생!
	private int mySolution(ArrayList<Lecture> arr, final int maxDay) {
		final int arrLen = arr.size();
		PriorityQueue<Integer> pQ = new PriorityQueue<>(arrLen, Collections.reverseOrder());
		
		int answer = 0;
		Collections.sort(arr); // 날짜 기준 내림차순 정렬
		
		int arrIdx = 0;
		for (int day = maxDay; day > 0; day--) {
			while (arrIdx < arrLen && day == arr.get(arrIdx).end) {
				pQ.offer(arr.get(arrIdx).fee);
				arrIdx++;
			}
			if (!pQ.isEmpty()) {
				answer += pQ.poll();
			}
		}
		return answer;
	}
}
