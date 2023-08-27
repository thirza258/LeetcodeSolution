import java.util.Stack;

public class Leetcode20 {
    /*
     * Valid Parentheses
     */
    public boolean isValid(String s) {
        // inisiasi stack untuk menyimpan karakter
        Stack<Character> stack = new Stack<>();

        // mengubah string menjadi array of char
        char[] chars = s.toCharArray();
        // iterasi untuk memasukkan karakter ke stack
        for(int i = 0; i < s.length(); i++) {
            // jika karakter adalah { atau [ atau ( maka masukkan ke stack
            if(chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
                stack.push(chars[i]);
            }
            // jika karakter adalah } atau ] atau )
            else if(chars[i] == '}' || chars[i] == ']' || chars[i] == ')') {
                // karena tidak ada karakter di stack maka mengembalikan false dan ini adalah pasangannya maka
                if(stack.isEmpty()) {
                    // return false karena tidak ada pasangan
                    return false;
                }

                // mengambil karakter dari stack
                char cTop = stack.pop();
                // jika pasangan dari karakter di stack sama dengan karakter sekarang maka lanjut
                if((cTop == '{' && chars[i] == '}') || (cTop == '[' && chars[i] == ']') || (cTop == '(' && chars[i] == ')')) {
                    continue;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Leetcode20 lc = new Leetcode20();
        String s = "()[]{}";
        System.out.println(lc.isValid(s));
    }
}
