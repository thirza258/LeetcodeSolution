import java.util.HashMap;

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        // inisiasi hashmap untuk menyimpan karakter dan indeksnya
        HashMap<Character, Integer> map = new HashMap<>();
        
        // maxLen untuk menyimpan panjang substring terpanjang
        int maxLen = 0;
        // lastRepeatPosition untuk menyimpan indeks dari karakter yang terakhir kali muncul
        int lastRepeatPosition = -1;

        // mengiterasi string s
        for(int i = 0; i < s.length(); i++) {
            // jika map mengandung karakter yang sedang diiterasi
            // dan indeks dari karakter yang sedang diiterasi lebih besar dari lastRepeatPosition
            if(map.containsKey(s.charAt(i)) && lastRepeatPosition < map.get(s.charAt(i))) {
                // mengubah lastRepeatPosition menjadi indeks dari karakter yang sedang diiterasi
                lastRepeatPosition = map.get(s.charAt(i));
            }

            // Jika indeks sekarang dikurang dengan maxLen
            // yang berarti panjang substring sekarang lebih besar dari maxLen
            if((i - lastRepeatPosition) > maxLen) {
                // mengubah maxLen menjadi panjang substring sekarang
                maxLen = i - lastRepeatPosition;
            }
            // memasukkan karakter dan indeksnya ke hashmap
            map.put(s.charAt(i), i);
        }

        // mengembalikan maxLen
        return maxLen;
    }

    public static void main(String[] args) {
        Leetcode3 lc = new Leetcode3();
        System.out.println(lc.lengthOfLongestSubstring("abcabcbb"));
    }
}
