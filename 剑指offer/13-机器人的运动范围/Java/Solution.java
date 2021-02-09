class Solution {
    private boolean[][] isVisited;

    public int movingCount(int m, int n, int k) {

        isVisited = new boolean[m][n];
        return moving(m, n, k, 0, 0);
    }

    private int moving(int m, int n, int k, int i, int j) {

        if (i < 0 || i >= isVisited.length || j < 0 || j >= isVisited[0].length || isVisited[i][j])
            return 0;
        isVisited[i][j] = true;

        int copy_i = i, copy_j = j;
        int sum = 0;
        while (copy_i != 0 && copy_j != 0) {
            sum += copy_i%10;
            sum += copy_j%10;
            copy_i /= 10;
            copy_j /= 10;
        }
        while (copy_i != 0) {
            sum += copy_i%10;
            copy_i /= 10;
        }
        while (copy_j != 0) {
            sum += copy_j%10;
            copy_j /= 10;
        }

        if (sum > k) {
            return 0;
        } else {
            return 1 + moving(m, n, k, i + 1, j) + moving(m, n, k, i - 1, j)
                    + moving(m, n, k, i, j - 1) + moving(m, n, k, i, j + 1);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(3, 1, 0));
    }
}
