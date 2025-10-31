public class Leetcode211 {
    private TrieNode root;

    public Leetcode211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null) {
                    if (this.searchHelper(word, index + 1, node.children[j])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int childIndex = ch - 'a';
            if (node.children[childIndex] == null) {
                return false;
            }
            return this.searchHelper(word, index + 1, node.children[childIndex]);
        }
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }
}
