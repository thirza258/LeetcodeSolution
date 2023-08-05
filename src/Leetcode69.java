public class Leetcode69 {
    public int mySqrt(int x) {
        //Jika x kurang dari nol maka tidak punya akar
        if(x <= 0) {
            return 0;
        }

        //membuat akar terbesar yang mungkin dari x adalah x/2 + 1 atau akar tidak mungkin lebih dari setengah dari x + 1
        int akar_terbesar = x/2 + 1;
        // untuk mencari akar dari x, kita hanya perlu mencari dari 0 sampai akar_terbesar
        int helper = 0;

        //selama helper kurang dari akar_terbesar, kita akan mencari akar dari x
        while(helper <= akar_terbesar) {
            //mencari nilai tengah dari x dengan menggunakan rumus (helper + (akar_terbesar - helper)/2)
            int median = helper + (akar_terbesar - helper)/2;
            //mencari nilai kuadrat dari median
            long akar = (long)median * (long) median;
            //Jika nilai kuadrat dari median sama dengan x, maka median adalah akar dari x
            if (akar == x) {
                return median;
            }
            //Jika nilai kuadrat dari median lebih kecil dari x, maka nilai akar terbesar adalah median + 1
            if(akar < x) {
                helper = median + 1;
            }
            //Jika nilai kuadrat dari median lebih besar dari x, maka nilai akar terbesar adalah median - 1
            else {
                akar_terbesar = median - 1;
            }
        }
        return akar_terbesar;
    }

    public static void main(String[] args) {
        Leetcode69 lc = new Leetcode69();
        System.out.println(lc.mySqrt(8));
    }
}
