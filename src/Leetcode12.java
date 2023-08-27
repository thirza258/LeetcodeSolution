public class Leetcode12 {
    public String intToRoman(int num) {
        // Membuat array yang berisi angka romawi
        String [] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        // membuat array yang berisi angka desimal
        int [] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        // membuat variabel result untuk menyimpan hasil
        String result = "";

        // iterasi untuk mengubah angka desimal menjadi angka romawi
        for(int i = 0; num!=0; i++) {
            // selama num lebih besar dari nilai di indeks i
            while(num >= value[i]) {
                // maka num dikurangi dengan nilai di indeks i
                num -= value[i];
                // dan result ditambah dengan angka romawi di indeks i
                result += roman[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode12 leetcode12 = new Leetcode12();
        System.out.println(leetcode12.intToRoman(3));
    }
}
