import java.util.Stack;

public class Leetcode735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < asteroids.length; i++) {
            //Jika stack tidak kosong dan asteroid kurang dari 0 dan stack peek lebih dari 0
            while(!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0) {
                // Menjumlahkan stack peek dengan asteroid untuk menemukan hasil tabrakan asteroidnya
                // yang juga mencari yang mana yang lebih besar
                int top = stack.peek() + asteroids[i];
                // Jika asteroid lebih besar dari stack peek maka stack peek di pop
                if(top < 0) {
                    stack.pop();
                }
                // Jika asteroid lebih kecil dari stack peek maka asteroid di set atau dikeluarkan
                else if(top > 0) {
                    asteroids[i] = 0;
                }
                // Jika asteroid sama dengan stack peek maka asteroid dan stack peek di pop 
                else {
                    stack.pop();
                    asteroids[i] = 0;
                }
            }
            if(asteroids[i] != 0) {
                stack.push(asteroids[i]);
            }
        }

        int[] result = new int[stack.size()];
        while(!stack.isEmpty()) {
            result[stack.size() - 1] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode735 lc = new Leetcode735();
        int[] asteroids = {5,10,-5};
        int[] result = lc.asteroidCollision(asteroids);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
