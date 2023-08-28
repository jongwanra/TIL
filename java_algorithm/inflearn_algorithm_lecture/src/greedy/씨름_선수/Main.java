package greedy.씨름_선수;

import java.util.*;

// section 6 좌표정렬과 함께 보자

class Body implements Comparable<Body> {
	public int h, w;
	
	Body(int h, int w) {
		this.h = h;
		this.w = w;
	}
	
	@Override
	public int compareTo(Body o) {
		return o.h - this.h;
	}
}

class Physical implements Comparable<Physical> {
	int height;
	int weight;
	
	Physical(final int height, final int weight) {
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Physical physical = (Physical)o;
		return height == physical.height && weight == physical.weight;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(height, weight);
	}
	
	@Override
	public int compareTo(Physical o) {
		if (this.height == o.height) {
			return this.weight - o.weight;
		}
		return this.height - o.height;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		final int n = sc.nextInt();
		
		ArrayList<Physical> arr = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			arr.add(new Physical(sc.nextInt(), sc.nextInt()));
		}
		
		System.out.println(main.mySolution(arr, n));
		
	}
	
	/*
	 *  아.. O(n) 시간복잡도로 풀 수 있는 방법이 있었구나
	 * 키와 몸무게에 대해서 둘다 큰 사람이 있으면 탈락이기 때문에
	 * 키를 기준으로 내림차순 정렬 이후에 둘다 큰 사람이 있는지를 max_weight으로 체크하면 된다..
	 *
	 * */
	private int lectureSolution(ArrayList<Body> arr, int n) {
		int cnt = 0;
		Collections.sort(arr); // height 기준 내림차순 정렬
		int max = Integer.MIN_VALUE;
		
		for (Body ob : arr) {
			if (ob.w > max) {
				max = ob.w;
				cnt++;
			}
		}
		return cnt;
	}
	
	private int mySolution(ArrayList<Physical> arr, final int n) {
		HashSet<Physical> set = new HashSet<>();
		
		Collections.sort(arr);
		
		for (int i = 0; i < n; i++) {
			final Physical target = arr.get(i);
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				// 동일할 경우 패스
				if (i == j) {
					continue;
				}
				
				final Physical toCompare = arr.get(j);
				if (target.height < toCompare.height && target.weight < toCompare.weight) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				set.add(target);
			}
		}
		
		// for (Physical x : set) {
		// 	System.out.println("h: " + x.height + " w: " + x.weight);
		// }
		return set.size();
	}
	
}
