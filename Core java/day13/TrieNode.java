package day13;
import java.util.HashMap;
import java.util.Map;
public class TrieNode {
	Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfWord;
    }
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");
       
        // Test the search method
        System.out.println(trie.search("apple")); // Output: true
        System.out.println(trie.search("app"));   // Output: true
        System.out.println(trie.search("appl"));  // Output: false
       
        // Test the startsWith method
        System.out.println(trie.startsWith("app")); // Output: true
        System.out.println(trie.startsWith("ban")); // Output: true
        System.out.println(trie.startsWith("bat")); // Output: false
    }

	}


