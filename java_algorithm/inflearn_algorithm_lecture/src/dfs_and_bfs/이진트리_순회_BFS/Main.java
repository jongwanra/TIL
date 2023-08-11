package dfs_and_bfs.이진트리_순회_BFS;

import java.util.*;

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
		root.rt.lt = new Node(6);
		root.rt.rt = new Node(7);
		
		main.myBfs(root);
	}
	
	private void myBfs(final Node root) {
		Queue<Node> queue = new LinkedList<>(Arrays.asList(root));
		
		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			System.out.print(tmp.data + " ");
			
			if (tmp.lt != null) {
				queue.offer(tmp.lt);
			}
			if (tmp.rt != null) {
				queue.offer(tmp.rt);
			}
			
		}
	}
}
