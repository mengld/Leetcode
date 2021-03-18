import java.util.List;

/**
 * @author mengld
 * @create 2021-03-18 9:53
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        final int N = triangle.size() - 1;
        List<Integer> list = triangle.get(N);

        for (int i = N - 1; i >= 0; i --) {
            for (int j = 0; j <= i; j ++) {
                list.set(j, Math.min(list.get(j), list.get(j + 1)) + triangle.get(i).get(j));
            }
        }

        return list.get(0);
    }
}
