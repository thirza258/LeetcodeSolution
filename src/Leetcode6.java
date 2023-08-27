import java.util.ArrayList;
import java.util.List;

public class Leetcode6 {
    /*
     * ZigZag Conversion
     * contoh kasus adalah PAYPALISHIRING dengan numRows 3
     */
    public String convert(String s, int numRows) {
        // Jika numRows kurang dari 1 atau numRows lebih besar dari panjang string s
        // karena PAYPALISHIRING dengan numRows 3 memiliki panjang 14 maka tidak masuk ke if
        if(numRows <= 1 || numRows >= s.length()) {
            // mengembalikan string s
            return s;
        }

        // membuat string builder array dengan panjang numRows atau berjumlah baris yang diinput
        // listRows berukuran 3
        StringBuilder[] listRows = new StringBuilder[numRows];
        // iterasi untuk membuat string builder array
        // listRows[0] = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
                listRows[i] = new StringBuilder();
        }

        // row untuk menyimpan baris yang sedang diiterasi
        int row = 0;
        // direction untuk menyimpan arah baris yang sedang diiterasi
        int direction = -1;

        // iterasi untuk mengisi string builder array dengan karakter dari string s sesuai zigzag
        for(int i = 0; i < s.length(); i++) {
            // jika row sekarang adalah baris terakhir atau baris pertama jika baris pertama direction menjadi 1 
            // dan jika baris terakhir direction menjadi -1
            // karena row sama dengan i atau 0 maka direction = 1
            if(row == numRows - 1 || row == 0) {
                // mengubah arah direction
                direction *= -1;
            }

            // memasukkan karakter dari string s ke string builder array sesuai zigzag
            // listRows[0] memiliki karakter P
            listRows[row].append(s.charAt(i));

            // jika direction sedang 1 atau row atas dan paling bawah maka row ditambah unutk berpindah
            // karena direction = 1 maka row ditambah 1
            if(direction == 1) {
                row++;
            } else {
                row--;
            }
        }

        // membuat string builder untuk menyimpan hasil
        StringBuilder result = new StringBuilder();

        // iterasi untuk menggabungkan string builder array menjadi string builder
        for(int i = 0; i < numRows; i++) {
            result.append(listRows[i]);
        }

        return result.toString();

    }

    public static void main(String[] args) {
        Leetcode6 lc = new Leetcode6();
        // contoh kasus adalah PAYPALISHIRING dengan numRows 3
        System.out.println(lc.convert("PAYPALISHIRING", 3));
    }
}
