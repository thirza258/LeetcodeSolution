
import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        //membuat list yang berisi list integer
        List<List<Integer>> result = new ArrayList<>();

        //untuk setiap baris
        for (int i = 0; i < numRows; i++) {
            //membuat list integer
            List<Integer> current = new ArrayList<>();

            //jika i = 0, maka akan diisi dengan 1 atau ujung atas segitiga
            if (i==0) {
                current.add(1);
            }
            else {
                //membuat list integer yang berisi list integer sebelumnya
                List<Integer> previous = result.get(i-1);
                //menambahkan 1 di ujung kiri
                current.add(1);
                // untuk setiap nilai j mulai dari 1 sampai i atau j kurang dari nilai baris yang sedang diisi
                for (int j = 1; j < i; j++) {
                    //nilai yang diisi adalah nilai sebelumnya ditambah nilai sebelumnya
                    int nilaiDiIsi = previous.get(j-1) + previous.get(j);
                    //nilai yang diisi akan ditambahkan ke list integer yang sedang diisi
                    current.add(nilaiDiIsi);
                }
                //menambahkan 1 di ujung kanan
                current.add(1);
            }
            //hasil tadi akan ditambahkan ke list integer yang berisi list integer
            result.add(current);
        }

        return result;
    }
}
