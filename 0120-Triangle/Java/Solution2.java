import java.util.List;

/**
 * @author mengld
 * @create 2021-03-18 9:53
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        final int N = triangle.size() - 1;
        int[][] minSumArr = new int[N + 1][];
        for (int i = 0; i < N + 1; i ++) {
            minSumArr[i] = new int[triangle.get(i).size()];
        }

        for (int j = 0; j < minSumArr[N].length; j ++) {
            minSumArr[N][j] = triangle.get(N).get(j);
        }

        for (int i = N - 1; i >= 0; i --) {
            for (int j = 0; j < minSumArr[i].length; j ++) {
                int x = minSumArr[i + 1][j];
                int y = minSumArr[i + 1][j + 1];
                minSumArr[i][j] = Math.min(x, y) + triangle.get(i).get(j);
            }
        }

        return minSumArr[0][0];
    }
}
