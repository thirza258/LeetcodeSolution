public class Leetcode12 {
    public String intToRoman(int num) {
        String [] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String result = "";

        for(int i = 0; num!=0; i++) {
            while(num >= value[i]) {
                num -= value[i];
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
