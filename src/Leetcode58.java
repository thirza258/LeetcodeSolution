public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        // jika panjang string 0 maka langsung mengembalikan nilai 0
        if (s.length() == 0) {
            return 0;
        }

        // mengeset nilai panjang kata dan count dengan 0 untuk inisialisasi
        int panjangKata = 0;
        int count = 0;

        // mengiterasi string s
        for(int i = 0; i < s.length(); i++) {
            // mengambil karakter dari string s
            char c = s.charAt(i);
            // Jika karakter merupakan huruf maka hitungan ditambahkan dengan 1
            if(Character.isLetter(c)) {
                count++;
            }
            // Jika karakter bukan merupakan huruf 
            if (!Character.isLetter(c)) {
                // jika hitungan lebih dari 0 maka panjang kata diisi dengan nilai hitungan 
                if(count > 0) {
                    panjangKata = count;
                }
                // mengeset nilai hitungan dengan 0
                count = 0;
            }
        }

        // jika hitungan lebih dari 0 maka mengembalikan nilai hitungan
        if (count > 0) {
            return count;
        }
        return panjangKata;
    }
}

/*
 * panjang 30 lebar 10
 * 
 */