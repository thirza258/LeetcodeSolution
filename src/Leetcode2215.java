import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums1.length == 0 && nums2.length == 0) {
            result.add(new ArrayList<>());
            result.add(new ArrayList<>());
            return result;
        }

        HashMap<Integer, Boolean> map1 = new HashMap<>();
        HashMap<Integer, Boolean> map2 = new HashMap<>();

        for(int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], true);
        }

        for(int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], true);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(Integer key : map1.keySet()) {
            if(!map2.containsKey(key)) {
                list1.add(key);
            }
        }

        for(Integer key : map2.keySet()) {
            if(!map1.containsKey(key)) {
                list2.add(key);
            }
        }

        result.add(list1);
        result.add(list2);
        return result;
    }
}
