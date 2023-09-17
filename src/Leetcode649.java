import java.util.LinkedList;
import java.util.Queue;

public class Leetcode649 {
    public String predictPartyVictory(String senate) {
        // Mmebuat queue untuk menampung index dari masing-masing senator
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Memasukkan index sesuai tim senatornya
        for(int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i); 
            }
        }

        // Selama salah satunya belum kosong maka akan terus berjalan
        while(!radiant.isEmpty() && !dire.isEmpty()) {
            // Mengambil index dari masing-masing tim
            int radiantIndex = radiant.poll();
            int direIndex = dire.poll();

            // Jika index dari radiant lebih kecil dari dire
            // maka akan kembali ke ujung queue dengan indexnya menjadi lebih besar dari sebelumnya
            if(radiantIndex < direIndex) {
                radiant.add(radiantIndex + senate.length());
            } else {
                dire.add(direIndex + senate.length());
            }
        }

        if(radiant.isEmpty()) {
            return "Dire";
        } else {
            return "Radiant";
        }

    }

    public static void main(String[] args) {
        Leetcode649 lc = new Leetcode649();
        String senate = "RDD";
        System.out.println(lc.predictPartyVictory(senate));
    }
}
