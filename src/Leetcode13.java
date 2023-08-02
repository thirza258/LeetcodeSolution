

public class Leetcode13 {
    public int romanToInt(String s) {
        int integer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i + 1 < s.length()) {
                if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                    integer += 4;
                    i++;
                    continue;
                } else if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                    integer += 9;
                    i++;
                    continue;
                } else if(s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                    integer += 40;
                    i++;
                    continue;
                } else if(s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                    integer += 90;
                    i++;
                    continue;
                } else if(s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                    integer += 400;
                    i++;
                    continue;
                } else if(s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                    integer += 900;
                    i++;
                    continue;
                }
            }
            if (s.charAt(i) ==  'I') {
                integer += 1;
            } else if (s.charAt(i) == 'V') {
                integer += 5;
            } else if (s.charAt(i) == 'X') {
                integer += 10;
            } else if (s.charAt(i) == 'L') {
                integer += 50;
            } else if (s.charAt(i) == 'C') {
                integer += 100;
            } else if (s.charAt(i) == 'D') {
                integer += 500;
            } else if (s.charAt(i) == 'M') {
                integer += 1000;
            }
        }
        return integer;
    }

    public int helper(char c) {
        if (c ==  'I') {
            return 1;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'D') {
            return 500;
        } else if (c == 'M') {
            return 1000;
        }
        return 0;
    }

    public int romanInt(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        int integer = helper(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            int prev = helper(s.charAt(i - 1));
            int curr = helper(s.charAt(i));
            if (prev < curr) {
                integer = integer - prev + (curr - prev);
            } else {
                integer += curr;
            }
        }
        return integer;
    }

    public static void main(String[] args) {
        Leetcode13 l = new Leetcode13();
        System.out.println(l.romanInt("III"));
        System.out.println(l.romanInt("IV"));
        System.out.println(l.romanInt("IX"));
        System.out.println(l.romanInt("LVIII"));
        System.out.println(l.romanInt("MCMXCIV"));
    }
}