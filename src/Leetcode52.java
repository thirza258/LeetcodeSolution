public class Leetcode52 {
    public int totalNQueens(int n) {
        if(n <= 0) {
            return 0;
        }

        int row = 0;
        int count = 0;

        boolean[] cols = new boolean[n];
        boolean[] diagleftUp = new boolean[2 * n - 1];
        boolean[] diagrightUp = new boolean[2 * n - 1];

        count = getCount(n, row, cols, diagleftUp, diagrightUp, count);

        return count;
    }

    private int backtrack(int n, int row, boolean[] cols, boolean[] diagleftUp, boolean[] diagrightUp) {
        if(row == n) {
            return 1;
        }

        int count = 0;

        count = getCount(n, row, cols, diagleftUp, diagrightUp, count);

        return count;
    }

    private int getCount(int n, int row, boolean[] cols, boolean[] diagleftUp, boolean[] diagrightUp, int count) {
        for(int i = 0; i < n; i++) {
            if(!cols[i] && !diagleftUp[row + i] && !diagrightUp[row - i + n - 1]) {
                cols[i] = true;
                diagleftUp[row + i] = true;
                diagrightUp[row - i + n - 1] = true;

                count += backtrack(n, row + 1, cols, diagleftUp, diagrightUp);

                cols[i] = false;
                diagleftUp[row + i] = false;
                diagrightUp[row - i + n - 1] = false;
            }
        }
        return count;
    }
}
