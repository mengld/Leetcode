import java.util.List;

/**
 * @author mengld
 * @create 2021-03-18 9:53
 */
class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] minSumArr = new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i ++) {
            minSumArr[i] = new int[triangle.get(i).size()];
        }

        for (int i = 0; i < minSumArr.length; i ++) {
            for (int j = 0; j < minSumArr[i].length; j ++) {
                minSumArr[i][j] = -1;
            }
        }

        return minSum(triangle, minSumArr, 0, 0);
    }


    private int minSum(List<List<Integer>> triangle, int[][] minSumArr, int i, int j) {
        if (minSumArr[i][j] != -1)
            return minSumArr[i][j];

        if (i == triangle.size() - 1)
            minSumArr[i][j] = triangle.get(i).get(j);
        else {
            int x = minSum(triangle, minSumArr, i + 1, j);
            int y = minSum(triangle, minSumArr, i + 1, j + 1);
            minSumArr[i][j] = Math.min(x, y) + triangle.get(i).get(j);
        }

        return minSumArr[i][j];
    }
}
