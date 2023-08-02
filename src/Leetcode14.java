

public class Leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for(int i = 0; i < strs[0].length(); i++) {
            String patokan = strs[0].substring(0, i + 1);
            boolean isSame = true;
            for(int j=1; j < strs.length; j++) {
                if(!strs[j].startsWith(patokan)) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame) {
                return prefix;
            }
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
