public class Leetcode28 {
    public int strStr(String haystack, String needle) {
        // Jika needle kosong dan haystack kosong, return 0
        if(haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }

        // Jika needle kosong, return -1 karena tidak ada needle
        if(needle.length() == 0) {
            return -1;
        }

        // Jika haystack kosong, return -1 karena tidak ada haystack
        if(haystack.length() == 0) {
            return -1;
        }

        // Membuat array dari string yang berisi character dari haystack dan needle
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        // Mencari needle di haystack dengan mengiterasi setiap character di haystack
        for(int i = 0; i < haystackArray.length; i++) {
            // Jika ada character yang sama di haystack dan needle, maka cek apakah needle ada di haystack
            if(haystackArray[i] == needleArray[0]) {
                // Mengiterasi setiap character di needle
                int j = 0;
                for(; j < needleArray.length; j++) {
                    // Jika sudah mencapai akhir dari haystack, return -1 karena tidak ada needle
                    if(i + j >= haystackArray.length) {
                        return -1;
                    }
                    // Jika ada character yang tidak sama di needle dan haystack, break
                    if(haystackArray[i + j] != needleArray[j]) {
                        break;
                    }
                }
                // Jika j sama dengan panjang needle, maka return i karena needle ada di haystack
                if(j == needleArray.length) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode28 leetcode28 = new Leetcode28();
        System.out.println(leetcode28.strStr("mississippi", "issip"));
    }
}
