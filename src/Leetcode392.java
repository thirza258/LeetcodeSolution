public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        // Jika s kosong, return true
        if(s.length() <= 0) {
            return true;
        }

        // Menginisialisasi index i dan j
        int i = 0;
        int j = 0;
        // Selama j kurang dari panjang string t
        while(j < t.length()) {
            // Jika character di index i dan j sama, maka increment i dan j
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                // Jika i sama dengan panjang string s, maka return true
                if(i == s.length()) {
                    return true;
                }
            }
            // Jika character di index i dan j tidak sama, maka increment j saja untuk mencari character selanjutnya
            else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode392 leetcode392 = new Leetcode392();
        System.out.println(leetcode392.isSubsequence("abc", "ahbgdc"));
        System.out.println(leetcode392.isSubsequence("axc", "ahbgdc"));
    }
}
