import java.util.ArrayList;
import java.util.List;

public class Leetcode212 {
    public List<String> findWords(char[][] board, String[] words) {

        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return List.of();
        }

        int rows = board.length;
        int cols = board[0].length;

        TrieNode212 root = new TrieNode212();
        for(String word : words) {
            TrieNode212 current = root;
            for(char c : word.toCharArray()) {
                if(current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode212();
                }
                current = current.children[c - 'a'];
            }
            current.word = word;
        }

        boolean[][] visited = new boolean[rows][cols];
        List<String> result = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                char startChar = board[i][j];
                TrieNode212 childNode = root.children[startChar - 'a'];
                if(childNode != null) {
                    DFS(board, i, j, childNode, visited, result);
                }
            }
        }

        return result;
    }

   private void DFS(char[][] board, int row, int col, TrieNode212 node, boolean[][] visited,List<String> result) {
        visited[row][col] = true;
        if(node.isWord()) {
            result.add(node.word);
            node.word = null;
        }

        int[][] directions = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        for(int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && !visited[newRow][newCol]) {
                char nextChar = board[newRow][newCol];
                TrieNode212 childNode = node.children[nextChar - 'a'];
                if(childNode != null) {
                    DFS(board, newRow, newCol, childNode, visited, result);
                }
            }
        }

       visited[row][col] = false;
   }
}

class TrieNode212 {
    TrieNode212[] children;
    String word;

    boolean isWord() {
        return this.word != null;
    }

    public TrieNode212() {
        this.children = new TrieNode212[26];
        this.word = null;
    }
}
