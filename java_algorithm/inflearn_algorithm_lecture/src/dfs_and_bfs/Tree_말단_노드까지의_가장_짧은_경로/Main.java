package dfs_and_bfs.Tree_말단_노드까지의_가장_짧은_경로;

import java.util.*;

/*
 * 최단 거리 관련 문제는 BFS를 활용해서 푸는게 좋다.
 * */

class Node {
	int data;
	Node lt;
	Node rt;
	
	Node(int data) {
		this.data = data;
		lt = null;
		rt = null;
	}
}

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Node root = new Node(1);
		root.lt = new Node(2);
		root.rt = new Node(3);
		root.lt.lt = new Node(4);
		root.lt.rt = new Node(5);
		System.out.println(main.myBfs(root));
	}
	
	private int lectureBfs(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			
			for (int i = 0; i < len; i++) {
				Node cur = Q.poll();
				if (cur.lt == null && cur.rt == null) {
					return L;
				}
				
				if (cur.lt == null) {
					Q.offer(cur.lt);
				}
				if (cur.rt != null) {
					Q.offer(cur.rt);
				}
			}
			L++;
		}
		
		return 0;
	}
	
	private int myBfs(Node root) {
		int depth = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int len = queue.size();
			
			for (int i = 0; i < len; i++) {
				Node tmp = queue.poll();
				if (tmp.lt == null && tmp.rt == null) {
					return depth;
				}
				
				queue.offer(tmp.lt);
				queue.offer(tmp.rt);
			}
			depth++;
		}
		return 0;
	}
}
