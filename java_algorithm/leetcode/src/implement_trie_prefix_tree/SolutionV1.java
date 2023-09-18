package implement_trie_prefix_tree;
import java.util.*;
public class SolutionV1 {
	public static void main(String[] args) {
		TrieV1 trie = new TrieV1();
		trie.insert("apple");
		trie.search("apple");   // return True
		trie.search("app");     // return False
		trie.startsWith("app"); // return True
		trie.insert("app");
		trie.search("app");     // return True
	}
}

class TrieV1 {
	private List<String> store;
	
	public TrieV1 () {
		store = new ArrayList<>();
	}
	
	public void insert(String word) {
		store.add(word);
		// for(String w: store) {
		//     System.out.print(w + " ");
		// }
		// System.out.println();
	}
	
	public boolean search(String word) {
		return store.stream()
			.filter(v -> v.equals(word))
			.anyMatch(v -> v.equals(word));
		
		
	}
	
	public boolean startsWith(String prefix) {
		return store.stream()
			.anyMatch(v -> v.startsWith(prefix));
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
