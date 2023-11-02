package possible_bipartition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 실패..
 * 이 문제는 이분 그래프 - 2 color기법 문제 였다.
 * 문제를 풀기 전에 해당 이분 그래프에 대한 공부가 필요하다고 느낌.
 * https://www.youtube.com/watch?v=Z4VbDVAeyF4
 * */
public class Solution231102 {
	// cycle이 있는지 여부를 체크하는건가..?
	public boolean possibleBipartition(int n, int[][] dislikes) {
		HashMap<Integer, List<Integer>> graph = new HashMap<>(n);

		for (int[] dislike : dislikes) {
			List<Integer> list = graph.getOrDefault(dislike[0], new ArrayList<>());
			list.add(dislike[1]);
			graph.put(dislike[0], list);
		}

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();

		// bfs로 cycle 찾기
		visited[1] = true;
		queue.offer(1);

		while (!queue.isEmpty()) {

			int polled = queue.poll();
			List<Integer> list = graph.getOrDefault(polled, new ArrayList<>());
			for (Integer l : list) {
				if (visited[l]) {
					return false;
				}
				visited[l] = true;
				queue.offer(l);
			}

		}
		return true;
	}
}
