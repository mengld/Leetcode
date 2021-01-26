import java.util.HashMap;

class Solution {
    public int findRepeatNumber(int[] nums) {

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, true);
            }
            else
                return num;
        }

        return -1;
    }
}
