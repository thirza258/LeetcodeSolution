public class Leetcode1071 {
    public static String gcdOfStrings(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }
        String shorter = s.length() <= t.length() ? s : t;

        for (int len = shorter.length(); len >= 1; len--) {
            if (s.length() % len != 0 || t.length() % len != 0) {
                continue;
            }

            String candidate = shorter.substring(0, len);

            if (divides(s, candidate) && divides(t, candidate)) {
                return candidate;
            }
        }

        return "";
    }

    private static boolean divides(String full, String part) {
        int partLen = part.length();

        for (int i = 0; i < full.length(); i++) {
            if (full.charAt(i) != part.charAt(i % partLen)) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
