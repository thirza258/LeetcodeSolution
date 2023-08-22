public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int current = 0;
        int start = gas.length - 1;
        int total = 0;

        do {
            if (total + gas[current] - cost[current] >= 0) {
                total = total + (gas[current] - cost[current]);
                current++;
            }
            else {
                start--;
                total = total + (gas[start] - cost[start]);
            }
        } while (current != start);

        if (total >= 0) {
            return start % gas.length;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Leetcode134 leetcode134 = new Leetcode134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(leetcode134.canCompleteCircuit(gas, cost));
    }
}
