import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList; // Add this import statement
import java.util.HashMap;

public class Leetcode380 {
    Map<Integer, Integer> valToIndex;
    List<Integer> value;
    Random rand = new Random();

    public Leetcode380() {
        valToIndex = new HashMap<>();
        value = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, value.size());
        value.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }

        int index = valToIndex.get(val);
        int lastVal = value.get(value.size() - 1);
        value.set(index, lastVal);
        valToIndex.put(lastVal, index);
        value.remove(value.size() - 1);
        valToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        return value.get(rand.nextInt(value.size()));
    }

    public static void main(String[] args) {
        Leetcode380 obj = new Leetcode380();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}
