public class Leetcode427 {
    public Node construct(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return null;
        }
        return quadTree(grid, 0, grid.length, 0, grid[0].length);
    }

    private Node quadTree(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        boolean isLeaf = true;
        int val = grid[rowStart][colStart];
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
            if (!isLeaf) {
                break;
            }
        }

        if (isLeaf) {
            return new Node(val == 1, true);
        }

        int midRow = (rowStart + rowEnd) / 2;
        int midCol = (colStart + colEnd) / 2;

        Node topLeft = quadTree(grid, rowStart, midRow, colStart, midCol);
        Node topRight = quadTree(grid, rowStart, midRow, midCol, colEnd);
        Node bottomLeft = quadTree(grid, midRow, rowEnd, colStart, midCol);
        Node bottomRight = quadTree(grid, midRow, rowEnd, midCol, colEnd);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}