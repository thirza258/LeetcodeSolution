public class Leetcode125 {
    public boolean isPalindrome(String s) {
        // Jika s kosong atau panjangnya 1, return true
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }

        // Mengambil character pertama dan terakhir dari s
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        // Jika ada spasi atau karakter lain di awal, maka cek kembali dengan menambahkan 1 ke awal
        if(!Character.isLetter(first) && !Character.isDigit(first)) {
           
            return isPalindrome(s.substring(1, s.length()));
            
        }
        // Jika ada spasi atau karakter lain di akhir, maka cek kembali dengan mengurangi 1 dari akhir
        if(!Character.isLetter(last) && !Character.isDigit(last)) {
            
            return isPalindrome(s.substring(0, s.length() - 1));
            
        }
        // Jika character pertama dan terakhir tidak sama, return false
        if (Character.toLowerCase(first) != Character.toLowerCase(last)) {
          
            return false;
            
        }

        // Jika character pertama dan terakhir sama, maka cek kembali dengan mengambil substring dari 1 ke akhir - 1
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public boolean helper(String n) {
        if (n.isEmpty() || n.length() == 1) {
            return true;
        }

        char first = n.charAt(0);
        char last = n.charAt(n.length() - 1);
        if(!Character.isLetter(first) && !Character.isDigit(first)) {
            System.out.println(first + "" + last);
            return helper(n.substring(1, n.length()));
            
        }
        if(!Character.isLetter(last) && !Character.isDigit(last)) {
            System.out.println(first + "" + last);
            return helper(n.substring(0, n.length() - 1));
            
        }
        if (Character.toLowerCase(first) != Character.toLowerCase(last)) {
            System.out.println(first + "" + last);
            return false;
            
        }

        System.out.println(first + "" + last);
        return helper(n.substring(1, n.length() - 1));
    }

    public static void main(String[] args) {
        Leetcode125 leetcode125 = new Leetcode125();
        System.out.println(leetcode125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(leetcode125.isPalindrome("race a car"));
    }
}
