public class Leetcode1768 {
    public String mergeAlternately(String word1, String word2) {
        // inisialisasi panjang dari string
        int lengthWord1 = word1.length();
        int lengthWord2 = word2.length();
        int realLength = Math.min(lengthWord1, lengthWord2);

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < realLength; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }

        if(lengthWord1 > lengthWord2) {
            result.append(word1.substring(realLength));
        } else if(lengthWord1 < lengthWord2) {
            result.append(word2.substring(realLength));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Leetcode1768 lc = new Leetcode1768();
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(lc.mergeAlternately(word1, word2));
        
    }
}
