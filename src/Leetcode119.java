import java.util.List;
import java.util.ArrayList;

public class Leetcode119 {
     public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>(rowIndex+1);
        
        // mengisi nilai 0 di semua index dari list
        for (int i = 0; i <= rowIndex; i++) {
            result.add(0);
        }

        // mengeset index pertama dari list menjadi 1
        result.set(0,1);

        // mengeinterasi sampai rowIndex
        for (int i=0; i < rowIndex; i++) {
            // loop untuk mengisi nilai dari segitiga 
            for(int j = i+1; j > 0; j--) {
                // mengeset nilai dari index j dengan nilai dari index j ditambah nilai dari index j-1
                result.set(j, result.get(j) + result.get(j-1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode119 lc = new Leetcode119();
        List<Integer> result = lc.getRow(3);
        System.out.println(result);
    }
}
