import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode909 {
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer, Integer> boardMap = new HashMap<>();

        int index = 1;
        boolean isLeftToRight = true;
        for(int i = board.length - 1; i >= 0; i--) {
            if(isLeftToRight) {
                for(int j = 0; j < board[i].length; j++) {
                    boardMap.put(index, board[i][j]);
                    index++;
                }
            } else {
                for(int j = board[i].length - 1; j >= 0; j--) {
                    boardMap.put(index, board[i][j]);
                    index++;
                }
            }
            isLeftToRight = !isLeftToRight;
        }

        return bfs(boardMap, board.length*board.length);
    }

    private int bfs(HashMap<Integer, Integer> boardMap, int n) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int moves = 0;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++) {
                int currentSquare = queue.poll();

                if(currentSquare == n) {
                    return moves;
                }

                for(int dice = 1; dice <= 6; dice++) {
                    int nextSquare = currentSquare + dice;

                    if(nextSquare > n) {
                        continue;
                    }

                    int finalDest;
                    if(boardMap.get(nextSquare) != -1) {
                        finalDest = boardMap.get(nextSquare);
                    }
                    else {
                        finalDest = nextSquare;
                    }

                    if(!visited[finalDest]) {
                        visited[finalDest] = true;
                        queue.add(finalDest);
                    }

                }


            }
            moves++;
        }
        return -1;
    }
}
