

public class Leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        // inisiasi prefix dengan string kosong
        String prefix = "";
        // iterasi untuk mengambil karakter dari string pertama
        for(int i = 0; i < strs[0].length(); i++) {
            // patokan untuk menyimpan karakter dari string pertama
            String patokan = strs[0].substring(0, i + 1);
            // boolean untuk menyimpan apakah semua string memiliki prefix yang sama
            boolean isSame = true;
            // iterasi untuk membandingkan prefix dengan string lainnya
            for(int j=1; j < strs.length; j++) {
                // jika string lainnya tidak memiliki prefix yang sama dengan patokan
                if(!strs[j].startsWith(patokan)) {
                    // mengubah isSame menjadi false
                    isSame = false;
                    break;
                }
            }
            // jika isSame masih false maka mengembalikan prefix
            if(!isSame) {
                return prefix;
            }
            // jika isSame masih true maka mengubah prefix menjadi patokan
            prefix = patokan;
        }

        return prefix;
    }

    public static void main(String[] args) {
        Leetcode14 lc = new Leetcode14();
        String[] strs = {"flower","flow","flight"};
        System.out.println(lc.longestCommonPrefix(strs));
    }
}
