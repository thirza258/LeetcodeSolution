public class Leetcode521 {
    public int findLUSlength(String a, String b) {
        // Jika a sama dengan b, maka kembalikan nilai -1 karena tidak ada subsequence yang berbeda
        if(a.equals(b)) {
            return -1;
        }
        // Jika berbeda, maka kembalikan nilai maksimum dari panjang a dan b
        else {
            return Math.max(a.length(), b.length());
        }
    }
}
