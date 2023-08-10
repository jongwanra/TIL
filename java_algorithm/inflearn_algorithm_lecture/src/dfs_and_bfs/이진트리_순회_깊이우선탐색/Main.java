package dfs_and_bfs.이진트리_순회_깊이우선탐색;

/*
	이진 트리 순회 중
	* 전위 순회(부모 -> 왼쪽 자식 -> 오른쪽 자식)
	* 중위 순회(왼쪽 자식 -> 부모 -> 오른쪽 자식)
	* 후위 순회(왼쪽 자식 -> 오른쪽 자식 -> 부모)
	
	에 대해서 출력 해보자.
	
						1
						
			2							3
			
	4				5			6					7
	

*/

class Node {
	int data;
	Node lc; // 왼쪽 자식 참조
	Node rc; // 오른쪽 자식 참조
	
	public Node(int data) {
		this.data = data;
		this.lc = null;
		this.rc = null;
	}
}

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		// initialize tree
		Node root = new Node(1);
		root.lc = new Node(2);
		root.rc = new Node(3);
		root.lc.lc = new Node(4);
		root.lc.rc = new Node(5);
		root.rc.lc = new Node(6);
		root.rc.rc = new Node(7);
		
		main.myDfs(root);
	}
	
	private void myDfs(Node node) {
		if (node == null) {
			return;
		}
		// System.out.print(node.data + " "); // 전위 순회
		myDfs(node.lc);
		// System.out.print(node.data + " "); // 중위 순회
		myDfs(node.rc);
		
		System.out.print(node.data + " "); // 후위 순회
	}
}
