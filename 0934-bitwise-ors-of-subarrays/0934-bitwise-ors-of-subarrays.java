import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {
            Set<Integer> cur = new HashSet<>();
            cur.add(num);
            for (int p : prev) {
                cur.add(p | num);
            }
            result.addAll(cur);
            prev = cur;
        }

        return result.size();
    }
}