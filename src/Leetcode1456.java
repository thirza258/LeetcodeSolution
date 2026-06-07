public class Leetcode1456 {
    public int maxVowels(String s, int k) {
        if(s.length()<k){
            return 0;
        }

        int current = 0;
        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))){
                current++;
            }
        }

        if (k >= s.length()) {
            return current;
        }

        int max = current;

        for(int i=k; i < s.length(); i++){
            char c = s.charAt(i);
            char contrib = s.charAt(i-k);
            if(isVowel(contrib)) {
                current--;
            }
            if(isVowel(c)) {
                current++;
            }
            if(max == k) {
                return max;
            }
            max = Math.max(max, current);
        }
        return max;
    }

    public boolean isVowel(Character c1){
        Character[] vowels = {'a','e','i','o','u'};

        for(Character c2 : vowels){
            if(c1.toString().equalsIgnoreCase(c2.toString())){
                return true;
            }
        }
        return false;
    }
}
