package implement_trie_prefix_tree;


public class OtherSolution {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.search("apple");   // return True
		trie.search("app");     // return False
		trie.startsWith("app"); // return True
		trie.insert("app");
		trie.search("app");     // return True
	}
}
class TrieNode {
	TrieNode[] children;
	boolean isEndOfWord;
	
	public TrieNode() {
		children = new TrieNode[26]; // Assuming lowercase English letters
		isEndOfWord = false;
	}
}

class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (node.children[index] == null) {
				node.children[index] = new TrieNode();
			}
			node = node.children[index];
		}
		node.isEndOfWord = true;
	}
	
	public boolean search(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (node.children[index] == null) {
				return false; // The character is not found
			}
			node = node.children[index];
		}
		return node.isEndOfWord; // Check if it's the end of a valid word
	}
	
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (char ch : prefix.toCharArray()) {
			int index = ch - 'a';
			if (node.children[index] == null) {
				return false; // The prefix is not found
			}
			node = node.children[index];
		}
		return true; // The prefix exists in the trie
	}
}
